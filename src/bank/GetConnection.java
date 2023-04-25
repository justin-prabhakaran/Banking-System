/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author david
 */

class GetConnection {
    int id;
    String name;
    String date;
    double balance;
    
    public GetConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:/J:\\db\\Bank.db");
            Statement stmt = con.createStatement();
            String qryget = "SELECT * FROM banktable";
            ResultSet resultSet = stmt.executeQuery(qryget);
            while(resultSet.next()){
                id = resultSet.getInt("ID");
                date = resultSet.getString("DATES");
                balance = Double.valueOf(resultSet.getString("BALANCE"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
}


