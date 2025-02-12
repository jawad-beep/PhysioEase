package com.jetbrain.jawad.PhysioEase.Model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private double latitude;
    private double longitude;
    private int patientRadius;
    private String patientSpecialization;

    // Default constructor needed for JSON deserialization
    public Patient() {}

    public Patient(double latitude, double longitude, int patientRadius, String patientSpecialization) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.patientRadius = patientRadius;
        this.patientSpecialization = patientSpecialization;
    }

    // Getters and setters
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public int getPatientRadius() { return patientRadius; }
    public void setPatientRadius(int patientRadius) { this.patientRadius = patientRadius; }
    public String getPatientSpecialization() {return patientSpecialization;}
    public void setPatientSpecialization(String patientSpecialization) {this.patientSpecialization = patientSpecialization;}
}