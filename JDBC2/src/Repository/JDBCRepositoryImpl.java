package Repository;

import Domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class JDBCRepositoryImpl implements JDBCRepository<User,Integer> {
    public String userName;
    public Integer userId;

    @Override
    public void findAllUser() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "123456789");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                HashMap<Integer,User> userHashMap = new HashMap<>();
                this.userName = rs.getString("userName");
                this.userId = rs.getInt("userId");
                User user = new User(userId,userName);
                userHashMap.put(userId,user);
                System.out.println(userHashMap);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void findUserById(Integer id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "123456789");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE userId = " + id +";");
            String query = "select * from user where userId = " + id +";";
            while (rs.next()) {
                this.userName = rs.getString("userName");
                this.userId = rs.getInt("userId");
                System.out.println("User Id : " + userId + "\nUser Name : " + userName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertUser(User user) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "123456789");

            Statement statement = con.createStatement();
            int rs = statement.executeUpdate("INSERT INTO user VALUES (" +user.getUserId() + ", ' " + user.getUserName() + "')" );
            String query = "INSERT INTO user VALUES (" +user.getUserId() + "," + user.getUserName() + ")";
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "123456789");

            Statement statement = con.createStatement();
            int rs = statement.executeUpdate("DELETE FROM USER WHERE userId = "+ userId +";");
            System.out.println("USER (" + userId + " , "+ userName +" ) DELETED SUCCESSFULLY.");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void deleteAllUser() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "123456789");

            Statement statement = con.createStatement();
            int rs = statement.executeUpdate("TRUNCATE TABLE USER");
            System.out.println("USERS DELETED SUCCESSFULLY.");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
