package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Physiotherapist {
    @Id
    private int physiotherapistid;
    private String physiotherapistname;
    private String clinicaddress;
    private String specialization;
    private int experience;
    private int licensenumber;
    private int contactnumber;
    private String email;
    @Transient
    private double physiotherapistLatitude;
    @Transient
    private double physiotherapistLongitude;
    @Transient
    private double distance;

    public Physiotherapist() {}

    public Physiotherapist(String name, double latitude, double longitude, String specialization, int experience) {
        this.physiotherapistname = name;
        this.physiotherapistLatitude = latitude;
        this.physiotherapistLongitude = longitude;
        this.specialization = specialization;
        this.experience = experience;
    }
    public int getID()
    {
        return physiotherapistid;
    }
    public void setId(int id) {this.physiotherapistid = id;}
    public String getName() {
        return physiotherapistname;
    }
    public void setName(String name) {this.physiotherapistname = name;}


    public String getPhysiotherapistName() {return physiotherapistname;}
    public void setPhysiotherapistName(String name) {this.physiotherapistname = name;}
    public String getClinicAddress() {return clinicaddress;}
    public void setClinicAddress(String address) {this.clinicaddress = address;}

    public int getPhysiotherapistContactNumber() {
        return contactnumber;
    }
    public void setPhysiotherapistContactNumber(int contactNumber) {this.contactnumber = contactNumber;}
    public String getPhysiotherapistEmailAddress() {return email;}

    public int getPhysiotherapistExperience() {
        return experience;
    }
    public void setPhysiotherapistExperience(int experience) {this.experience = experience;}

    public String getPhysiotherapistSpecialization() {
        return specialization;
    }
    public void setPhysiotherapistSpecialization(String specialization) {this.specialization = specialization;}

    public String getPhysiotherapistEmailAddress(String emailAddress) {return email;}

    public void setPhysiotherapistEmailAddress(String physiotherapistEmailAddress) {
        this.email = physiotherapistEmailAddress;
    }


    public double getLatitude() {
        return physiotherapistLatitude;
    }
    public double getLongitude() {
        return physiotherapistLongitude;
    }
    public String getSpecialization() {
        return specialization;
    }
    public int getExperience() {
        return experience;
    }
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
