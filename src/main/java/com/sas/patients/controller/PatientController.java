package com.sas.patients.controller;

import com.sas.patients.model.Patient;
import com.sas.patients.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }
    
    @GetMapping("/patient/{name}")
    public List<Patient> getPatientsByName(@PathVariable String name) {
        return patientService.getPatientsByName(name);
    }

    @GetMapping("/patient/{dni}")
    public Patient getPatientByDni(@PathVariable String dni) {
        return patientService.getPatientByDni(dni);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }
}
