package com.jetbrain.jawad.PhysioEase.Service;

import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}
