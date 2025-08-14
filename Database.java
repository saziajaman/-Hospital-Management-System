package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    Connection connection;
    Statement statement;

    public Database() {
        try {
            // Connect to MySQL with root user and no password
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_management_system",
                    "root",
                    ""
            );
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // Will show errors in console if connection fails
        }
    }
}
