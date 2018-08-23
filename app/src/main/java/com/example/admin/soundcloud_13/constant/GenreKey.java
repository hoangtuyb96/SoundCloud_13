package com.example.admin.soundcloud_13.constant;

import android.support.annotation.StringDef;

@StringDef({
        GenreKey.ALL_AUDIO,
        GenreKey.ALTERNATIVE_ROCK,
        GenreKey.AMBIENT,
        GenreKey.CLASSICAL,
        GenreKey.COUNTRY
})

public @interface GenreKey {
    String ALL_AUDIO = "all-audio";
    String ALTERNATIVE_ROCK = "alternativerock";
    String AMBIENT = "ambient";
    String CLASSICAL = "classical";
    String COUNTRY = "country";
}
