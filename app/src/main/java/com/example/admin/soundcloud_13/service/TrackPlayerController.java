package com.example.admin.soundcloud_13.service;

import android.media.AudioManager;
import android.media.MediaPlayer;

import com.example.admin.soundcloud_13.constant.LoopType;
import com.example.admin.soundcloud_13.constant.ShuffleState;
import com.example.admin.soundcloud_13.constant.State;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.TrackListener;
import com.example.admin.soundcloud_13.utils.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackPlayerController implements TrackPlayerManager {
    private final static long DELAY_MILLIS = 500;
    @State
    private int mState;
    @LoopType
    private int mLoopType = LoopType.NO_LOOP;
    @ShuffleState
    private int mShuffleState;

    private MediaPlayer mMediaPlayer;
    private TrackService mTrackService;
    private int mCurrentTrackPosition;
    private TrackListener mTrackListener;
    private List<Track> mTracks;
    private List<Track> mTracksOriginal;

    public TrackPlayerController(TrackService trackService) {
        this.mTrackService = trackService;
    }

    private final MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            mMediaPlayer.start();
            notifyStateChange(State.PLAYING);
        }
    };

    private final MediaPlayer.OnErrorListener mOnErrorListener = new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
            return true;
        }
    };

    private final MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            notifyStateChange(State.PAUSE);
        }
    };

    @Override
    public int getCurrentState() {
        return mState;
    }

    @Override
    public void playNextTrack() {
        if (mCurrentTrackPosition < mTracks.size()-1) {
            mCurrentTrackPosition++;
            prepareTrack();
        }
    }

    @Override
    public void playPreviousTrack() {
        if (mCurrentTrackPosition > 0) {
            mCurrentTrackPosition --;
            prepareTrack();
        }
    }

    @Override
    public void changeState() {
        if (mMediaPlayer == null) return;
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            notifyStateChange(State.PAUSE);
        } else {
            mMediaPlayer.start();
            notifyStateChange(State.PLAYING);
        }
    }

    @Override
    public void release() {
        if (mMediaPlayer == null) return;
        mMediaPlayer.release();
        mMediaPlayer = null;
    }

    @Override
    public void seekTo(int percent) {
        if (mState == State.PAUSE || mState == State.PLAYING) {
            mMediaPlayer.seekTo(mMediaPlayer.getDuration() / 100 * percent);
        }
    }

    @Override
    public int getCurrentTrackPosition() {
        return mCurrentTrackPosition;
    }

    @Override
    public Track getCurrentTrack() {
        if (mTracks == null) return null;
        return mTracks.get(getCurrentTrackPosition());
    }

    @Override
    public List<Track> getListTracks() {
        return mTracks;
    }

    @Override
    public void playTrackAtPosition(List<Track> tracks, int position) {
        if (mTracks == null && tracks == null) {
            notifyStateChange(State.INVALID);
            return;
        }
        if (tracks != null && tracks.size() != 0) {
            mTracks = new ArrayList<>();
            Track[] list = tracks.toArray(new Track[tracks.size()]);
            Collections.addAll(mTracks, list);
        } else {
            return;
        }

        mCurrentTrackPosition = position;
        prepareTrack();
    }

    @Override
    public int getLoopType() {
        return mLoopType;
    }

    @Override
    public void changeLoopType() {
        switch (mLoopType) {
            case LoopType.NO_LOOP:
                mLoopType = LoopType.LOOP_ALL;
                break;
            case LoopType.LOOP_ALL:
                mLoopType = LoopType.LOOP_ONE;
                break;
            case LoopType.LOOP_ONE:
                mLoopType = LoopType.NO_LOOP;
                break;
        }
        if (mTrackListener == null) return;
        mTrackListener.onLoopChanged(mLoopType);
    }

    @Override
    public int getShuffleState() {
        return mShuffleState;
    }

    @Override
    public void changeShuffleState() {
        Track currentTrack = null;
        switch (mShuffleState) {
            case ShuffleState.ON:
                mShuffleState = ShuffleState.OFF;
                currentTrack = mTracks.get(mCurrentTrackPosition);
                mTracks = new ArrayList<>();
                mTracks.addAll(mTracksOriginal);
                break;
            case ShuffleState.OFF:
                mShuffleState = ShuffleState.ON;
                currentTrack = mTracks.get(mCurrentTrackPosition);
                mTracksOriginal = new ArrayList<>();
                mTracksOriginal.addAll(mTracks);
                Collections.shuffle(mTracks);
                break;
        }
        if (mTrackListener == null) return;
        mTrackListener.onShuffleChanged(mShuffleState);
    }

    @Override
    public int getCurrentPosition() {
        if (mMediaPlayer == null) return 0;
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public int getFullDuration() {
        if (mMediaPlayer == null) return 0;
        return mMediaPlayer.getDuration();
    }

    private void notifyStateChange(int state) {
        if (mTrackListener == null) return;
        mTrackListener.onStateChanged(state);
    }

    private void prepareTrack() {
        if (mTracks == null) {
            notifyStateChange(State.INVALID);
            return;
        }
        release();
        notifyStateChange(State.PREPARE);
        loadTrack();
        if (mTrackListener == null) return;
        mTrackListener.onTrackChanged(mTracks.get(mCurrentTrackPosition));
    }

    private void loadTrack() {
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            String url = StringUtil.formatTrackStreamURL(mTracks.get(mCurrentTrackPosition).getUri());
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(mOnPreparedListener);
            mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            mMediaPlayer.setOnErrorListener(mOnErrorListener);
        } catch (IOException e) {
            notifyStateChange(State.INVALID);
            if (mCurrentTrackPosition < mTracks.size()) playNextTrack();
        }
    }

    @Override
    public void setTrackListener(TrackListener listener) {
        mTrackListener = listener;
    }
}
