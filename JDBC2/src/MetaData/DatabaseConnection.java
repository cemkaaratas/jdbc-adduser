package MetaData;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String ... args){
        try{
            getConnection();
        }catch (Exception e){
        System.out.println(e);}
    }

    public static void getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "123456789");
            System.out.println("Connection to server " + "jdbc:mysql://localhost:3306/deneme" +" has established successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
