package com.Pu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class DbTest  {
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/test?serverTimezone=CST&useUnicode=true&characterEncoding=Big5";

    Connection conn= null;
    public  void DBcon(JTable table,DefaultTableModel dtm) throws IOException{


        try {
            conn = DriverManager.getConnection(url, "root", "030200");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        try {
            Class.forName(driver);

            if(!conn.isClosed()){
                System.out.println("DB Connnection");


                String sql="SELECT * FROM test.quality";
                Statement statm=conn.createStatement();

                ResultSet rs=statm.executeQuery(sql);
                while(rs.next()){
                    String simd=rs.getString("SimpleDate".toString());
                    String testingd=rs.getString("TestingDate".toString());
                    String location=rs.getString("Location");
                    String lab=rs.getString("LabName");
                    String quantity=rs.getString("Quantity");
                    String month=rs.getString("Month".toString());
                    String week=rs.getString("Week".toString());
                    double culb=rs.getDouble("Cubic");

                    dtm.addRow(new Object[]{simd,testingd,location,lab,quantity,month,week,culb});



                }

            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
