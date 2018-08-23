package com.example.admin.soundcloud_13.screen.home.offline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.soundcloud_13.R;
import com.example.admin.soundcloud_13.screen.BaseFragment;

public class OfflineFragment extends BaseFragment implements OfflineContract.View {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offline,container,false);
        return rootView;
    }
}
