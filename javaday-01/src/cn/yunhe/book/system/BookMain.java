package cn.yunhe.book.system;

import java.util.Scanner;

public class BookMain {
	 
       /**
        * ͼ��ϵͳ�˵����
        */
	public static void main(String[] args) {
	    System.out.println("��ӭ����XXX��������");
	    BookManege bmanege=new BookManege();
	     bmanege.init();
	     bmanege.menu();

	}

}
