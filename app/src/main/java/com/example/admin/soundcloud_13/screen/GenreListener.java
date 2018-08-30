package com.example.admin.soundcloud_13.screen;

import com.example.admin.soundcloud_13.data.model.Track;

import java.util.List;

public interface GenreListener {
    void handlePlayTrack(List<Track> tracks, int position);
}
