package com.example.admin.soundcloud_13.data.model;

public class User {
    private String mAvatarUrl;
    private String mFirstName;
    private String mFullName;
    private String mKind;
    private String mLastModified;
    private String mLastName;
    private String mPermalink;
    private String mPermalinkUrl;
    private String mUri;
    private String mUrn;
    private String mUsername;
    private boolean mVerified;

    public User() {
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getLastModified() {
        return mLastModified;
    }

    public void setLastModified(String lastModified) {
        mLastModified = lastModified;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getPermalink() {
        return mPermalink;
    }

    public void setPermalink(String permalink) {
        mPermalink = permalink;
    }

    public String getPermalinkUrl() {
        return mPermalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        mPermalinkUrl = permalinkUrl;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getUrn() {
        return mUrn;
    }

    public void setUrn(String urn) {
        mUrn = urn;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public boolean isVerified() {
        return mVerified;
    }

    public void setVerified(boolean verified) {
        mVerified = verified;
    }
}
