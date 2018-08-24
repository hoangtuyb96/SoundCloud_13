package com.example.admin.soundcloud_13.data.source.local;

import com.example.admin.soundcloud_13.data.source.TrackDataSource;
import com.example.admin.soundcloud_13.screen.home.online.genre.GenrePresenter;

public class TrackLocalDataSource implements TrackDataSource.LocalDataSource{
    @Override
    public void fetchTracks(GenrePresenter.LoadTrackCallback callback, String genre, int limit, int offset) {
    }
}
