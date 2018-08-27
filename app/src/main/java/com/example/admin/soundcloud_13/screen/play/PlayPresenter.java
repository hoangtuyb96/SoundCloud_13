package com.example.admin.soundcloud_13.screen.play;

public class PlayPresenter implements PlayContract.Presenter {
    PlayContract.View mView;

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setView(PlayContract.View view) {
        this.mView = view;
    }
}
