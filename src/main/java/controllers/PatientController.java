package controllers;

import java.util.List;
import models.Patient;
import repositories.interfaces.IPatientRepository;

import java.sql.Date;

public class PatientController {
    private final IPatientRepository repo;

    public PatientController(IPatientRepository repo) {
        this.repo = repo;
    }

    public String createPatient(String UIN, String surname, String name,
                                String patronymic, String gender, String birthday,
                                float weight, float height, String therapist, String bloodType,
                                String allergy, String vaccination, String medicalRecord, String dateAttachment) {
        boolean male = (gender.toLowerCase().equals("male"));
        Patient patient = new Patient(UIN, surname, name, patronymic, male, birthday,
                weight, height, therapist, bloodType, allergy, vaccination, medicalRecord, dateAttachment);
        boolean created = repo.createPatient(patient);
        return (created ? "Patient was successfully created" : "Patient creation was failed");
    }

    public String getPatient(String UIN) {
        Patient patient = repo.getPatient(UIN);
        return (patient == null ? "Patient was not found" : patient.toString());
    }

    public String getAllPatients() {
        List<Patient> patients = repo.getAllPatients();
        return patients.toString();
    }

    public String deletePatient(String UIN) {
        boolean deleted = repo.deletePatient(UIN);
        return (deleted ? "Patient was successfully deleted" : "Patient with such UIN was not found");
    }
    public String addNewDataToMedicalRecord(String UIN, String medicalRecord) {
        boolean added = repo.addNewDataToMedicalRecord(UIN, medicalRecord);
        return (added ? "New data was successfully added" : "New data was not added");
    }
}
