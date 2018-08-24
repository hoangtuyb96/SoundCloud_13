package com.example.admin.soundcloud_13.screen.home.online.genre;

import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.data.repository.TrackRepository;
import com.example.admin.soundcloud_13.data.source.remote.TrackRemoteDataSource;

import java.util.List;

public class GenrePresenter implements GenreContract.Presenter {
    GenreContract.View mView;
    TrackRepository mTrackRepository;

    @Override
    public void onStart() {
        mTrackRepository = new TrackRepository(new TrackRemoteDataSource());
        mView.initRecyclerViewTrack();
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setView(GenreContract.View view) {
        this.mView = view;
    }

    @Override
    public void startFetchTrack(String genre, int limit, int offset) {
        mTrackRepository.fetchTracks(new LoadTrackCallback() {
            @Override
            public void onComplete(List<Track> tracks) {
                mView.showListTrack(tracks);
            }
        }, genre, limit, offset);
    }

    public interface LoadTrackCallback {
        void onComplete(List<Track> tracks);
    }
}
