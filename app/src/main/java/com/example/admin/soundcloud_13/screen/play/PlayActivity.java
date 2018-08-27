package com.example.admin.soundcloud_13.screen.play;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.BaseActivity;

public class PlayActivity extends BaseActivity implements PlayContract.View, View.OnClickListener {
    private ImageView mImageViewPlay;
    private SeekBar mSeekBar;
    private TextView mTextViewTitlePlay;
    private TextView mTextViewArtistPlay;
    private ImageView mImageViewPrevious;
    private ImageView mImageViewNext;
    private ImageView mImageViewState;
    private ImageView mImageViewShuffle;
    private ImageView mImageViewLoop;
    private Track mCurrentTrack;
    private PlayContract.Presenter mPresenter;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mPresenter = new PlayPresenter();
        mPresenter.setView(this);
        initComponents();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View view) {
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
}
