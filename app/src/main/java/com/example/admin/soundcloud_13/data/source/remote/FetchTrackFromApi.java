package com.example.admin.soundcloud_13.data.source.remote;

import android.os.AsyncTask;

import com.example.admin.soundcloud_13.constant.Constants;
import com.example.admin.soundcloud_13.constant.TrackKey;
import com.example.admin.soundcloud_13.data.model.Track;
import com.example.admin.soundcloud_13.screen.home.online.genre.GenrePresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchTrackFromApi extends AsyncTask<String, Void, List<Track>> {
    private GenrePresenter.LoadTrackCallback callback;
    private Exception mException;

    public FetchTrackFromApi(GenrePresenter.LoadTrackCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Track> doInBackground(String... strings) {
        try {
            String json = getJSONStringFromUrl(strings[0]);
            return getTrackFromJson(json);
        } catch (JSONException e) {
            mException = e;
        } catch (IOException e) {
            mException = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        super.onPostExecute(tracks);
        if (callback!=null)
            callback.onComplete(tracks);
        if (mException != null) {
            mException.printStackTrace();
        }
    }

    private List<Track> getTrackFromJson(String json) throws JSONException {
        List<Track> tracks = new ArrayList<>();
        JSONObject jsonObjectCollection = new JSONObject(json);
        JSONArray jsonArray = jsonObjectCollection.getJSONArray(TrackKey.COLLECTION);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i).getJSONObject(TrackKey.TRACK);
            String artworkUrl = jsonObject.getString(TrackKey.ARTWORK_URL);
            String artist = jsonObject.getJSONObject(TrackKey.USER).getString(TrackKey.USERNAME);
            String description = jsonObject.getString(TrackKey.DESCRIPTION);
            String downloadUrl = jsonObject.getString(TrackKey.DOWNLOAD_URL);
            int fullDuration = jsonObject.getInt(TrackKey.FULL_DURATION);
            String genre = jsonObject.getString(TrackKey.GENRE);
            int id = jsonObject.getInt(TrackKey.ID);
            String title = jsonObject.getString(TrackKey.TITLE);
            String uri = jsonObject.getString(TrackKey.URI);
            Track track = new Track.Builder()
                    .setArtworkUrl(artworkUrl)
                    .setArtist(artist)
                    .setDescription(description)
                    .setDownloadUrl(downloadUrl)
                    .setFullDuration(fullDuration)
                    .setGenre(genre)
                    .setId(id)
                    .setTitle(title)
                    .setUri(uri)
                    .create();
            tracks.add(track);
        }
        return tracks;
    }

    private String getJSONStringFromUrl(String string) throws IOException, JSONException {
        HttpURLConnection httpURLConnection = null;
        URL url = new URL(string);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(Constants.REQUEST_METHOD_GET);
        httpURLConnection.setConnectTimeout(Constants.CONNECT_TIME_OUT);
        httpURLConnection.setReadTimeout(Constants.READ_TIME_OUT);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.connect();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append(Constants.BREAK_LINE);
        }

        bufferedReader.close();

        String jsonString = stringBuilder.toString();
        httpURLConnection.disconnect();
        return jsonString;
    }
}
