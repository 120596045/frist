package cn.yunhe.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {


	public static void main(String[] args) throws IOException {
      		
		searchDemo();
	}
	
	public static void CreatDemo() throws IOException{
		File fil = new File("test.txt");
        fil.createNewFile();
        System.out.println(fil.canRead());
	}
	
     public static void searchDemo(){
    	 File file = new File("D:\\Documents");
    	 //判断文件目录是否存在
    	 if(!file.exists()){
    		 //如果不存在直接返回
    		 return;
    	 }
    	  ForDemo(file);
     }
     
     public static void ForDemo(File file){
    	 //通过存在目录文件夹 建立一个文件夹目录数组
    	   File[] fil =  file.listFiles();
    	 //便利循环，类型  变量 范围
		for(File f:fil){
			//如果是标准文件就打印
    		 if(f.isFile()){
    			System.out.println(f);
    			
    		 }else{
    			 //如果不是就 重新遍历
    			 ForDemo(f); 
    		 }
    	 }    	 
     }

  
}
