package com.sas.patients.service;

import com.sas.patients.model.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> getPatients();
    List<Patient> getPatientsByPartialName(String name);
    Patient getPatientByDni(String dni);
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
