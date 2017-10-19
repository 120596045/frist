package booksystem;
/**
 * 图书信息
 */
public class BooksInfos {
	private int id;//图书编号
	private String name;//姓名
	private String loanDate;//借书时间	
	private String backDate;//还书时间
	private int count;     // 借书次数 
	private boolean state; //借书状态，false为未借出，true 为借出状态
   
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getBackDate() {
		return backDate;
	}

	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
    
}
