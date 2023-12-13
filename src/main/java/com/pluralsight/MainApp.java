package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

import static com.pluralsight.ConnectionManager.*;
import static com.pluralsight.DataManager.*;

public class MainApp {
    public static Scanner scan = new Scanner(System.in);
    public static String username, password;
    public static BasicDataSource ds = new BasicDataSource();
    public static Connection conn = null;
    public static PreparedStatement prepState = null;
    public static ResultSet rSet = null;

    public static void main(String[] args) throws SQLException {
        if(args.length != 2){
            login();
        }
        else{
            username = args[0];
            ds.setUsername(username);
            password = args[1];
            ds.setPassword(password);
        }
        start();
        searchDB();
    }
}
