package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookedappointment")
public class BookedAppointment {

    @Id
    private int bookedappointmentid;

    private String patientname;
    private String appointmentdate;
    private String appointmenttime;
    private String patientproblem;
    private String contactnumber;
    private String patientaddress;
    private String emailaddress;

    // Default constructor
    public BookedAppointment() {}

    // Parameterized constructor
    public BookedAppointment(int bookedappointmentid, String patientname, String appointmentdate, String appointmenttime,
                             String patientproblem, String contactnumber, String patientaddress, String emailaddress) {
        this.bookedappointmentid = bookedappointmentid;
        this.patientname = patientname;
        this.appointmentdate = appointmentdate;
        this.appointmenttime = appointmenttime;
        this.patientproblem = patientproblem;
        this.contactnumber = contactnumber;
        this.patientaddress = patientaddress;
        this.emailaddress = emailaddress;
    }

    // Getters and Setters with exact field names

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

    public String getappointmentdate() {
        return appointmentdate;
    }

    public void setappointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public String getappointmenttime() {
        return appointmenttime;
    }

    public void setappointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
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
