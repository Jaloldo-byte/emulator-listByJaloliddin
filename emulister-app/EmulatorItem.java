package com.jaloldo.emulister;

public class EmulatorItem {
    private String name;
    private String system;
    private String rating;
    private String imageUrl;

    public EmulatorItem(String name, String system, String rating, String imageUrl) {
        this.name = name;
        this.system = system;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public String getSystem() { return system; }
    public String getRating() { return rating; }
    public String getImageUrl() { return imageUrl; }
}