package com.example.admin.soundcloud_13.screen.home.online;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.constant.GenreKey;
import com.example.admin.soundcloud_13.screen.BaseFragment;
import com.example.admin.soundcloud_13.screen.home.online.genre.GenreFragment;

public class OnlineFragment extends BaseFragment implements OnlineContract.View {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_online, container, false);

        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout_online);
        ViewPager viewPager = rootView.findViewById(R.id.view_pager_online);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        GenrePagerAdapter genrePagerAdapter = new GenrePagerAdapter(getFragmentManager());
        genrePagerAdapter.addFragment(GenreFragment.newInstance
                (GenreKey.ALL_AUDIO), getResources().getString(R.string.all_audio_title));
        genrePagerAdapter.addFragment(GenreFragment.newInstance
                (GenreKey.ALTERNATIVE_ROCK), getResources().getString(R.string.alternative_rock_title));
        genrePagerAdapter.addFragment(GenreFragment.newInstance
                (GenreKey.AMBIENT),getResources().getString(R.string.ambient_title));
        genrePagerAdapter.addFragment(GenreFragment.newInstance
                (GenreKey.CLASSICAL), getResources().getString(R.string.classical_title));
        genrePagerAdapter.addFragment(GenreFragment.newInstance
                (GenreKey.COUNTRY), getResources().getString(R.string.country_title));
        viewPager.setAdapter(genrePagerAdapter);
    }
}
