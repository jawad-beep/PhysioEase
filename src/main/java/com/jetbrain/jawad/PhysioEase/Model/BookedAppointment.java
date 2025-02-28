package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.*;


@Entity
@Table (name = "bookedappointment")
public class BookedAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookedappointmentid;
    private String patientname;
    private String patientproblem;
    private String contactnumber;
    private String patientaddress;
    private String emailaddress;

    public BookedAppointment(){}



    // Getters and Setters

    public int getbookedappointmentid() {
        return bookedappointmentid;
    }

    public void setbookedappointmentid(int bookedappointmentid) {
        this.bookedappointmentid = bookedappointmentid;
    }

    public String getpatientname() {
        return patientname;
    }

    public void setpatientname(String patientname) {
        this.patientname = patientname;
    }
    public String getpatientproblem() {
        return patientproblem;
    }

    public void setpatientproblem(String patientproblem) {
        this.patientproblem = patientproblem;
    }

    public String getcontactnumber() {
        return contactnumber;
    }

    public void setcontactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getpatientaddress() {
        return patientaddress;
    }

    public void setpatientaddress(String patientaddress) {
        this.patientaddress = patientaddress;
    }

    public String getemailaddress() {
        return emailaddress;
    }

    public void setemailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
}

