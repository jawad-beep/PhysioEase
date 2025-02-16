package com.jetbrain.jawad.PhysioEase.Controller;

import com.jetbrain.jawad.PhysioEase.Model.Patient;
import com.jetbrain.jawad.PhysioEase.Model.Physiotherapist;
import com.jetbrain.jawad.PhysioEase.Service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/view")
public class PhysioEaseViewController {
    @GetMapping("/getPhysiotherapists")
    public String listOfPhysiotherapists(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("patient");
        if (patient == null) {
            throw new RuntimeException("Patient location not found!");
        }

        String patientSpecialization = patient.getPatientSpecialization(); // Get selected specialization

        List<Physiotherapist> allPhysiotherapists = new ArrayList<>();

// ✅ Neurological Disorder
        allPhysiotherapists.add(new Physiotherapist("Dr. Smith", 51.5074, -0.1278, "Neurological Disorder", 10));
        allPhysiotherapists.add(new Physiotherapist("Dr. Johnson", 51.5154, -0.1419, "Neurological Disorder", 8));

// ✅ Geriatrics
        allPhysiotherapists.add(new Physiotherapist("Dr. Williams", 51.4897, -0.1395, "Geriatrics", 12));
        allPhysiotherapists.add(new Physiotherapist("Dr. Brown", 51.4611, -0.2202, "Geriatrics", 15));

// ✅ Cardiovascular and Pulmonary Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Jawad", 51.5625, -0.1015, "Cardiovascular and Pulmonary Physiotherapy", 14));
        allPhysiotherapists.add(new Physiotherapist("Dr. Patel", 51.4074, -0.0202, "Cardiovascular and Pulmonary Physiotherapy", 18));

// ✅ Pediatric Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Ali", 51.6056, -0.1246, "Pediatric Physiotherapy", 20));
        allPhysiotherapists.add(new Physiotherapist("Dr. Evans", 51.4452, -0.1520, "Pediatric Physiotherapy", 22));

// ✅ Musculoskeletal Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. O'Connor", 51.3300, -0.2700, "Musculoskeletal Physiotherapy", 30));
        allPhysiotherapists.add(new Physiotherapist("Dr. Green", 51.5800, -0.2000, "Musculoskeletal Physiotherapy", 28));

// ✅ Sports Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Thompson", 51.7500, -0.3400, "Sports Physiotherapy", 35));
        allPhysiotherapists.add(new Physiotherapist("Dr. Wright", 51.8600, -0.4200, "Sports Physiotherapy", 40));

// ✅ Cardiovascular Disease
        allPhysiotherapists.add(new Physiotherapist("Dr. Hughes", 51.9700, -0.2800, "Cardiovascular Disease", 50));
        allPhysiotherapists.add(new Physiotherapist("Dr. Bennett", 51.2800, -0.3600, "Cardiovascular Disease", 55));

// ✅ Orthopedics
        allPhysiotherapists.add(new Physiotherapist("Dr. White", 51.1400, -0.1800, "Orthopedics", 60));
        allPhysiotherapists.add(new Physiotherapist("Dr. Black", 51.3200, -0.5200, "Orthopedics", 70));

// ✅ Vestibular Rehabilitation
        allPhysiotherapists.add(new Physiotherapist("Dr. Roberts", 51.6800, -0.7100, "Vestibular Rehabilitation", 80));
        allPhysiotherapists.add(new Physiotherapist("Dr. Hall", 51.7500, -1.2500, "Vestibular Rehabilitation", 90));

// ✅ Homecare Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Carter", 51.4000, -1.0000, "Homecare Physiotherapy", 95));
        allPhysiotherapists.add(new Physiotherapist("Dr. Adams", 51.3500, -0.8000, "Homecare Physiotherapy", 85));

// ✅ Pediatrics
        allPhysiotherapists.add(new Physiotherapist("Dr. Baker", 51.3000, -0.7000, "Pediatrics", 75));
        allPhysiotherapists.add(new Physiotherapist("Dr. Wilson", 51.2000, -0.6000, "Pediatrics", 65));

// ✅ Pelvic Floor
        allPhysiotherapists.add(new Physiotherapist("Dr. Cooper", 51.1000, -0.5000, "Pelvic Floor", 55));
        allPhysiotherapists.add(new Physiotherapist("Dr. Campbell", 51.0000, -0.4000, "Pelvic Floor", 45));

// ✅ Women's Health Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Parker", 50.9000, -0.3000, "Women's Health Physiotherapy", 35));
        allPhysiotherapists.add(new Physiotherapist("Dr. Edwards", 50.8000, -0.2000, "Women's Health Physiotherapy", 25));

// ✅ What is Physiotherapy?
        allPhysiotherapists.add(new Physiotherapist("Dr. Morris", 50.7000, -0.1000, "What is Physiotherapy?", 15));
        allPhysiotherapists.add(new Physiotherapist("Dr. Stewart", 50.6000, 0.0000, "What is Physiotherapy?", 5));

// ✅ Acupuncture
        allPhysiotherapists.add(new Physiotherapist("Dr. Turner", 50.5000, 0.1000, "Acupuncture", 10));
        allPhysiotherapists.add(new Physiotherapist("Dr. Phillips", 50.4000, 0.2000, "Acupuncture", 20));

// ✅ Magnetic Therapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Collins", 50.3000, 0.3000, "Magnetic Therapy", 30));
        allPhysiotherapists.add(new Physiotherapist("Dr. Foster", 50.2000, 0.4000, "Magnetic Therapy", 40));

// ✅ Manual Therapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Howard", 50.1000, 0.5000, "Manual Therapy", 50));
        allPhysiotherapists.add(new Physiotherapist("Dr. Ross", 50.0000, 0.6000, "Manual Therapy", 60));

// ✅ Oncology
        allPhysiotherapists.add(new Physiotherapist("Dr. Carter", 49.9000, 0.7000, "Oncology", 70));
        allPhysiotherapists.add(new Physiotherapist("Dr. Walker", 49.8000, 0.8000, "Oncology", 80));

// ✅ Post Operative Physiotherapist
        allPhysiotherapists.add(new Physiotherapist("Dr. Scott", 49.7000, 0.9000, "Post Operative Physiotherapist", 90));
        allPhysiotherapists.add(new Physiotherapist("Dr. Young", 49.6000, 1.0000, "Post Operative Physiotherapist", 100));

// ✅ Rehabilitation
        allPhysiotherapists.add(new Physiotherapist("Dr. King", 49.5000, 1.1000, "Rehabilitation", 110));
        allPhysiotherapists.add(new Physiotherapist("Dr. Allen", 49.4000, 1.2000, "Rehabilitation", 120));

// ✅ Chest Physiotherapy
        allPhysiotherapists.add(new Physiotherapist("Dr. Ward", 49.3000, 1.3000, "Chest Physiotherapy", 130));
        allPhysiotherapists.add(new Physiotherapist("Dr. Bailey", 49.2000, 1.4000, "Chest Physiotherapy", 140));

// ✅ Women's Health
        allPhysiotherapists.add(new Physiotherapist("Dr. Mitchell", 49.1000, 1.5000, "Women's Health", 150));
        allPhysiotherapists.add(new Physiotherapist("Dr. Cox", 49.0000, 1.6000, "Women's Health", 160));


        List<Physiotherapist> filteredPhysiotherapists = new ArrayList<>();

        for (Physiotherapist physio : allPhysiotherapists) {
            double distance = calculateDistance(patient, physio);

            // ✅ Filter by distance AND specialization
            if (distance != -1 && physio.getSpecialization().equalsIgnoreCase(patientSpecialization)) {
                physio.setDistance(distance);
                filteredPhysiotherapists.add(physio);
            }
        }

        if (filteredPhysiotherapists.isEmpty()) {
            model.addAttribute("noResultsMessage", "No physiotherapists found within your selected range :/ Please try expanding your radius :)");
        } else {
            model.addAttribute("physiotherapists", filteredPhysiotherapists);
        }

        return "physiotherapists";  // Refers to physiotherapists.html template
    }

    public double calculateDistance(Patient patient, Physiotherapist physiotherapist) {
        double lat1 = patient.getLatitude();
        double lon1 = patient.getLongitude();
        double lat2 = physiotherapist.getLatitude();
        double lon2 = physiotherapist.getLongitude();
        int patientRadius = patient.getPatientRadius();

        // Convert degrees to radians
        double radianLat1 = Math.toRadians(lat1);
        double radianLon1 = Math.toRadians(lon1);
        double radianLat2 = Math.toRadians(lat2);
        double radianLon2 = Math.toRadians(lon2);

        // Haversine formula
        double dlon = radianLon2 - radianLon1;
        double dlat = radianLat2 - radianLat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) +
                Math.cos(radianLat1) * Math.cos(radianLat2) *
                        Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Radius of the Earth (in km)
        double radius = 6371;

        // Calculate distance
        double distanceFromPatient = radius * c;

        // ✅ Only return distances within patient radius
        if (distanceFromPatient <= patientRadius) {
            return distanceFromPatient;
        } else {
            return -1;
        }
    }

}


