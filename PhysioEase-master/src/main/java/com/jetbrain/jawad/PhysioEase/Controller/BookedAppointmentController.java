package com.jetbrain.jawad.PhysioEase.Controller;
import com.jetbrain.jawad.PhysioEase.Model.Appointment;
import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Repository.AppointmentRepository;
import com.jetbrain.jawad.PhysioEase.Repository.BookedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookedAppointmentController {

    @Autowired
    private BookedAppointmentRepository bookedAppointmentRepository;

    @Autowired
    private AppointmentRepository appointmentRepository; // Add repository for Appointment

    @PostMapping("/create")
    public ResponseEntity<String> bookAppointment(@RequestBody BookedAppointment bookedAppointment) {
        System.out.println("Booking appointment " + bookedAppointment);

        // First save the booked appointment
        bookedAppointmentRepository.save(bookedAppointment);

        // Get the appointment ID from the booked appointment
        Long appointmentId = (long) bookedAppointment.getbookedappointmentid();

        // Find the appointment by ID
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(Math.toIntExact(appointmentId));

        if (optionalAppointment.isPresent()) {
            // Get the appointment
            Appointment appointment = optionalAppointment.get();

            // Update the appointment status
            appointment.setAppointmentstatus("BOOKED");

            // Save the updated appointment
            appointmentRepository.save(appointment);

            return ResponseEntity.ok("Appointment booked successfully!");
        } else {
            return ResponseEntity.badRequest().body("Appointment not found with ID: " + appointmentId);
        }
    }
}