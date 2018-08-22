package com.example.admin.soundcloud_13.data.model;

public class Track {
    private String mArtworkUrl;
    private int mCommentCount;
    private String mCreatedAt;
    private String mDescription;
    private int mDownloadCount;
    private String mDownloadUrl;
    private int mDuration;
    private int mFullDuration;
    private String mEmbeddableBy;
    private String mGenre;
    private int id;
    private String mKind;
    private String mLabelName;
    private String mLastModified;
    private int mLikesCount;
    private String mPermalink;
    private String mPermalinkUrl;
    private int mPlaybackCount;
    private PublisherMetadata mPublisherMetadata;
    private String mState;
    private String mTitle;
    private String mUri;
    private String mUrn;
    private int mUserId;
    private User mUser;

    private Track(Builder builder) {
        this.mArtworkUrl = builder.mArtworkUrl;
        this.mCommentCount = builder.mCommentCount;
        this.mCreatedAt = builder.mCreatedAt;
        this.mDescription = builder.mDescription;
        this.mDownloadCount = builder.mDownloadCount;
        this.mDownloadUrl = builder.mDownloadUrl;
        this.mDuration = builder.mDuration;
        this.mFullDuration = builder.mFullDuration;
        this.mEmbeddableBy = builder.mEmbeddableBy;
        this.mGenre = builder.mGenre;
        this.id = builder.id;
        this.mKind = builder.mKind;
        this.mLabelName = builder.mLabelName;
        this.mLastModified = builder.mLastModified;
        this.mLikesCount = builder.mLikesCount;
        this.mPermalink = builder.mPermalink;
        this.mPermalinkUrl = builder.mPermalinkUrl;
        this.mPlaybackCount = builder.mPlaybackCount;
        this.mState = builder.mState;
        this.mTitle = builder.mTitle;
        this.mUri = builder.mUri;;
        this.mUrn = builder.mUrn;
        this.mUserId = builder.mUserId;
    }

    public static class Builder {
        private String mArtworkUrl;
        private int mCommentCount;
        private String mCreatedAt;
        private String mDescription;
        private int mDownloadCount;
        private String mDownloadUrl;
        private int mDuration;
        private int mFullDuration;
        private String mEmbeddableBy;
        private String mGenre;
        private int id;
        private String mKind;
        private String mLabelName;
        private String mLastModified;
        private int mLikesCount;
        private String mPermalink;
        private String mPermalinkUrl;
        private int mPlaybackCount;
        private String mState;
        private String mTitle;
        private String mUri;
        private String mUrn;
        private int mUserId;

        public Builder setArtworkUrl(String artworkUrl) {
            this.mArtworkUrl = artworkUrl;
            return this;
        }

        public Builder setCommentCount(int commentCount) {
            this.mCommentCount = commentCount;
            return this;
        }

        public Builder setCreateAt(String createAt) {
            this.mCreatedAt = createAt;
            return this;
        }

        public Builder setDescription(String description) {
            this.mDescription = description;
            return this;
        }

        public Builder setDownloadCount(int downloadCount) {
            this.mDownloadCount = downloadCount;
            return this;
        }

        public Builder setDownloadUrl(String downloadUrl) {
            this.mDownloadUrl = downloadUrl;
            return this;
        }

        public Builder setDuration(int duration) {
            this.mDuration = duration;
            return this;
        }

        public Builder setFullDuration(int fullDuration) {
            this.mFullDuration = fullDuration;
            return this;
        }

        public Builder setEmbeddableBy(String embeddableBy) {
            this.mEmbeddableBy = embeddableBy;
            return this;
        }

        public Builder setGenre(String genre) {
            this.mGenre = genre;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setKind(String kind) {
            this.mKind = kind;
            return this;
        }

        public Builder setLabelName(String labelName) {
            this.mLabelName = labelName;
            return this;
        }

        public Builder setLastModified(String lastModified) {
            this.mLastModified = lastModified;
            return this;
        }

        public Builder setLikesCount(int likesCount) {
            this.mLikesCount = likesCount;
            return this;
        }

        public Builder setPermalink(String permalink) {
            this.mPermalink = permalink;
            return this;
        }

        public Builder setPermalinkUrl(String permalinkUrl) {
            this.mPermalinkUrl = permalinkUrl;
            return this;
        }

        public Builder setPlaybackCount(int playbackCount) {
            this.mPlaybackCount = playbackCount;
            return this;
        }

        public Builder setState(String state) {
            this.mState = state;
            return this;
        }

        public Builder setTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder setUri(String uri) {
            this.mUri = uri;
            return this;
        }

        public Builder setUrn(String Urn) {
            this.mUrn = mUrn;
            return this;
        }

        public Builder setUserId(int userId) {
            this.mUserId = userId;
            return this;
        }

        public Track create() {
            return new Track(this);
        }
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public int getCommentCount() {
        return mCommentCount;
    }

    public void setCommentCount(int commentCount) {
        mCommentCount = commentCount;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getDownloadCount() {
        return mDownloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        mDownloadCount = downloadCount;
    }

    public String getDownloadUrl() {
        return mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        mDownloadUrl = downloadUrl;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getFullDuration() {
        return mFullDuration;
    }

    public void setFullDuration(int fullDuration) {
        mFullDuration = fullDuration;
    }

    public String getEmbeddableBy() {
        return mEmbeddableBy;
    }

    public void setEmbeddableBy(String embeddableBy) {
        mEmbeddableBy = embeddableBy;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getLabelName() {
        return mLabelName;
    }

    public void setLabelName(String labelName) {
        mLabelName = labelName;
    }

    public String getLastModified() {
        return mLastModified;
    }

    public void setLastModified(String lastModified) {
        mLastModified = lastModified;
    }

    public int getLikesCount() {
        return mLikesCount;
    }

    public void setLikesCount(int likesCount) {
        mLikesCount = likesCount;
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

    public int getPlaybackCount() {
        return mPlaybackCount;
    }

    public void setPlaybackCount(int playbackCount) {
        mPlaybackCount = playbackCount;
    }

    public PublisherMetadata getPublisherMetadata() {
        return mPublisherMetadata;
    }

    public void setPublisherMetadata(PublisherMetadata publisherMetadata) {
        mPublisherMetadata = publisherMetadata;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
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

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
