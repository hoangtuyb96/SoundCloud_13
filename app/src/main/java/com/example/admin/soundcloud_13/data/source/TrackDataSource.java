package com.example.admin.soundcloud_13.data.source;

import com.example.admin.soundcloud_13.screen.home.online.genre.GenrePresenter;

public interface TrackDataSource {
    interface LocalDataSource extends TrackDataSource {}
    interface RemoteDataSource extends TrackDataSource {}

    void fetchTracks(GenrePresenter.LoadTrackCallback callback,
                     String genre, int limit, int offset);
}
