package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class User {
    int userId;
    String userName;
    String userMailId;

    public User(int userId, String userName, String userMailId) {
        this.userId = userId;
        this.userName = userName;
        this.userMailId = userMailId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMailId() {
        return userMailId;
    }

    public  String toString()
    {
        return getUserMailId()+"\t"+getUserName()+"\t"+getUserMailId();
    }
}
