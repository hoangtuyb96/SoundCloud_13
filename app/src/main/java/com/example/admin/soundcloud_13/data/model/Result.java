package com.example.admin.soundcloud_13.data.model;

import java.util.List;

public class Result {
    private String mGenre;
    private String mLastUpdated;
    private List<Collection> mCollections;

    public Result(String genre, String lastUpdated, List<Collection> collections) {
        mGenre = genre;
        mLastUpdated = lastUpdated;
        mCollections = collections;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public List<Collection> getCollections() {
        return mCollections;
    }

    public void setCollections(List<Collection> collections) {
        mCollections = collections;
    }
}
