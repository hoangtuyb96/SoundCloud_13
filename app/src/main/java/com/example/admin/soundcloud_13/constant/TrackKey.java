package com.example.admin.soundcloud_13.constant;

import android.support.annotation.StringDef;

@StringDef({
        TrackKey.ARTWORK_URL,
        TrackKey.DESCRIPTION,
        TrackKey.DOWNLOAD_URL,
        TrackKey.FULL_DURATION,
        TrackKey.GENRE,
        TrackKey.ID,
        TrackKey.TITLE,
        TrackKey.URI,
        TrackKey.COLLECTION,
        TrackKey.TRACK,
        TrackKey.USER,
        TrackKey.USERNAME,
})

public @interface TrackKey {
    String ARTWORK_URL = "artwork_url";
    String DESCRIPTION = "description";
    String DOWNLOAD_URL = "download_url";
    String FULL_DURATION = "full_duration";
    String GENRE = "genre";
    String ID = "id";
    String TITLE = "title";
    String URI = "uri";
    String COLLECTION = "collection";
    String TRACK = "track";
    String USER = "user";
    String USERNAME = "username";
}
