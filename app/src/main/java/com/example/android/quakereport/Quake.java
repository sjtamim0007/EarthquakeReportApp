package com.example.android.quakereport;

public class Quake {
    private double level;
    private String location;
    private long date;
    private String url;

    public Quake(double level, String location, long date, String url) {
        this.level = level;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public double getLevel() {
        return level;
    }

    public String getLocation() {
        return location;
    }

    public long getDate() {
        return date;
    }

    public String getUrl(){
        return url;
    }
}
