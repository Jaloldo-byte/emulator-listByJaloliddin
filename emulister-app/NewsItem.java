package com.jaloldo.emulister;

public class NewsItem {
    private String title;
    private String description;
    private String timestamp;
    private String imageUrl;

    public NewsItem(String title, String description, String timestamp, String imageUrl) {
        this.title = title;
        this.description = description;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTimestamp() { return timestamp; }
    public String getImageUrl() { return imageUrl; }
}