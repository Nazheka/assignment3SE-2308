package models;

import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Patient extends Person {
    private String diagnosis;
    private String admissionDate;

    public Patient(long UIN, String surname, String name, String patronymic, String birthday, float weight, float height, String diagnosis, String admissionDate) {
        super(UIN, surname, name, patronymic, birthday, weight, height);
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
    }

}

