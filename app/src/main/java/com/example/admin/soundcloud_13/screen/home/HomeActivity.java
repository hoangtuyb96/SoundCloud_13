package com.example.admin.soundcloud_13.screen.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.screen.BaseActivity;
import com.example.admin.soundcloud_13.screen.home.offline.OfflineFragment;
import com.example.admin.soundcloud_13.screen.home.online.OnlineFragment;

public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TabLayout tabLayout = findViewById(R.id.tab_layout_home);
        final ViewPager viewPager = findViewById(R.id.view_pager_home);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new OfflineFragment(), getResources().getString(R.string.your_library));
        pagerAdapter.addFragment(new OnlineFragment(),getResources().getString(R.string.online));
        viewPager.setAdapter(pagerAdapter);
    }
}
