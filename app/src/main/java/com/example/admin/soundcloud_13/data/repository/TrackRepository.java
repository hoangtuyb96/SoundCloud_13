package com.example.admin.soundcloud_13.data.repository;

import com.example.admin.soundcloud_13.data.source.TrackDataSource;
import com.example.admin.soundcloud_13.data.source.remote.TrackRemoteDataSource;
import com.example.admin.soundcloud_13.screen.home.online.genre.GenrePresenter;

public class TrackRepository implements TrackDataSource.LocalDataSource,
        TrackDataSource.RemoteDataSource {
    private TrackRemoteDataSource mTrackRemoteDataSource;

    public TrackRepository(TrackRemoteDataSource dataSource) {
        this.mTrackRemoteDataSource = dataSource;
    }

    @Override
    public void fetchTracks(GenrePresenter.LoadTrackCallback callback, String genre, int limit, int offset) {
        mTrackRemoteDataSource.fetchTracks(callback, genre, limit, offset);
    }
}
