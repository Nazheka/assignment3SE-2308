package models;
kwononvwovnoweoiwnefjewjfnwejnfjwnefjwnf

import java.sql.Date;
import lombok.*;

@Setter
@Getter

public class Patient extends Person {
    private float weight;
    private float height;
    private String therapist;
    private String bloodType;
    private String allergy;
    private String vaccination;
    private String medicalRecord;
    private String dateAttachment;

    public Patient() {
        super();
    }
    public Patient(String UIN, String surname, String name, String patronymic, boolean gender,
                   String birthday, float weight, float height, String therapist, String blood_type,
                   String allergy, String vaccination, String medicalRecord, String dateAttachment) {
        super(UIN, surname, name, patronymic, gender, birthday);
        setWeight(weight);
        setHeight(height);
        setTherapist(therapist);
        setBloodType(blood_type);
        setAllergy(allergy);
        setVaccination(vaccination);
        setMedicalRecord(medicalRecord);
        setDateAttachment(dateAttachment);
    }

    @Override
    public String toString() {
        return "Patient:" + super.toString() + '\'' +
                "weight=" + weight +
                ", height=" + height +
                ", therapist='" + therapist + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", allergy='" + allergy + '\'' +
                ", vaccination='" + vaccination + '\'' +
                ", medicalRecord='" + medicalRecord + '\'' +
                ", dateAttachment=" + dateAttachment +
                '}';
    }
}

