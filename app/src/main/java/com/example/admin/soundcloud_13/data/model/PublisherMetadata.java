package com.example.admin.soundcloud_13.data.model;

public class PublisherMetadata {
    private int id;
    private String mUrn;
    private String mArtist;
    private String mAlbumTitle;
    private String mReleaseTitle;

    public PublisherMetadata(int id, String urn, String artist, String albumTitle, String releaseTitle) {
        this.id = id;
        mUrn = urn;
        mArtist = artist;
        mAlbumTitle = albumTitle;
        mReleaseTitle = releaseTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrn() {
        return mUrn;
    }

    public void setUrn(String urn) {
        mUrn = urn;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        mAlbumTitle = albumTitle;
    }

    public String getReleaseTitle() {
        return mReleaseTitle;
    }

    public void setReleaseTitle(String releaseTitle) {
        mReleaseTitle = releaseTitle;
    }
}
