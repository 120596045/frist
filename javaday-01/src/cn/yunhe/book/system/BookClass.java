package cn.yunhe.book.system;


/**
 * ͼ����
 */
public class BookClass {
	int id;
	/**
	 * ͼ������
	 */
	String name;
	/**
	 * ���ʱ��
	 */
	String loanDate;
	/**
	 * �黹ʱ��
	 */
	String backDate;
	/**
	 * �������
	 */
	int count;
	/**���״̬��
	 * trueΪ���״̬��
	 * false Ϊδû�н��
	 */
	boolean  state;
	
	
      /**
       * ���캯�����أ�����BookClass��������
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
