package com.sas.patients.service;

import com.sas.patients.exception.PatientNotFoundException;
import com.sas.patients.model.Patient;
import com.sas.patients.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService implements IPatientService{

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByName(String name) {

        return patientRepository.findAll().stream()//todo: se trae todo de la database ->ineficiente
                .filter(p -> p.getFirstName().contains(name) ).toList();
    }

    @Override
    public Patient findByDni(String dni) {
        if (dni == null || dni.isBlank()){
            throw new IllegalArgumentException("El DNI proporcionado no es válido.");
        }
        return patientRepository.findAll().stream()//todo: se trae todo de la database ->ineficiente
                .filter(p -> p.getDni().equals(dni)).findFirst().orElseThrow(() ->
                        new PatientNotFoundException("Paciente no encontrado con DNI:" + dni));
    }

    @Override
    public Patient createPatient(Patient patient) { return patientRepository.save(patient); }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(Long id) {

    }

}
