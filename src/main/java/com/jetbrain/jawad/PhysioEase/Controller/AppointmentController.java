package com.jetbrain.jawad.PhysioEase.Controller;

import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // This endpoint will return all appointments for a particular physiotherapist
    @GetMapping("/appointments/{physiotherapistId}")
    @ResponseBody
    public List<Appointment> getAppointments(@PathVariable int physiotherapistId) {
        return appointmentRepository.findByPhysiotherapistId(physiotherapistId);
    }
}
