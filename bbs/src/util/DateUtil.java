package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ���ʽ���ַ�����ʽ����ת��
 * @author Administrator
 *
 */
public class DateUtil {
	
   public static String Date2String(Date date){
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   String str = dateFormat.format(date);
	   return str;
	   
   }
   
   public static String Date2String(Date date,String str){
	   SimpleDateFormat dateFormat = new SimpleDateFormat(str);
	   String string = dateFormat.format(date);
	   return string;
	   
   }
   public static Date String2Date(String str){
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   Date date = null;
	   try {
		date =dateFormat.parse(str);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	   return date;
	   
   }
   

}
