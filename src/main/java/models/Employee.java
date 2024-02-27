package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter

public class Employee extends Person {
    private String speciality;
    private int workExperience;
    private String workGraphic;
    private long salary;
    private int vacation;

    public Employee() {
        super();
    }
    public Employee(String UIN, String surname, String name, String patronymic, boolean gender,
                   String birthday, String speciality, int workExperience, String workGraphic, long salary, int vacation) {
        super(UIN, surname, name, patronymic, gender, birthday);
        setSpeciality(speciality);
        setWorkExperience(workExperience);
        setWorkGraphic(workGraphic);
        setSalary(salary);
        setVacation(vacation);
    }
    @Override
    public String toString() {
        return "Employee{" + super.toString() + '\'' +
                "speciality='" + speciality + '\'' +
                ", workExperience=" + workExperience +
                ", appointmentTime='" + workGraphic + '\'' +
                ", salary=" + salary +
                ", vacationDays=" + vacation +
                '}';
    }
}


