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
    	 //�ж��ļ�Ŀ¼�Ƿ����
    	 if(!file.exists()){
    		 //���������ֱ�ӷ���
    		 return;
    	 }
    	  ForDemo(file);
     }
     
     public static void ForDemo(File file){
    	 //ͨ������Ŀ¼�ļ��� ����һ���ļ���Ŀ¼����
    	   File[] fil =  file.listFiles();
    	 //����ѭ��������  ���� ��Χ
		for(File f:fil){
			//����Ǳ�׼�ļ��ʹ�ӡ
    		 if(f.isFile()){
    			System.out.println(f);
    			
    		 }else{
    			 //������Ǿ� ���±���
    			 ForDemo(f); 
    		 }
    	 }    	 
     }

  
}
