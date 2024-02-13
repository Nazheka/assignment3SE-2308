package models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public abstract class Person {
    private long UIN;
    private String surname;
    private String name;
    private String patronymic;
    private boolean gender;
    private String birthday;
    private float weight;
    private float height;



}
