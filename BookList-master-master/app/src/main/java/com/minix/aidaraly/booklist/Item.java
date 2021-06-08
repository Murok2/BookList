package com.minix.aidaraly.booklist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Item implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("volumeInfo")
    private Info volumeInfo;

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("volumeInfo")
    public Info getVolumeInfo() {
        return volumeInfo;
    }

    @SerializedName("volumeInfo")
    public void setVolumeInfo(Info volumeInfo) {
        this.volumeInfo = volumeInfo;
    }


}
