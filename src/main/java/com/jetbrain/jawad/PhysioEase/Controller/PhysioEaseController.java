    package com.jetbrain.jawad.PhysioEase.Controller;
    import com.jetbrain.jawad.PhysioEase.Model.Patient;
    import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
    import com.jetbrain.jawad.PhysioEase.Service.PatientService;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpEntity;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class PhysioEaseController {
        @PostMapping("/getPatientLocation")
        public ResponseEntity<String> getPatientLocation(@RequestBody Patient locationRequest, HttpSession session) {
            double latitude = locationRequest.getLatitude();
            double longitude = locationRequest.getLongitude();
            int patientRadius = locationRequest.getPatientRadius();
            String patientSpecialization = locationRequest.getPatientSpecialization();

            // Store in session instead of class variable
            Patient patient = new Patient(latitude, longitude, patientRadius, patientSpecialization);
            session.setAttribute("patient", patient);

            return ResponseEntity.ok("/view/getPhysiotherapists");
        }


        @PostMapping("/RegisterPhysiotherapist")
        public ResponseEntity<String> PhysiotherapistDetails(@RequestBody Physiotherapist physiotherapistDetails, HttpSession session)
        {
            String physiotherapistName = physiotherapistDetails.getName();
            String physiotherapistSpecialization = physiotherapistDetails.getSpecialization();
            int physiotherapistExperience=physiotherapistDetails.getExperience();
            double physiotherapistLatitude=physiotherapistDetails.getLatitude();
            double physiotherapistLongitude=physiotherapistDetails.getLongitude();

            Physiotherapist physiotherapist=new Physiotherapist(physiotherapistName, physiotherapistLatitude, physiotherapistLongitude, physiotherapistSpecialization, physiotherapistExperience);
            session.setAttribute("physiotherapist",physiotherapist);
            return ResponseEntity.ok("/view/getPhysiotherapists");
        }
        @Autowired
        private PatientService patientService;
        @GetMapping("/patients")
        public List<Patient> getAllPatients() {
            return patientService.getAllPatients();
        }
    }