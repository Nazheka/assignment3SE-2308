package database;

import database.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:2807/MedcardsDB";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionURL, "postgres", "0000");
            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
