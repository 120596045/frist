package cn.yunhe.list;

import java.util.Date;

public class Lease {

	public static void main(String[] args) {
		

	}

}
class Dvd{
	/**
	 * Dad����
	 */
	String name;
	/**
	 * Dad���ʱ��
	 */
	Date time;
	String[][] dvdArr=new String[5][20];
	
	  /**
	   * 0Ϊ����DVD
	   * 1Ϊɾ����DVD
	   * 2Ϊ����ĵ�DVD
	   * 3Ϊ�黹�ĵ�DVD
	   * 4������DVD
	   */
	 
	 
	public void select(){
		for(int i=0;i<dvdArr.length;i++){
			for(int j=0;j<dvdArr[i].length;j++){
				System.out.println(dvdArr[i][j]);
			}
		}
	}
	public void lease(String name,Date time,int i){
		
	}

	
}