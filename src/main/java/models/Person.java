package models;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person {
    private String UIN;
    private String surname;
    private String name;
    private String patronymic;
    private boolean gender;
    private String birthday;

    @Override
    public String toString() {
        return "{UIN='" + UIN + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + (gender ? "Male" : "Female") + '\'' +
                ", birthday='" + birthday;
    }
}