package com.example.admin.soundcloud_13.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.TrackListener;
import com.example.admin.soundcloud_13.screen.play.PlayActivity;

import java.util.List;

public class TrackService extends Service {
    public static final String ACTION_CHANGE_STATE = "ACTION_CHANGE_STATE";
    public static final String ACTION_NEXT_TRACK = "ACTION_NEXT_TRACK";
    public static final String ACTION_PREVIOUS_TRACK = "ACTION_PREVIOUS_TRACK";
    public static final int SECONDS_FACTOR = 1000;

    private static final int NOTIFY_ID = 1;
    private TrackPlayerManager mTrackPlayerManager;

    private final IBinder mIBinder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handleIntend(intent);
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        handleIntend(intent);
        return mIBinder;
    }

    public void handleIntend(Intent intent) {
        if (intent == null || intent.getAction() == null) return;
        switch (intent.getAction()) {
            case ACTION_CHANGE_STATE:
                changeState();
            case ACTION_NEXT_TRACK:
                playNextTrack();
            case ACTION_PREVIOUS_TRACK:
                playPreviousTrack();
        }
    }

    public int getState() {
        if (mTrackPlayerManager == null) return 0;
        return mTrackPlayerManager.getCurrentState();
    }

    public void playPreviousTrack() {
        mTrackPlayerManager.playPreviousTrack();
    }

    public void playNextTrack() {
        mTrackPlayerManager.playNextTrack();
    }

    public void changeState() {
        mTrackPlayerManager.changeState();
    }

    public void seekTo(int percent) {
        mTrackPlayerManager.seekTo(percent);
    }

    public int getCurrentTrackPosition() {
        if (mTrackPlayerManager == null) return 0;
        return mTrackPlayerManager.getCurrentTrackPosition();
    }

    public Track getCurrentTrack() {
        if (mTrackPlayerManager == null) return null;
        return mTrackPlayerManager.getCurrentTrack();
    }

    public List<Track> getListTracks() {
        if (mTrackPlayerManager == null) return null;
        return mTrackPlayerManager.getListTracks();
    }

    public void playTrackAtPosition(List<Track> tracks, int positition) {
        if (mTrackPlayerManager == null) {
            mTrackPlayerManager = new TrackPlayerController(this);
        }
        mTrackPlayerManager.playTrackAtPosition(tracks, positition);
    }

    public int getLoopType() {
        if (mTrackPlayerManager == null) return 0;
        return mTrackPlayerManager.getLoopType();
    }

    public void changeLoopType() {
        if (mTrackPlayerManager == null) return;
        mTrackPlayerManager.changeLoopType();
    }

    public int getShuffleState() {
        if (mTrackPlayerManager == null) return 0;
        return mTrackPlayerManager.getShuffleState();
    }

    public void changeShuffleState() {
        if (mTrackPlayerManager == null) return;;
        mTrackPlayerManager.changeShuffleState();
    }

    public int getCurrentPositition() {
        if (mTrackPlayerManager == null) return 0;
        return mTrackPlayerManager.getCurrentPosition();
    }

    public int getFullDuration() {
        if (mTrackPlayerManager == null) return 0;
        return mTrackPlayerManager.getFullDuration();
    }

    public void setTrackListener(TrackListener listener) {
        if (mTrackPlayerManager == null) return;
        mTrackPlayerManager.setTrackListener(listener);
    }

    public class LocalBinder extends Binder {
        public TrackService getService() {
            return TrackService.this;
        }
    }
}
