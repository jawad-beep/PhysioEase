package com.jetbrain.jawad.PhysioEase.Controller;

import org.springframework.ui.Model;
import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Map<String, Object>> getAppointments(@PathVariable int physiotherapistId) {
        List<Appointment> appointments = appointmentRepository.findByPhysiotherapistId(physiotherapistId);

        List<Map<String, Object>> response = new ArrayList<>();
        for (Appointment appointment : appointments) {
            Map<String, Object> appData = new HashMap<>();
            appData.put("appointmentid", appointment.getAppointmentid());
            appData.put("bookingdate", appointment.getBookingdate());
            appData.put("bookingtime", appointment.getBookingtime());
            appData.put("appointmentstatus", appointment.getAppointmentstatus());
            appData.put("appointmenttype", appointment.getAppointmenttype());
            appData.put("physiotherapistname", appointment.getPhysiotherapistName()); // ✅ Now correctly fetches name
            appData.put("specialization", appointment.getPhysiotherapistSpecialization());
            response.add(appData);
        }

        return response;
    }



}
