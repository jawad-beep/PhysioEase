package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremented ID
    private int appointmentid;

    @ManyToOne
    @JoinColumn(name = "physiotherapistid", insertable = false, updatable = false)
    private Physiotherapist physiotherapist;  // Fetches physiotherapist details

    private int physiotherapistid;
    private String bookingdate;
    private String bookingtime;
    private String appointmentstatus;
    private String appointmenttype;

    // Default constructor
    public Appointment() {}

    // Constructor with parameters
    public Appointment(int physiotherapistid, String bookingdate, String bookingtime, String appointmentstatus, String appointmenttype) {
        this.physiotherapistid = physiotherapistid;
        this.bookingdate = bookingdate;
        this.bookingtime = bookingtime;
        this.appointmentstatus = appointmentstatus;
        this.appointmenttype = appointmenttype;
    }

    // ✅ Correct getter for Physiotherapist Name
    public String getPhysiotherapistName() {
        return (physiotherapist != null) ? physiotherapist.getPhysiotherapistName() : "Unknown";
    }
    public String getPhysiotherapistSpecialization() {
        return (physiotherapist != null) ? physiotherapist.getPhysiotherapistSpecialization() : "Unknown";
    }

    // Getters and Setters
    public int getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }

    public int getPhysiotherapistid() {
        return physiotherapistid;
    }

    public void setPhysiotherapistid(int physiotherapistid) {
        this.physiotherapistid = physiotherapistid;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getBookingtime() {
        return bookingtime;
    }

    public void setBookingtime(String bookingtime) {
        this.bookingtime = bookingtime;
    }

    public String getAppointmentstatus() {
        return appointmentstatus;
    }

    public void setAppointmentstatus(String appointmentstatus) {
        this.appointmentstatus = appointmentstatus;
    }

    public String getAppointmenttype() {
        return appointmenttype;
    }

    public void setAppointmenttype(String appointmenttype) {
        this.appointmenttype = appointmenttype;
    }
}

