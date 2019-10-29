package com.Pu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
       String d="20190926";
        try {
            Date dt = sdf.parse(d);
            Calendar cald=Calendar.getInstance();
            cald.setTime(dt);
            //cald.add(Calendar.DAY_OF_YEAR,30);
            System.out.println(sdf.format(cald.getTime()));
          int   week=cald.get(Calendar.DAY_OF_WEEK)-1;
            switch (week){
                case  0:
                    System.out.println("星期日");
                    break;
                case  1:
                    System.out.println("星期一");
                    break;
                case  2:
                    System.out.println("星期二");
                    break;
                case  3:
                    System.out.println("星期三");
                    break;
                case  4:
                    System.out.println("星期四");
                    break;
                case  5:
                    System.out.println("星期五");
                    break;
                case  6:
                    System.out.println("星期六");
                    break;


            }



           // System.out.println(cald.get(Calendar.DAY_OF_WEEK));



        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
