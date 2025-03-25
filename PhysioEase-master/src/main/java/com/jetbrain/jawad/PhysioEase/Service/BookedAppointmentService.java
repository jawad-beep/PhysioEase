package com.jetbrain.jawad.PhysioEase.Service;

import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Repository.BookedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookedAppointmentService {

    @Autowired
    private BookedAppointmentRepository appointmentRepository;

    public List<BookedAppointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<BookedAppointment> getAppointmentsByName(String name) {
        return appointmentRepository.findByPatientname(name);
    }


    }
