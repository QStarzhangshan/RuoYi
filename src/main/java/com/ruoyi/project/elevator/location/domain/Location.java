package com.ruoyi.project.elevator.location.domain;


public class Location{

    private long id;
    private String latitude_longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLatitude_longitude() {
        return latitude_longitude;
    }

    public void setLatitude_longitude(String latitude_longitude) {
        this.latitude_longitude = latitude_longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", latitude_longitude='" + latitude_longitude + '\'' +
                '}';
    }
}
