package com.example.admin.soundcloud_13.screen;

public interface BasePresenter<T> {
    void setView(T view);

    void onStart();

    void onStop();
}
