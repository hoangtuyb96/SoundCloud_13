package com.example.admin.soundcloud_13.screen.play;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.constant.Constants;
import com.example.admin.soundcloud_13.constant.LoopType;
import com.example.admin.soundcloud_13.constant.ShuffleState;
import com.example.admin.soundcloud_13.constant.State;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.BaseActivity;
import com.example.admin.soundcloud_13.screen.TrackListener;
import com.example.admin.soundcloud_13.service.TrackService;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayActivity extends BaseActivity implements PlayContract.View, View.OnClickListener,
        TrackListener {
    private ImageView mImageViewPlay;
    private SeekBar mSeekBar;
    private TextView mTextViewTitlePlay;
    private TextView mTextViewArtistPlay;
    private ImageView mImageViewPrevious;
    private ImageView mImageViewNext;
    private ImageView mImageViewState;
    private ImageView mImageViewShuffle;
    private ImageView mImageViewLoop;
    private List<Track> mTracks;
    private Track mCurrentTrack;
    private int mPosition;
    private PlayContract.Presenter mPresenter;
    private TrackService mTrackService;
    private ServiceConnection mServiceConnection;
    private boolean mBound;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        getDataFromIntent();
        mPresenter = new PlayPresenter();
        mPresenter.setView(this);
        initComponents();
        initListener();
        connectService();
        Intent intent = new Intent(this, TrackService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        if (mTrackService == null) return;
        switch (view.getId()) {
            case R.id.image_view_previous:
                mTrackService.playPreviousTrack();
                break;
            case R.id.image_view_next:
                mTrackService.playNextTrack();
                break;
            case R.id.image_view_state:
                mTrackService.changeState();
                break;
            case R.id.image_view_shuffle:
                mTrackService.changeShuffleState();
                break;
            case R.id.image_view_loop:
                mTrackService.changeLoopType();
                break;
            default:
                break;
        }
    }

    private void getDataFromIntent() {
        mTracks = (List<Track>) getIntent().getSerializableExtra(Constants.EXTRA_LIST_TRACK);
        mPosition = getIntent().getIntExtra(Constants.EXTRA_POSITION_TRACK, 0);
    }

    private void initComponents() {
        mImageViewPlay = findViewById(R.id.image_view_play);
        mSeekBar = findViewById(R.id.seek_bar);
        mTextViewTitlePlay = findViewById(R.id.text_view_title_play);
        mTextViewArtistPlay = findViewById(R.id.text_view_artist_play);
        mImageViewPrevious = findViewById(R.id.image_view_previous);
        mImageViewNext = findViewById(R.id.image_view_next);
        mImageViewState = findViewById(R.id.image_view_state);
        mImageViewShuffle = findViewById(R.id.image_view_shuffle);
        mImageViewLoop = findViewById(R.id.image_view_loop);
    }

    private void initListener() {
        mImageViewPrevious.setOnClickListener(this);
        mImageViewNext.setOnClickListener(this);
        mImageViewState.setOnClickListener(this);
        mImageViewShuffle.setOnClickListener(this);
        mImageViewLoop.setOnClickListener(this);
    }

    private void connectService() {
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder service) {
                mBound = true;
                mTrackService = ((TrackService.LocalBinder) service).getService();
                mTrackService.playTrackAtPosition(mTracks, mPosition);
                mTrackService.setTrackListener(PlayActivity.this);
                mCurrentTrack = mTrackService.getCurrentTrack();
                updateTrack();
                updateState(mTrackService.getState());
                updateShuffleState(mTrackService.getShuffleState());
                updateLoopState(mTrackService.getLoopType());
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                mBound = false;
            }
        };
    }

    private void updateTrack() {
        Picasso.get().load(mCurrentTrack.getArtworkUrl()).placeholder(R.drawable.image_default).into(mImageViewPlay);
        mTextViewTitlePlay.setText(mCurrentTrack.getTitle());
        mTextViewArtistPlay.setText(mCurrentTrack.getTitle());
    }

    private void updateState(@State int state) {
        switch (state) {
            case State.PAUSE:
                mImageViewState.setImageDrawable(getResources().getDrawable(R.drawable.play_button));
                break;
            case State.PLAYING:
                mImageViewState.setImageDrawable(getResources().getDrawable(R.drawable.pause_button));
                break;
            default:
                break;
        }
    }

    private void updateShuffleState(@ShuffleState int shuffleState) {
        switch (shuffleState) {
            case ShuffleState.OFF:
                mImageViewShuffle.setImageDrawable(getResources().getDrawable(R.drawable.crossed_arrows));
                break;
            case ShuffleState.ON:
                mImageViewShuffle.setImageDrawable(getResources().getDrawable(R.drawable.crossed_arrows_disable));
                break;
            default:
                break;
        }
    }

    private void updateLoopState(@LoopType int loopType) {
        switch (loopType) {
            case LoopType.NO_LOOP:
                mImageViewLoop.setImageDrawable(getResources().getDrawable(R.drawable.replay));
                break;
            case LoopType.LOOP_ALL:
                mImageViewLoop.setImageDrawable(getResources().getDrawable(R.drawable.replay_one));
                break;
            case LoopType.LOOP_ONE:
                mImageViewLoop.setImageDrawable(getResources().getDrawable(R.drawable.replay_off));
                break;
            default:
                break;
        }
    }

    @Override
    public void onTrackChanged(Track track) {
        mCurrentTrack = track;
        updateTrack();
    }

    @Override
    public void onStateChanged(int state) {
        updateState(state);
    }

    @Override
    public void onShuffleChanged(int shuffleState) {
        updateShuffleState(shuffleState);
    }

    @Override
    public void onLoopChanged(int loopState) {
        updateLoopState(loopState);
    }
}
