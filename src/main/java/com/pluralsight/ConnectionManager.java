package com.pluralsight;

import static com.pluralsight.MainApp.*;

public class ConnectionManager {
    public static void login(){
        System.out.print("Username: ");
        username = scan.nextLine();
        ds.setUsername(username);
        System.out.print("Password: ");
        password = scan.nextLine();
        ds.setPassword(password);
    }

    public static void start(){
        try{
            ds.setUrl("jdbc:mysql://localhost:3306/sakila");
            conn = ds.getConnection();
        }
        catch(Exception connectionError){
            System.out.println("CONNECTION ERROR");
            connectionError.printStackTrace();
        }
    }
}
