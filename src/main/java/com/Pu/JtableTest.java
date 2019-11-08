package com.Pu;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class JtableTest extends JFrame {
    BorderLayout blo=new BorderLayout(0,5);
    public   JFrame f1=new JFrame();
    static     JPanel  jpanl=new JPanel();
    public JTable table;
    JScrollPane jsc;
    JPanel jp;
    JPanel jp1;
int no=0;


    JLabel labno=new JLabel("編號:" );
    JLabel lab1=new JLabel("取樣日期:" );
    JLabel lab2=new JLabel("送驗日期:");
    JLabel lab3=new JLabel("部位:");
    JLabel lab4=new JLabel("試驗室:");
    JLabel lab5=new JLabel("組數:");
    JLabel lab6=new JLabel("28天");
    JLabel lab7=new JLabel("7天");
    JLabel lab=new JLabel("M3:");
    JLabel textlab=new JLabel("請輸入欲刪除資料編號:");

    JTextField no_text=new JTextField(30);
    JTextField simd_text=new JTextField(30);
    JTextField testd_text=new JTextField(30);
    JTextField location_text=new JTextField(30);
    JTextField labname_text=new JTextField(30);
    JTextField count_text=new JTextField(30);
    JTextField month_text=new JTextField(30);

    JTextField culb_text=new JTextField(30);

    JTextField delete_text=new JTextField(30);

    JButton insertbtu=new JButton("新增");
    JButton deletebtu= new JButton("刪除");
    JButton dat=new JButton("000");


    DefaultTableModel dtm=new DefaultTableModel();


    Calendar caln=Calendar.getInstance();
    JDateChooser jdc=new JDateChooser(caln.getTime());
    JDateChooser jdc1=new JDateChooser(caln.getTime());

    public  void JtableTest() throws IOException {
        f1.setTitle("品管試驗");
        f1.setSize(550,350);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLayout(blo);

       final String[] heads={"編號","取樣日期","送驗日期","部位","試驗室","組數","28天","M3"};


        Object obj[][]=new Object[][]{};

        JTable table=new JTable(obj,heads);

        dtm.setColumnIdentifiers(heads);

        simd_text.setVisible(false);
        testd_text.setVisible(false);
        lab6.setVisible(false);
        month_text.setVisible(false);

        jp=new JPanel();

        jp.add(labno);
        jp.add(no_text);
        jp.add(lab1);
        jp.add(simd_text);
        jp.add(jdc);
        jp.add(lab2);
        jp.add(testd_text);
        jp.add(jdc1);
        jp.add(lab3);
        jp.add(location_text);
        jp.add(lab4);
        jp.add(labname_text);
        jp.add(lab5);
        jp.add(count_text);
        jp.add(lab6);
        jp.add(month_text);
//        jp.add(lab7);
//        jp.add(week_text);
        jp.add(lab);
        jp.add(culb_text);
        jp.add(insertbtu);
        jp.add(textlab);
        jp.add(delete_text);
        jp.add(deletebtu);


        f1.add(jp,BorderLayout.CENTER);

         no_text.setEditable(false);

        DbTest db=new DbTest();
        db.DBcon(table,dtm);
        //System.out.println("MONO:"+no);
        SelectNo sno=new SelectNo();
        sno.SelectNo(no_text);



        jsc=new JScrollPane(table);

        f1.add(jsc,BorderLayout.SOUTH);

        table.setModel(dtm);


            //新增按鈕
        insertbtu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if(no_text.getText()!="" &&simd_text.getText()!=""){

                        DbInsert dbin =new DbInsert();
                        try {
                            dbin.Insert(no_text,simd_text,testd_text,location_text,labname_text,count_text,month_text,count_text,jdc,jdc1);


                            textlab.setText("新增成功!!");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                            System.out.println("新增不成!!");
                        }

                    }
                    else{
                        System.out.println("資料輸入不完整!!無法新增資料");

                    }
            }
        });


        //刪除按鈕
        deletebtu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  int column=table.getSelectedColumn();
                  int row=table.getSelectedRow();
                  String t= no_text.getText();//table.getModel().getValueAt(row,0).toString();
                  Delete del=new Delete();
                  del.Del(no_text);
                System.out.println("刪除成功!!");

            }
        });

//        dat.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//                String stp=sdf.format(jdc.getDate());
//                simd_text.setText(stp);
//                String stp1=sdf.format(jdc1.getDate());
//                testd_text.setText(stp1);
//            }
//        });

    }


}
