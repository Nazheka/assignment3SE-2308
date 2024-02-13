import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee extends Person {
    private String employeeId;
    private String speciality;
    private int workExperience;
    private String appointmentTime;
    private double salary;
    private int vacationDays;

    public Employee(String employeeId, String speciality, int workExperience, String appointmentTime, double salary, int vacationDays) {
        super();
        this.employeeId = employeeId;
        this.speciality = speciality;
        this.workExperience = workExperience;
        this.appointmentTime = appointmentTime;
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public void increaseOfSalaryByWorkExperience() {
        int yearsOfExperience = workExperience / 12;
        int numberOfIncreases = yearsOfExperience;
        double newSalary = salary;
        for (int i = 0; i < numberOfIncreases; i++) {
            newSalary += newSalary * 0.5;
        }
        setSalary(newSalary);
    }

    public void printEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Gender: " + getGender());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Speciality: " + getSpeciality());
        System.out.println("Work Experience: " + getWorkExperience() + " years");
        System.out.println("Appointment Time: " + getAppointmentTime());
        System.out.println("Salary: $" + getSalary());
        System.out.println("Employee is on vacation for " + getVacationDays() + " days");
    }
}