import models.Patient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient details:");
        System.out.print("IIN: ");
        long UIN = scanner.nextLong();
        scanner.nextLine(); // съедаем перевод строки

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Patronymic");
        String patronymic = scanner.nextLine();

        System.out.print("Birthday: ");
        String birthday = scanner.nextLine();

        System.out.print("Weight: ");
        float weight = scanner.nextFloat();
        scanner.nextLine(); // съедаем перевод строки

        System.out.print("Height: ");
        float height = scanner.nextFloat();
        scanner.nextLine(); // съедаем перевод строки

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("AdmissionDate: ");
        String admissionDate = scanner.nextLine();

        Patient patient = new Patient(UIN, surname, name, patronymic, birthday, weight, height, diagnosis, admissionDate);

        System.out.println("NewPatient:");
        System.out.println(patient);

        scanner.close();
    }
}
