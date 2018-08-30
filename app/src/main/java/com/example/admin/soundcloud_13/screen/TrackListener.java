package com.example.admin.soundcloud_13.screen;

import com.example.admin.soundcloud_13.constant.LoopType;
import com.example.admin.soundcloud_13.constant.ShuffleState;
import com.example.admin.soundcloud_13.constant.State;
import com.example.admin.soundcloud_13.data.model.Track;

public interface TrackListener {
    void onTrackChanged(Track track);

    void onStateChanged(@State int state);

    void onShuffleChanged(@ShuffleState int shuffleState);

    void onLoopChanged(@LoopType int loopState);
}
