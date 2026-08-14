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
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }//todo: se trae todo de la database -> paginar

    @Override
    public List<Patient> getPatientsByPartialName(String name) {

        return patientRepository.findAll().stream()//todo: se trae todo de la database ->ineficiente
                .filter(p -> p.getFirstName().toLowerCase().contains(name.toLowerCase()) ).toList();
    }

    @Override
    public Patient getPatientByDni(String dni) {
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
        Patient updatedPatient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Paciente no encontrado."));

        updatedPatient.setDni(patient.getDni());
        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setEmail(patient.getEmail());
        updatedPatient.setTelephone(patient.getTelephone());
        updatedPatient.setHealthCare(patient.getHealthCare());

        return patientRepository.save(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Paciente no encontrado.");
        }
        patientRepository.deleteById(id);
    }

}
