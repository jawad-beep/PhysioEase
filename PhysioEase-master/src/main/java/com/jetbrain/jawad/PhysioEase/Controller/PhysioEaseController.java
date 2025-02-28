    package com.jetbrain.jawad.PhysioEase.Controller;
    import com.jetbrain.jawad.PhysioEase.Model.Patient;
    import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
    import com.jetbrain.jawad.PhysioEase.Service.PatientService;
    import com.jetbrain.jawad.PhysioEase.Service.PhysiotherapistService;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

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
        @GetMapping("/patients/{id}")
        public Optional<Patient> getPatientById(@PathVariable int id) {
            return patientService.getPatientById(id); // This should return the patient data for the given ID
        }

        // Update Patient Details
        @PutMapping("/patients/{id}")
        public Patient updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
            System.out.println("Updating Patient ID: " + id);
            System.out.println("Received Data: " + updatedPatient);
            return patientService.updatePatient(id, updatedPatient);
        }

        @Autowired
        private PhysiotherapistService physiotherapistService;
        @GetMapping("/physiotherapists/{id}")
        public Optional<Physiotherapist> getPhysiotherapistById(@PathVariable int id) {
            return physiotherapistService.getPhysiotherapistById(id);
        }

        @PutMapping("/physiotherapists/{id}")
        public Physiotherapist updatePhysiotherapist(@PathVariable int id, @RequestBody Physiotherapist updatedPhysiotherapist) {
            System.out.println("Updating Patient ID: " + id);
            System.out.println("Received Data: " + updatedPhysiotherapist);
            return physiotherapistService.updatePhysiotherapist(id, updatedPhysiotherapist);
        }



    }

