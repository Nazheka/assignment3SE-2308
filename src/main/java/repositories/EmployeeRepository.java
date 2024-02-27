package repositories;

import database.interfaces.IDB;
import models.Employee;
import org.postgresql.util.PSQLException;
import repositories.interfaces.IEmployeeRepository;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDB db;
    public EmployeeRepository(IDB db) {
        this.db = db;
    }
    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new LinkedList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getString("uin"), rs.getString("surname"),
                        rs.getString("name"), rs.getString("patronymic"),
                        rs.getBoolean("gender"), rs.getString("birthday"),
                        rs.getString("speciality"), rs.getInt("workExperience"),
                        rs.getString("workGraphic"), rs.getLong("salary"),
                        rs.getInt("vacation"));
                employees.add(employee);
            }
            return employees;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO employee (uin, surname" +
                    ", name, patronymic, gender, birthday, " +
                    "speciality, workExperience, workGraphic, " +
                    "salary, vacation) VALUES (" + employee.getUin() + ", " + employee.getSurname() + " , " +
                    employee.getName() + ", " + employee.getPatronymic() + ", " + employee.isGender() + " ,  " + employee.getBirthday() + " , " +
                    employee.getSpeciality() + " , " + employee.getWorkExperience() + " , " + employee.getWorkGraphic() + ", " +
                    employee.getSalary() + ", " + employee.getVacation()+ ")";
            Statement st = con.createStatement();
            st.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (PSQLException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee(String UIN) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM employee WHERE UIN=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, UIN);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getString("UIN"), rs.getString("surname"),
                        rs.getString("name"), rs.getString("patronymic"),
                        rs.getBoolean("gender"), rs.getString("birthday"),
                        rs.getString("speciality"), rs.getInt("workExperience"),
                        rs.getString("workGraphic"), rs.getLong("salary"),
                        rs.getInt("vacation"));
                return employee;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean deleteEmployee(String UIN) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM employee WHERE UIN=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, UIN);
            st.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean changeSalary(String UIN, long salary) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE employee SET salary = ? WHERE UIN = " + "?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, salary);
            st.setString(2, UIN);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
