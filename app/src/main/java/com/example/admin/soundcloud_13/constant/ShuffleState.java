package com.example.admin.soundcloud_13.constant;

import android.support.annotation.IntDef;

@IntDef({
        ShuffleState.OFF,
        ShuffleState.ON
})

public @interface ShuffleState {
    int ON = 1;
    int OFF = 0;
}
