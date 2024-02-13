pakage
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee extends Person {
    private String employeeId;
    private String speciality;
    private int workExperience;
    private String appointmentTime;
    private double salary;
    private int vacationDays;

    public void increaseOfSalaryByWorkExperience() {
        int yearsOfExperience = workExperience / 12;
        int numberOfIncreases = yearsOfExperience;
        double newSalary = salary;
        for (int i = 0; i < numberOfIncreases; i++) {
            newSalary += newSalary * 0.5;
        }
        setSalary(newSalary);
    }

}