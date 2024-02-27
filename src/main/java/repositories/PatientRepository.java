package repositories;

import database.interfaces.IDB;
import models.Patient;
import repositories.interfaces.IPatientRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PatientRepository implements IPatientRepository {
    private final IDB db;
    public PatientRepository(IDB db) {
        this.db = db;
    }
    @Override
    public List<Patient> getAllPatients() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * from patient";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Patient> patients = new LinkedList<>();
            while (rs.next()) {
                Patient patient = new Patient(rs.getString("UIN"), rs.getString("surname"),
                        rs.getString("name"), rs.getString("patronymic"),
                        rs.getBoolean("gender"), rs.getString("birthday"),
                        rs.getFloat("weight"), rs.getFloat("height"),
                        rs.getString("therapist"), rs.getString("bloodType"),
                        rs.getString("allergy"), rs.getString("vaccination"),
                        rs.getString("medicalRecord"), rs.getString("dateAttachment"));
                patients.add(patient);
            }
            return patients;

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
    public boolean createPatient(Patient patient) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO patient(UIN, surname, name, patronymic, gender, "
                    + "birthday, weight, height, therapist, bloodType, allergy, vaccination, "
                    + "medicalRecord, dateAttachment VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, patient.getUIN());
            st.setString(2, patient.getSurname());
            st.setString(3, patient.getName());
            st.setString(4, patient.getPatronymic());
            st.setBoolean(5, patient.isGender());
            st.setString(6, patient.getBirthday());
            st.setFloat(7, patient.getWeight());
            st.setFloat(8, patient.getHeight());
            st.setString(9, patient.getTherapist());
            st.setString(10, patient.getBloodType());
            st.setString(11, patient.getAllergy());
            st.setString(12, patient.getVaccination());
            st.setString(13, patient.getMedicalRecord());
            st.setString(14, patient.getDateAttachment());
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
    public Patient getPatient(String UIN) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM patient WHERE UIN=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, UIN);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient(rs.getString("UIN"), rs.getString("surname"),
                        rs.getString("name"), rs.getString("patronymic"),
                        rs.getBoolean("gender"), rs.getString("birthday"),
                        rs.getFloat("weight"), rs.getFloat("height"),
                        rs.getString("therapist"), rs.getString("bloodType"),
                        rs.getString("allergy"), rs.getString("vaccination"),
                        rs.getString("medicalRecord"), rs.getString("dateAttachment"));
                return patient;
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
    public boolean deletePatient(String UIN) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "DELETE FROM patient WHERE UIN=?";
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
    public boolean addNewDataToMedicalRecord(String UIN, String medicalRecord) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE patient SET medicalRecord += '?' WHERE UIN = '?'";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, medicalRecord);
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


