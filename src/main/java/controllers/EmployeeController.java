package controllers;

import java.util.List;
import models.Employee;
import models.Patient;
import repositories.interfaces.IEmployeeRepository;

import java.sql.Date;

public class EmployeeController {
    private final IEmployeeRepository repo;
    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }
    public String createEmployee(String UIN, String surname, String name,
                                 String patronymic, String gender, String birthday,
                                 String speciality, int workExperience, String workGraphic,
                                 long salary, int vacation) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(UIN, surname, name, patronymic, male, birthday,
                speciality, workExperience, workGraphic, salary, vacation);
        boolean created = repo.createEmployee(employee);
        return (created ? "Employee was successfully created" : "Employee creation was failed");
    }
    public String getEmployee(String UIN) {
        Employee employee = repo.getEmployee(UIN);
        return (employee == null ? "Employee was not found" : employee.toString());
    }
    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
    public String deleteEmployee(String UIN) {
        boolean deleted = repo.deleteEmployee(UIN);
        return (deleted ? "User was successfully deleted" : "User with such UIN was not found");
    }
    public String changeSalary(String UIN, long salary){
        boolean changed = repo.changeSalary(UIN, salary);
        return (changed ? "salary was changed successfully" : "salary was not changed");
    }
}
