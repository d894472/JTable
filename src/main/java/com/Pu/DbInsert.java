package com.Pu;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class DbInsert{
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/test?serverTimezone=CST&useUnicode=true&characterEncoding=Big5";

    Connection conn= null;
    int nos;


    public  void Insert(JTextField j1, JTextField j2, JTextField j3, JTextField j4, JTextField j5, JTextField j7, JTextField j8, JTextField j9, JDateChooser jdc, JDateChooser jdc1) throws IOException{



        try {
            conn = DriverManager.getConnection(url, "root", "030200");
            Class.forName(driver);

            if(!conn.isClosed()){
                System.out.println("DB Connnection");

                String sqlno="SELECT *FROM test.quality order by QualityNo desc limit 0,1";
                Statement stam=conn.createStatement();
                ResultSet rsrt=stam.executeQuery(sqlno);

                while (rsrt.next()){

                    String sno=rsrt.getString("QualityNo");
                    nos=Integer.parseInt(sno);
                    nos=nos+1;
                    System.out.println("SNO:"+ nos);
                    j1.setText(String.valueOf(nos));

                }


                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Calendar caler=Calendar.getInstance();
                String stp=sdf.format(jdc.getDate());
                j2.setText(stp);
                String stp1=sdf.format(jdc1.getDate());
                j3.setText(stp1);

                Date dt=sdf.parse(stp1);
                caler.setTime(dt);
                caler.add(Calendar.DAY_OF_YEAR,28);
                String dt1=sdf.format(caler.getTime());
                j8.setText(dt1);


                String sql="INSERT INTO test.quality(QualityNo,SimpleDate,TestingDate,Location,LabName,Quantity,Month,Cubic) VALUES (?,?,?,?,?,?,?,?)";  //String sql="INSERT INTO test.quality(QualityNo,SimpleDate,TestingDate,Location,LabName,Quantity,Month,Week,Cubic) VALUES ('a004','2019-10-05','2019-10-07','二、三區B型集水井CC-1、CC-2頂版與牆身；三區A型集水井CB-9牆身','聯昇','1組','2019-10-12','2019-11-05','7.5')";

                PreparedStatement pstmt=conn.prepareStatement(sql);

                pstmt.setString( 1,j1.getText());
                pstmt.setString(2,j2.getText());
                pstmt.setString(3,j3.getText());
                pstmt.setString(4,j4.getText());
                pstmt.setString(5,j5.getText());
              //  pstmt.setString(6,j6.getText());
                pstmt.setString(6,j7.getText());
                pstmt.setString(7,j8.getText());
                pstmt.setDouble(8, Double.parseDouble(j9.getText()));

                pstmt.executeUpdate();
                pstmt.close();

            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


}
