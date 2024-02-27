package repositories.interfaces;

import models.Employee;
import models.Patient;

import java.util.List;
public interface IEmployeeRepository {
    List <Employee> getAllEmployees();
    boolean createEmployee(Employee employee);
    Employee getEmployee(String UIN);
    boolean deleteEmployee(String UIN);
    boolean changeSalary(String UIN, long salary);

}
