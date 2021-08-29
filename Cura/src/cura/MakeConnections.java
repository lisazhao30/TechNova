package cura;

import cura.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;


public class MakeConnections {
    private static int mentorUserID;


    // finds mentor with same interests as mentee and returns the mentors id number
    //returns -1 if no mentor is found
    public int connect(String interests){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        // splits interests listed by mentee into array of single words
        //List<String> interestList = Arrays.asList(interests.split(","));

        String verifyLogin = "SELECT count(1), iduser_account FROM user_account WHERE interests = '" + interests + "' AND status = '" + "mentor" + "'  group by iduser_account";

        try{
        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifyLogin);

        while(queryResult.next()) {
            // if result returns only 1 count, indicates user exists and password matches
            // if user account exists, get the user ID to global variable that can be
            // referenced later
            if (queryResult.getInt(1) == 1) {
                mentorUserID = queryResult.getInt(2);
                return mentorUserID;

            }
        }

    } catch(Exception e) {
        e.printStackTrace();
        e.getCause();
    }
        return -1;
}

    public void setPremium() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        // splits interests listed by mentee into array of single words
        //List<String> interestList = Arrays.asList(interests.split(","));
        int currentUserID = LoginPage.getAccountUserID();
        String query = "SELECT count(1), iduser_account FROM user_account WHERE interests = '" + interests + "' AND status = '" + "mentor" + "'  group by iduser_account";

    }



    // adds premium

}
