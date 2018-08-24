package com.example.admin.soundcloud_13.screen.home.online.genre;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.constant.Constants;
import com.example.admin.soundcloud_13.constant.GenreKey;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenreFragment extends BaseFragment implements GenreContract.View {
    private String mGenre;
    private TextView mTitleGenreText;
    private GenreContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private TrackAdapter mTrackAdapter;

    public static Fragment newInstance(String genre) {
        GenreFragment genreFragment = new GenreFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.GENRE_KEY, genre);
        genreFragment.setArguments(bundle);
        return genreFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_genre, container, false);
        mTitleGenreText = rootView.findViewById(R.id.text_view_title_genre);
        mRecyclerView = rootView.findViewById(R.id.recycler_view_genre);
        assert this.getArguments() != null;
        mGenre = this.getArguments().getString(Constants.GENRE_KEY);
        mTitleGenreText.setText(getTitle(mGenre));
        mPresenter = new GenrePresenter();
        mPresenter.setView(this);
        mPresenter.onStart();
        mPresenter.startFetchTrack(mGenre, Constants.LIMIT_DEFAULT, Constants.OFFSET_DEFAULT);
        return rootView;
    }

    private String getTitle(String key) {
        switch (mGenre) {
            case GenreKey.ALL_AUDIO:
                return getResources().getString(R.string.all_audio_title);
            case GenreKey.ALTERNATIVE_ROCK:
                return getResources().getString(R.string.alternative_rock_title);
            case GenreKey.AMBIENT:
                return getResources().getString(R.string.ambient_title);
            case GenreKey.CLASSICAL:
                return getResources().getString(R.string.classical_title);
            case GenreKey.COUNTRY:
                return getResources().getString(R.string.country_title);
            default:
                return null;
        }
    }

    @Override
    public void showListTrack(List<Track> tracks) {
        mTrackAdapter.updateTrack((ArrayList<Track>) tracks);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initRecyclerViewTrack() {
        mTrackAdapter = new TrackAdapter(Objects.requireNonNull(getContext()));
        mRecyclerView.setAdapter(mTrackAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
