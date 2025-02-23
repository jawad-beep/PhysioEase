package com.jetbrain.jawad.PhysioEase.Model;

import jakarta.persistence.Id;

public class Appointment {
    @Id
    private int appointmentid;
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

}
