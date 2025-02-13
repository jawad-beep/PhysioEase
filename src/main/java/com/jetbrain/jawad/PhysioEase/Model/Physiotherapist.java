package com.jetbrain.jawad.PhysioEase.Model;

import java.util.ArrayList;
import java.util.List;

public class Physiotherapist {
    private String physiotherapistName;
    private double physiotherapistLatitude;
    private double physiotherapistLongitude;
    private String physiotherapistSpecialization;
    private int physiotherapistExperience;
    private double distance;

    public Physiotherapist(String name, double latitude, double longitude, String specialization, int experience) {
        this.physiotherapistName = name;
        this.physiotherapistLatitude = latitude;
        this.physiotherapistLongitude = longitude;
        this.physiotherapistSpecialization = specialization;
        this.physiotherapistExperience = experience;
    }
    public String getName() {
        return physiotherapistName;
    }

    public double getLatitude() {
        return physiotherapistLatitude;
    }
    public double getLongitude() {
        return physiotherapistLongitude;
    }
    public String getSpecialization() {
        return physiotherapistSpecialization;
    }
    public int getExperience() {
        return physiotherapistExperience;
    }
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
