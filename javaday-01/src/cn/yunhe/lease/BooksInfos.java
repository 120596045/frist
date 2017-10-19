package cn.yunhe.lease;

/**
 * 图书信息
 */
public class BooksInfos {
   
	int id;//图书编号
	String name;//姓名
	String loanDate;//借书时间	
    String backDate;//还书时间
    int count;     // 借书次数 
    boolean state; //借书状态，false为未借出，true 为借出状态
    
    public BooksInfos(){}
    /*构造方法重载*/
	public BooksInfos(int id, String name, String loanDate, String backDate, int count, boolean state) {
		this.id = id;
		this.name = name;
		this.loanDate = loanDate;
		this.backDate = backDate;
		this.count = count;
		this.state = state;
	}
    
    
}
