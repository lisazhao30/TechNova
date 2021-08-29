package cura;

import cura.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginPage {

    String user;
    String pass;
    private static int accountUserID;

    // checks if username and password is blank, if not validate login (call method)
    public void loginButton (String username, String password) {
        user = username;
        pass = password;
        if (!username.isBlank() && !password.isBlank()) {
            validateLogin();

        } else {
            //loginMessageLabel.setText("Please enter login information");
        }

    }

    public boolean validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        // SQL statement
        //find the total count of matching username and password row (should only be 1)
        String verifyLogin = "SELECT count(1), iduser_account FROM user_account WHERE username = '" + user + "' AND password = '" + pass + "'  group by iduser_account";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                // if result returns only 1 count, indicates user exists and password matches
                // if user account exists, get the user ID to global variable that can be
                // referenced later
                if (queryResult.getInt(1) == 1) {
                    accountUserID = queryResult.getInt(2);
                    //open dashboard
                    return true;

                } else {
                    return false;
                }
            }
            return false;

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }

    public static int getAccountUserID(){
        return accountUserID;
    }


}
