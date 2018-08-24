package com.example.admin.soundcloud_13.screen.home.online.genre;

import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.BasePresenter;

import java.util.List;

public class GenreContract {
    interface View {
        void showListTrack(List<Track> trackList);
        void initRecyclerViewTrack();
    }

    interface Presenter extends BasePresenter<View> {
        void startFetchTrack(String genre, int limit, int offset);
    }
}
