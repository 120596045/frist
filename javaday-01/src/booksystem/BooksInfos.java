package booksystem;
/**
 * ͼ����Ϣ
 */
public class BooksInfos {
	private int id;//ͼ����
	private String name;//����
	private String loanDate;//����ʱ��	
	private String backDate;//����ʱ��
	private int count;     // ������� 
	private boolean state; //����״̬��falseΪδ�����true Ϊ���״̬
   
    public BooksInfos(){}
    /*���췽������*/
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
