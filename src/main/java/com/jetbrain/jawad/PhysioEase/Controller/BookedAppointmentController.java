package com.jetbrain.jawad.PhysioEase.Controller;
import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Model.BookedAppointment;
import com.jetbrain.jawad.PhysioEase.Repository.BookedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookedAppointmentController {

    @Autowired
    private BookedAppointmentRepository bookedAppointmentRepository;

    @PostMapping("/create")
    public ResponseEntity<String> bookAppointment(@RequestBody BookedAppointment bookedAppointment) {
        bookedAppointmentRepository.save(bookedAppointment);
        return ResponseEntity.ok("Appointment booked successfully!");
    }


}
