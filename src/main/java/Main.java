import controllers.EmployeeController;
import controllers.PatientController;
import database.PostgresDB;
import database.interfaces.IDB;
import repositories.EmployeeRepository;
import repositories.PatientRepository;
import repositories.interfaces.IEmployeeRepository;
import repositories.interfaces.IPatientRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IPatientRepository repo1 = new PatientRepository(db);
        IEmployeeRepository repo2 = new EmployeeRepository(db);
        PatientController controller1 = new PatientController(repo1);
        EmployeeController controller2 = new EmployeeController(repo2);
        MyApplication app = new MyApplication(controller1, controller2);
        app.start();
    }
}
