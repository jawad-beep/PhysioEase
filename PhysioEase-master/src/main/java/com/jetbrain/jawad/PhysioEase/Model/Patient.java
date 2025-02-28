package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Transient
    private double latitude;
    @Transient
    private double longitude;
    @Transient
    private int patientRadius;
    @Transient
    private String patientSpecialization;
    @Id
    private int patientid;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private String contactnumber;
    private String emailaddress;
    private String address;

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

    public int getPatientid() {
        return patientid;
    }
    public void setPatientid(String patientid) {}
    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getContactnumber() {return contactnumber;}

    public String getEmailaddress() {
        return emailaddress;
    }
    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}