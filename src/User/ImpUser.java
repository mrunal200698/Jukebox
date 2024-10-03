package User;

import Songs.Songs;

import java.sql.*;
import java.util.Scanner;

public class ImpUser implements IUser
{
    Scanner sc = new Scanner(System.in);
    @Override
    public void newUser() {
        //System.out.println("Welcome To Music World");
        //System.out.println("Enter Customer Id");
        //int customerId = sc.nextInt();
    	
        int min = 01;
        int max = 100;
        int userId = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("Enter Name");
        String name = sc.next();
        System.out.println("Enter Mail ID");
        String mailid = sc.next();

        try {
//        	Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");

            String myquery1 = "insert into user values(?,?,?)";
            PreparedStatement pst1 = connection.prepareStatement(myquery1);
            pst1.setInt(1, userId);
            pst1.setString(2, name);
            pst1.setString(3, mailid);
            pst1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Registered Successfully");
        System.exit(0);
    }

    public  void login(int userId)
    {
        String name="";
        int id1=0;
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            String myquery1 = "select * from user where userId='"+userId+"' ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(myquery1);


            while (rs.next())
            {
                name=rs.getString("userName");
                id1= rs.getInt("userId");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(userId==id1)
        {
            System.out.println("Welcome " + name);
        }
        else {
            System.out.println("Enter correct ID");
            System.exit(0);
        }
        System.out.println();


    }

}
