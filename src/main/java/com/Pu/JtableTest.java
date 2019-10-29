package com.Pu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class JtableTest extends JFrame {
    BorderLayout blo=new BorderLayout(0,5);
    public   JFrame f1=new JFrame();
    static     JPanel  jpanl=new JPanel();
    public JTable table;
    JScrollPane jsc;
    JPanel jp;
    JPanel jp1;


    JLabel lab1=new JLabel("取樣日期:" );
    JLabel lab2=new JLabel("送驗日期:");
    JLabel lab3=new JLabel("部位:");
    JLabel lab4=new JLabel("試驗室:");
    JLabel lab5=new JLabel("組數:");
    JLabel lab6=new JLabel("28天");
    JLabel lab7=new JLabel("7天");
    JLabel lab=new JLabel("M3:");
    JLabel textlab=new JLabel("TEST");

    JTextField simd_text=new JTextField(30);
    JTextField testd_text=new JTextField(30);
    JTextField location_text=new JTextField(30);
    JTextField labname_text=new JTextField(30);
    JTextField count_text=new JTextField(30);
    JTextField month_text=new JTextField(30);
    JTextField week_text=new JTextField(30);
    JTextField culb_text=new JTextField(30);
    JButton btu=new JButton("新增");

    DefaultTableModel dtm=new DefaultTableModel();



    public  void JtableTest() throws IOException {
        f1.setTitle("表格測試");
        f1.setSize(500,300);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setLayout(blo);

       final String[] heads={"取樣日期","送驗日期","部位","試驗室","組數","28天","7天","M3"};

        Object obj[][]=new Object[][]{};



        JTable table=new JTable(obj,heads);


        dtm.setColumnIdentifiers(heads);


        jp=new JPanel();

        jp.add(lab1);
        jp.add(simd_text);
        jp.add(lab2);
        jp.add(testd_text);
        jp.add(lab3);
        jp.add(location_text);
        jp.add(lab4);
        jp.add(labname_text);
        jp.add(lab5);
        jp.add(count_text);
        jp.add(lab6);
        jp.add(month_text);
        jp.add(lab7);
        jp.add(week_text);
        jp.add(lab);
        jp.add(culb_text);
        jp.add(btu);
        jp.add(textlab);

        f1.add(jp,BorderLayout.CENTER);


        DbTest db=new DbTest();
        db.DBcon(table,dtm);

        jsc=new JScrollPane(table);

        f1.add(jsc,BorderLayout.SOUTH);

        table.setModel(dtm);



        btu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                    int column=table.getSelectedColumn();
//                    int row=table.getSelectedRow();
//                    String t=table.getModel().getValueAt(row,column).toString();
                        DbInsert dbin =new DbInsert();
                try {
                    dbin.Insert();
                    table.updateUI();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("新增不成!!");
                }


                textlab.setText("測試!!");
            }
        });

    }


}
