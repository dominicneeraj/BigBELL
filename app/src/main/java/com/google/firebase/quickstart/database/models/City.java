package com.google.firebase.quickstart.database.models;

/**
 * Created by NEERAJPC on 10/24/2016.
 */

import java.io.Serializable;


public class City implements Serializable {
    private String name;
    private String lat;
    private String lng;
    private String small, medium, large;
    private String timestamp;
    private String id;

    public City() {
    }

    public City(String name, String lat, String lng, String small, String medium, String large, String timestamp, String id) {
        this.name = name;
        this.lat =lat;
        this.lng=lng;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.timestamp = timestamp;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
