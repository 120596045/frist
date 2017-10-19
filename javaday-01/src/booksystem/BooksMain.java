package booksystem;

public class BooksMain {

	public static void main(String[] args) {
		  /**
	        * 图书系统菜单入口
	        */
		System.out.println("欢迎来到XXX图书网");
		BooksManege bif= new BooksManege();		
		bif.init();
		bif.menu();
	}

}
