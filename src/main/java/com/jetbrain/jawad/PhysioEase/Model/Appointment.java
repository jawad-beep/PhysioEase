package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    private int appointmentid;
    @ManyToOne
    @JoinColumn(name = "physiotherapistid", insertable = false, updatable = false)  // This assumes the foreign key in the table is 'physiotherapist_id'
    private Physiotherapist physiotherapist;
    private int physiotherapistid;
    private String bookingdate;
    private String bookingtime;
    private String appointmentstatus;
    private String appointmenttype;

    public Appointment() {}
    public Appointment(String bookingdate, String bookingtime, String appointmentstatus, String appointmenttype) {
        this.bookingdate = bookingdate;
        this.bookingtime = bookingtime;
        this.appointmentstatus = appointmentstatus;
        this.appointmenttype = appointmenttype;
    }

    public String getBookingdate() {return bookingdate;}
    public void setBookingdate(String bookingdate) {this.bookingdate = bookingdate;}
    public String getBookingtime() {return bookingtime;}
    public void setBookingtime(String bookingtime) {this.bookingtime = bookingtime;}
    public String getAppointmentstatus() {return appointmentstatus;}
    public void setAppointmentstatus(String appointmentstatus) {this.appointmentstatus = appointmentstatus;}
    public String getAppointmenttype() {return appointmenttype;}
    public void setAppointmenttype(String appointmenttype) {this.appointmenttype = appointmenttype;}
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

}
