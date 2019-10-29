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

public class DbInsert{
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/test?serverTimezone=CST&useUnicode=true&characterEncoding=Big5";

    Connection conn= null;
    public  void Insert() throws IOException{

        //JTextField j1,JTextField j2,JTextField j3,JTextField j4,JTextField j5,JTextField j6,JTextField j7,JTextField j8
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


                String sql="INSERT INTO test.quality(QualityNo,SimpleDate,TestingDate,Location,LabName,Quantity,Month,Week,Cubic) VALUES ('a004','2019-10-05','2019-10-07','二、三區B型集水井CC-1、CC-2頂版與牆身；三區A型集水井CB-9牆身','聯昇','1組','2019-10-12','2019-11-05','7.5')";

                PreparedStatement pstmt=conn.prepareStatement(sql);
                /*
                pstmt.setString(0,j1.getText());
                pstmt.setString(1,j2.getText());
                pstmt.setString(2,j3.getText());
                pstmt.setString(3,j4.getText());
                pstmt.setString(4,j5.getText());
                pstmt.setString(5,j6.getText());
                pstmt.setString(6,j7.getText());
                pstmt.setString(7,j8.getText());
            */

                pstmt.executeUpdate();
                pstmt.close();

            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
