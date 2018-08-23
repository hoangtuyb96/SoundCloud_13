package com.example.admin.soundcloud_13.screen.home.online;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.constant.Constants;
import com.example.admin.soundcloud_13.constant.GenreKey;
import com.example.admin.soundcloud_13.screen.BaseFragment;

public class GenreFragment extends BaseFragment {
    private String mGenre;
    private TextView mTitleGenreText;

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
        assert this.getArguments() != null;
        mGenre = this.getArguments().getString(Constants.GENRE_KEY);
        mTitleGenreText.setText(getTitle(mGenre));
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
}
