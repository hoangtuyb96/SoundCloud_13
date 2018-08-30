package com.example.admin.soundcloud_13.service;

import com.example.admin.soundcloud_13.constant.LoopType;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.TrackListener;

import java.util.List;

public interface TrackPlayerManager {
    int getCurrentState();

    void playNextTrack();

    void playPreviousTrack();

    void changeState();

    void release();

    void seekTo (int percent);

    Track getCurrentTrack();

    int getCurrentTrackPosition();

    List<Track> getListTracks();

    void playTrackAtPosition(List<Track> tracks, int position);

    @LoopType
    int getLoopType();

    void changeLoopType();

    @LoopType
    int getShuffleState();

    void changeShuffleState();

    int getCurrentPosition();

    int getFullDuration();

    void setTrackListener(TrackListener listener);
}
