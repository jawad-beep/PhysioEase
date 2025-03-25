package com.jetbrain.jawad.PhysioEase.Controller;

import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Repository.BookedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientBookedAppointmentController {

    @Autowired
    private BookedAppointmentRepository appointmentRepository;

    @GetMapping("/patient/search")
    public String searchPatientByName(@RequestParam(required = false) String patientname, Model model) {
        if (patientname != null && !patientname.isEmpty()) {
            List<BookedAppointment> appointments = appointmentRepository.findByPatientname(patientname);
            model.addAttribute("patientname", patientname);
            model.addAttribute("appointments", appointments);
        }
        return "patientprofile";
    }

    // Show patient profile by name (use this when you have a link from somewhere else)
    @GetMapping("/patient/{patientname}/profile")
    public String showPatientProfileByName(@PathVariable String patientname, Model model) {
        List<BookedAppointment> appointments = appointmentRepository.findByPatientname(patientname);
        model.addAttribute("patientname", patientname);
        model.addAttribute("appointments", appointments);
        return "patientprofile";
    }

    // Cancel appointment by ID
    @GetMapping("/appointment/cancel/{id}")
    public String cancelAppointment(@PathVariable int id, RedirectAttributes redirectAttributes) {
        // First find the appointment to get the patient name (for redirect)
        Optional<BookedAppointment> appointmentOpt = appointmentRepository.findById(id);

        if (appointmentOpt.isPresent()) {
            BookedAppointment appointment = appointmentOpt.get();
            String patientName = appointment.getpatientname();

            // Delete the appointment
            appointmentRepository.deleteById(id);

            // Add success message
            redirectAttributes.addFlashAttribute("message", "Appointment has been cancelled successfully.");

            // Redirect back to the patient profile
            return "redirect:/patient/" + patientName + "/profile";
        } else {
            // If appointment not found, redirect to some error page or home
            redirectAttributes.addFlashAttribute("message", "Appointment not found.");
            return "redirect:/dashboard";
        }
    }

}