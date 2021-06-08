package com.minix.aidaraly.booklist;

import com.google.gson.annotations.SerializedName;

public class ImgLink {

    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("smallThumbnail")
    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    @SerializedName("smallThumbnail")
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    @SerializedName("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @SerializedName("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
