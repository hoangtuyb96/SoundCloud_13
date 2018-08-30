package com.example.admin.soundcloud_13.constant;

import android.support.annotation.IntDef;

@IntDef({
        LoopType.NO_LOOP,
        LoopType.LOOP_ONE,
        LoopType.LOOP_ALL
})
public @interface LoopType {
    int NO_LOOP = -1;
    int LOOP_ONE = 0;
    int LOOP_ALL = 1;
}
