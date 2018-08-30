package com.example.admin.soundcloud_13.constant;

import android.support.annotation.IntDef;

@IntDef({
        State.INVALID,
        State.PLAYING,
        State.PAUSE,
        State.PREPARE,
        State.COMPLETED
})

public @interface State {
    int INVALID = -1;
    int PLAYING = 0;
    int PAUSE = 1;
    int PREPARE = 2;
    int COMPLETED = 3;
}
