package com.example.admin.soundcloud_13.data.source.remote;

import com.example.admin.soundcloud_13.data.source.TrackDataSource;
import com.example.admin.soundcloud_13.screen.home.online.genre.GenrePresenter;
import com.example.admin.soundcloud_13.utils.StringUtil;

public class TrackRemoteDataSource implements TrackDataSource.RemoteDataSource{
    @Override
    public void fetchTracks(GenrePresenter.LoadTrackCallback callback,
                            String genre, int limit, int offset) {
        new FetchTrackFromApi(callback).execute(StringUtil.formatTrackUrl(genre, limit, offset));
    }
}
