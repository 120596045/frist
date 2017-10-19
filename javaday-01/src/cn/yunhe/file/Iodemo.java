package cn.yunhe.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Iodemo {

	public static void main(String[] args) throws IOException {
		
		/*Input();*/
		/*Output();*/
		InOutput();
	}
	
	public static void Input() throws IOException{
		File file = new File("io.txt");
		if(!file.exists()){
			file.createNewFile();
		}
	  FileInputStream fis = new FileInputStream(file);
	  BufferedInputStream bis = new BufferedInputStream(fis);
	  
       byte[] buff = new byte[1024];
        int len =0;
       while((len=bis.read(buff))!=-1){
    	   /*System.out.println( buff);*/
    	   System.out.println( new String(buff,0,len));
       }
       bis.close();
       fis.close();
   }
	public static void Output() throws IOException{
		File file = new File("io.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file,true);
		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		 
		bos.write("name".getBytes());
		bos.close();
		fos.close();
	}
	
	public static void InOutput() throws IOException{
		File file = new File("io.txt");
		if(!file.exists()){
			file.createNewFile();
		 }
		 FileInputStream fis = new FileInputStream(file);
		 BufferedInputStream bis = new BufferedInputStream(fis);
		 File file2 = new File("ios.txt");
			if(!file2.exists()){
				file2.createNewFile();
			 }
		 
		 FileOutputStream fos = new FileOutputStream(file2);
		 BufferedOutputStream bos = new BufferedOutputStream(fos);
		 
		 byte[] buff =new byte[1024];
		 int len=0;
		 while((len=bis.read(buff))!=-1){
			//new String(buff,0,len);
			 bos.write(buff);
			 System.out.println("–¥»Î≥…π¶");
		 }
		 bos.close();
		 bis.close();
		 fos.close();
		 fis.close();
	}   
}