package cn.yunhe.book.system;

import java.util.Scanner;

public class BookMain {
	 
       /**
        * 图书系统菜单入口
        */
	public static void main(String[] args) {
	    System.out.println("欢迎来到XXX租书网！");
	    BookManege bmanege=new BookManege();
	     bmanege.init();
	     bmanege.menu();

	}

}
