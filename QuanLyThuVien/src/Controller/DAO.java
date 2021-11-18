/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author loqco
 */
public class DAO {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            try{
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien","sa","123456");
  
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            System.out.print("not found");
        }
        return con;
    }
}
