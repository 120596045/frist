package cn.yunhe.lease;

/**
 * ͼ����Ϣ
 */
public class BooksInfos {
   
	int id;//ͼ����
	String name;//����
	String loanDate;//����ʱ��	
    String backDate;//����ʱ��
    int count;     // ������� 
    boolean state; //����״̬��falseΪδ�����true Ϊ���״̬
    
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
    
    
}
