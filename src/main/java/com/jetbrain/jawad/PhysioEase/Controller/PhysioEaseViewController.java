package com.jetbrain.jawad.PhysioEase.Controller;

import com.jetbrain.jawad.PhysioEase.Model.Patient;
import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
import com.jetbrain.jawad.PhysioEase.Repository.PhysiotherapistRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
public class PhysioEaseViewController {

    private final PhysiotherapistRepository physiotherapistRepository;

    public PhysioEaseViewController(PhysiotherapistRepository physiotherapistRepository) {
        this.physiotherapistRepository = physiotherapistRepository;
    }

    @GetMapping("/getPhysiotherapists")
    public String listOfPhysiotherapists(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("patient");
        if (patient == null) {
            throw new RuntimeException("Patient location not found!");
        }

        String patientSpecialization = patient.getPatientSpecialization();

        // Fetch physiotherapists from DB based on specialization
        List<Physiotherapist> allPhysiotherapists = physiotherapistRepository.findBySpecialization(patientSpecialization);

        List<Physiotherapist> filteredPhysiotherapists = new ArrayList<>();

        for (Physiotherapist physio : allPhysiotherapists) {
            double distance = calculateDistance(patient, physio);

            // Filter by distance
            if (distance != -1) {
                physio.setDistance(distance);
                filteredPhysiotherapists.add(physio);
            }
        }

        if (filteredPhysiotherapists.isEmpty()) {
            model.addAttribute("noResultsMessage", "No physiotherapists found within your selected range :/ Please try expanding your radius :)");
        } else {
            model.addAttribute("physiotherapists", filteredPhysiotherapists);
        }

        return "physiotherapists"; // Refers to physiotherapists.html template
    }

    public double calculateDistance(Patient patient, Physiotherapist physiotherapist) {
        double lat1 = patient.getLatitude();
        double lon1 = patient.getLongitude();
        double lat2 = physiotherapist.getLatitude();
        double lon2 = physiotherapist.getLongitude();
        int patientRadius = patient.getPatientRadius();

        double radianLat1 = Math.toRadians(lat1);
        double radianLon1 = Math.toRadians(lon1);
        double radianLat2 = Math.toRadians(lat2);
        double radianLon2 = Math.toRadians(lon2);

        double dlon = radianLon2 - radianLon1;
        double dlat = radianLat2 - radianLat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) +
                Math.cos(radianLat1) * Math.cos(radianLat2) *
                        Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double radius = 6371; // Earth's radius in km
        double distanceFromPatient = radius * c;

        return (distanceFromPatient <= patientRadius) ? distanceFromPatient : -1;
    }
}
