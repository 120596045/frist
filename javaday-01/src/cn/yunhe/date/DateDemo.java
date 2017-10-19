package cn.yunhe.date;

import java.text.DateFormat;
import java.util.Date;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DateDemo {

	public static void main(String[] args) {
		
		/*date();*/
		dateFormatDemo();
	}
   public static void date(){
	   Date date = new Date();
		System.out.println(date);
   }
   
   public static void dateFormatDemo(){
	   DateFormat df = DateFormat.getDateInstance();
	   Date date = new Date();
	   System.out.println(df.format(date));
	   DateFormat df2 = DateFormat.getTimeInstance();

	   System.out.println(df2.format(date));
   }
}
