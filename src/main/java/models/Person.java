package models;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person {
    private String uin;
    private String surname;
    private String name;
    private String patronymic;
    private boolean gender;
    private String birthday;

    @Override
    public String toString() {
        return "{UIN='" + uin + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + (gender ? "Male" : "Female") + '\'' +
                ", birthday='" + birthday;
    }
}