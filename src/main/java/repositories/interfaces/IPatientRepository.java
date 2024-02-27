package repositories.interfaces;

import models.Patient;
import java.util.List;
public interface IPatientRepository {
    List <Patient> getAllPatients();
    boolean createPatient(Patient patient);
    Patient getPatient(String UIN);
    boolean deletePatient(String UIN);
    boolean addNewDataToMedicalRecord(String UIN, String medicalRecord);
}
