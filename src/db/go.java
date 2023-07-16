/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import universitymanagementsystem.Tools;

/**
 *
 * @author amjd
 */
public class go {
    static Connection con;
    private static String Url="";
    private static String UserName="amjd";
    
    //هنا فسم الأتصال مع قواعد البيانات
    public static void setUrl(){
         Url="jdbc:oracle:thin:@//localhost:1521/orcl";
     }
    
    static void setConnection(){
        try {
            setUrl();
            setCon((Connection) DriverManager.getConnection(Url, getUserName(),"alhashede"));
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
     }
     
     public static void setCon(Connection aCon) {
        con = (Connection) aCon;
    }
    
    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
    public static String getUserName() {
        return UserName;
    }
    public static void setUserName(String aUserName) {
        UserName = aUserName;
    }
}
