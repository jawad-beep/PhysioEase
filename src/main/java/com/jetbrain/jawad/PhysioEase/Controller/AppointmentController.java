package com.jetbrain.jawad.PhysioEase.Controller;

import org.springframework.ui.Model;
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

    // This endpoint returns appointment data as JSON
    @GetMapping("/appointments/view/{physiotherapistId}")
    public String viewAppointments(@PathVariable int physiotherapistId, Model model) {
        // Fetch appointments for the given physiotherapist ID
        List<Appointment> appointments = appointmentRepository.findByPhysiotherapistId(physiotherapistId);
        model.addAttribute("appointments", appointments);

        // Return the new HTML page to display appointments
        return "appointments";
    }
    @GetMapping("/appointments/{physiotherapistId}")
    @ResponseBody
    public List<Appointment> getAppointments(@PathVariable int physiotherapistId) {
        return appointmentRepository.findByPhysiotherapistId(physiotherapistId);
    }

}
