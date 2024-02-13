package models;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person {
    private long UIN;
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private float weight;
    private float height;
}
