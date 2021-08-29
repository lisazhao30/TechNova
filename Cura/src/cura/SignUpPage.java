package cura;

import cura.DatabaseConnection;
import cura.LoginPage;

import java.sql.Connection;
import java.sql.Statement;

public class SignUpPage {



    int currentUserID = LoginPage.getAccountUserID();

    // adds new user_account row
    public void registerUser(String name, String user, String password, String pronouns) {

        // database connection
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        // string concatentation for sql query code
        String insertFields = "INSERT INTO user_account(name, username, password, pronouns) VALUES('";
        String insertValues = name + "','" + user + "','" + password + "','" + pronouns + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            // added to database

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

    // adds new user_profile row
    public void registerUserForm(String education, String company, String role, String status, String interests, String other) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        // string concatentation for sql query code
        String insertFields = "INSERT INTO user_profile(iduser_account, education, company, role, status, interests, other) VALUES('";
        String insertValues = currentUserID + "','" + education + "','" + company + "','" + role + "','" + status + "','" + interests + "','" + other + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            // added to database

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}
