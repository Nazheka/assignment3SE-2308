import controllers.EmployeeController;
import controllers.PatientController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final PatientController controller1;
    private final EmployeeController controller2;
    private final Scanner sc;

    public MyApplication(PatientController controller1, EmployeeController controler2) {
        this.controller1 = controller1;
        this.controller2 = controler2;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("**********************");
            System.out.println("Welcome to Medcards Database!");
            System.out.println("Select an option:");
            System.out.println("1. Employees");
            System.out.println("2. Patients");
            System.out.println("3. Exit");
            System.out.println();
            try {
                System.out.println("Enter an option (1-3): ");
                int option = sc.nextInt();
                if(option == 1) {
                    while(true) {
                        System.out.println();
                        System.out.println("Select another option:");
                        System.out.println("1. Get all employees");
                        System.out.println("2. Create an employee");
                        System.out.println("3. Find an employee by UIN");
                        System.out.println("4. Delete an employee by UIN");
                        System.out.println("5. Change salary of an employee by UIN");
                        System.out.println("6. Get to previous page");
                        System.out.println();
                        try {
                            System.out.println("Enter an option (1-6): ");
                            int option1 = sc.nextInt();
                            if(option1 == 1) {
                                getAllEmployeesMenu();
                            } else if (option1 == 2) {
                                createEmployeeMenu();
                            } else if(option1 == 3) {
                                getEmployeeMenu();
                            } else if(option1 == 4) {
                                deleteEmployeeMenu();
                            } else if (option1 == 5) {
                                changeSalaryMenu();
                            } else if (option1 == 6) {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input must be an integer");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("**********************");
                    }
                } else if (option == 2) {
                    while(true) {
                        System.out.println();
                        System.out.println("Select another option:");
                        System.out.println("1. Get all patients");
                        System.out.println("2. Create a patient");
                        System.out.println("3. Find a patient by UIN");
                        System.out.println("4. Delete a patient by UIN");
                        System.out.println("5. Add new data to medical record of a patient by UIN");
                        System.out.println("6. Get to previous page");
                        System.out.println();
                        try {
                            System.out.println("Enter an option (1-6): ");
                            int option1 = sc.nextInt();
                            if(option1 == 1) {
                                getAllPatientsMenu();
                            } else if (option1 == 2) {
                                createPatientMenu();
                            } else if(option1 == 3) {
                                getPatientMenu();
                            } else if(option1 == 4) {
                                deletePatientMenu();
                            } else if (option1 == 5) {
                                addNewDataToMedicalRecordMenu();
                            } else if (option1 == 6) {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input must be an integer");
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("**********************");
                    }
                } else if (option == 3) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("**********************");
        }
    }
    public void getAllEmployeesMenu() {
        String response = controller2.getAllEmployees();
        System.out.println(response);
    }
    public void getEmployeeMenu() {
        System.out.println("Enter the UIN: ");
        String UIN = sc.next();
        String response = controller2.getEmployee(UIN);
        System.out.println(response);
    }
    public void createEmployeeMenu() {
        System.out.println("Enter the UIN: ");
        String UIN = sc.next();
        System.out.println("Enter the surname: ");
        String surname = sc.next();
        System.out.println("Enter the name: ");
        String name = sc.next();
        System.out.println("Enter the Patronymic: ");
        String patronymic = sc.next();
        System.out.println("Enter the gender: ");
        String gender = sc.next();
        System.out.println("Enter the birthday (YYYY-MM-DD): ");
        String birthday = sc.next();
        System.out.println("Enter the speciality: ");
        String speciality = sc.next();
        System.out.println("Enter the work experience in months: ");
        int workExperience = sc.nextInt();
        System.out.println("Enter the work graphic: ");
        String workGraphic = sc.next();
        System.out.println("Enter the salary: ");
        long salary = sc.nextLong();
        System.out.println("Enter the vacation days: ");
        int vacation = sc.nextInt();
        String response = controller2.createEmployee(UIN, surname, name, patronymic, gender,
                birthday, speciality, workExperience, workGraphic, salary, vacation);
        System.out.println(response);
    }
    public void deleteEmployeeMenu() {
        System.out.println("Enter the UIN of an employee that you'd like to delete: ");
        String UIN = sc.next();
        String response = controller2.deleteEmployee(UIN);
        System.out.println(response);
    }
    public void changeSalaryMenu() {
        System.out.println("Enter the UIN of employee and new salary: ");
        String UIN = sc.next();
        long salary = sc.nextLong();
        String response = controller2.changeSalary(UIN, salary);
        System.out.println(response);
    }
    public void getAllPatientsMenu() {
        String response = controller1.getAllPatients();
        System.out.println(response);
    }
    public void getPatientMenu() {
        System.out.println("Enter the UIN: ");
        String UIN = sc.next();
        String response = controller1.getPatient(UIN);
        System.out.println(response);
    }
    public void createPatientMenu() {
        LocalDate currentDate = LocalDate.now();
        String currentDateString = currentDate.toString();
        System.out.println("Enter the UIN: ");
        String UIN = sc.next();
        System.out.println("Enter the surname: ");
        String surname = sc.next();
        System.out.println("Enter the name: ");
        String name = sc.next();
        System.out.println("Enter the Patronymic: ");
        String patronymic = sc.next();
        System.out.println("Enter the gender: ");
        String gender = sc.next();
        System.out.println("Enter the birthday (YYYY-MM-DD): ");
        String birthday = sc.next();
        System.out.println("Enter the weight: ");
        float weight = sc.nextFloat();
        System.out.println("Enter th height: ");
        float height = sc.nextFloat();
        System.out.println("Enter the therapist: ");
        String therapist = sc.next();
        System.out.println("Enter the blood type: ");
        String bloodType = sc.next();
        System.out.println("Enter the allergies: ");
        String allergy = sc.next();
        System.out.println("Enter all vaccinations: ");
        String vaccination = sc.next();
        System.out.println("Enter the medical record: ");
        String medicalRecord = sc.next();
        String response = controller1.createPatient(UIN, surname, name, patronymic, gender,
                birthday, weight, height, therapist, bloodType, allergy, vaccination, medicalRecord, currentDateString);
        System.out.println(response);
    }
    public void deletePatientMenu() {
        System.out.println("Enter the UIN of a patient that you'd like to delete: ");
        String UIN = sc.next();
        String response = controller1.deletePatient(UIN);
        System.out.println(response);
    }
    public void addNewDataToMedicalRecordMenu() {
        System.out.println("Enter the UIN of a patient and new data: ");
        String UIN = sc.next();
        String medicalRecord = sc.next();
        String response = controller1.addNewDataToMedicalRecord(UIN, medicalRecord);
        System.out.println(response);
    }
}