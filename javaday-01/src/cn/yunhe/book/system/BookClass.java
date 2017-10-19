package cn.yunhe.book.system;


/**
 * 图书类
 */
public class BookClass {
	int id;
	/**
	 * 图书名字
	 */
	String name;
	/**
	 * 借出时间
	 */
	String loanDate;
	/**
	 * 归还时间
	 */
	String backDate;
	/**
	 * 借出次数
	 */
	int count;
	/**借出状态，
	 * true为借出状态，
	 * false 为未没有借出
	 */
	boolean  state;
	
	
      /**
       * 构造函数重载，建立BookClass类型数组
       */  
	
	
	public BookClass(int id,String name, String loanDate, String backDate,int count, boolean state) {
		this.id=id;
		this.name=name;
		this.loanDate=loanDate;
		this.backDate=backDate;
		this.count=count;
		this.state=state;
	}


}
