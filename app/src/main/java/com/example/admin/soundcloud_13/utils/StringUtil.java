package com.example.admin.soundcloud_13.utils;

import com.example.admin.soundcloud_13.BuildConfig;
import com.example.admin.soundcloud_13.constant.Constants;

public class StringUtil {
    public static String formatTrackUrl(String genre, int limit, int offset) {
        return String.format(Constants.TRACK_QUERY, Constants.BASE_URL, Constants.GENRE_URL,
                genre, Constants.CLIENT_ID, BuildConfig.API_KEY, Constants.LIMIT_DEFAULT, limit,
                Constants.OFFSET_DEFAULT, offset);
    }
}
