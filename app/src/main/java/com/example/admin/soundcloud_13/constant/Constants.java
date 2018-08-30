package com.example.admin.soundcloud_13.constant;

public class Constants {
    public final static String GENRE_KEY = "genre";
    public final static String BASE_URL = "https://api-v2.soundcloud.com/";
    public final static String GENRE_URL = "charts?kind=top&genre=soundcloud%3Agenres%3A";
    public final static String CLIENT_ID = "client_id";
    public final static int LIMIT_DEFAULT = 20;
    public final static int OFFSET_DEFAULT = 0;
    public final static String TRACK_QUERY = "%s%s%s&%s=%s&%s=%d&%s=%d";
    public final static String REQUEST_METHOD_GET = "GET";
    public static final int READ_TIME_OUT = 5000;
    public static final int CONNECT_TIME_OUT = 5000;
    public static final String BREAK_LINE = "\n";
    public static final String STREAM = "stream";
    public static final String EXTRA_LIST_TRACK = "EXTRA_LIST_TRACK";
    public static final String EXTRA_POSITION_TRACK = "EXTRA_POSITION_TRACK";
}
