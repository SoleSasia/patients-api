package com.sas.patients.service;

import com.sas.patients.model.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> findAll();
    List<Patient> findByName(String name);
    Patient findByDni(String dni);
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
