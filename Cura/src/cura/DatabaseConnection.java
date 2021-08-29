package cura;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

        public static Connection databaseLink;


        /**
         * gets MySQL connection from localhost database and returns as a Connection link.
         * @return databaseLink
         */
        public static Connection getConnection() {
            String databaseName = "cura";
            String databaseUser = "ssrenali";
            String databasePassword = "94080059qQ";
            String url = "jdbc:mysql://localhost/" + databaseName;

            try {
                // register mySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // create connection using driver manager
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            } catch(Exception e) {
                e.printStackTrace();
                e.getCause();
            }

            return databaseLink;

        }
}
