package com.minix.aidaraly.booklist;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info
{

    @SerializedName("title")
    private String title;

    @SerializedName("authors")
    private List<String> authors = null;

    @SerializedName("publishedDate")
    private String publishedDate;

    @SerializedName("pageCount")
    private Integer pageCount;

    @SerializedName("imageLinks")
    private ImgLink imageLinks;

    @SerializedName("previewLink")
    private String previewLink;

    @SerializedName("description")
    private String description;

    @SerializedName("averageRating")
    private double averageRating;

    /* GETTERS AND SETTERS */

    @SerializedName("title")
    public String getTitle() {
        return title;
    }

    @SerializedName("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("authors")
    public List<String> getAuthors() {
        return authors;
    }

    @SerializedName("authors")
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @SerializedName("publishedDate")
    public String getPublishedDate() {
        return publishedDate;
    }

    @SerializedName("publishedDate")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }


    @SerializedName("pageCount")
    public Integer getPageCount() {
        return pageCount;
    }

    @SerializedName("pageCount")
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }


    @SerializedName("imageLinks")
    public ImgLink getImageLinks() {
        return imageLinks;
    }

    @SerializedName("imageLinks")
    public void setImageLinks(ImgLink imageLinks) {
        this.imageLinks = imageLinks;
    }

    @SerializedName("previewLink")
    public String getPreviewLink() {
        return previewLink;
    }

    @SerializedName("previewLink")
    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("averageRating")
    public double getAverageRating() { return averageRating; }

    @SerializedName("averageRating")
    public void setAverageRating(double averageRating) {  this.averageRating = averageRating; }

}
