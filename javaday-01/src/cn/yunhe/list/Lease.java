package cn.yunhe.list;

import java.util.Date;

public class Lease {

	public static void main(String[] args) {
		

	}

}
class Dvd{
	/**
	 * Dad名字
	 */
	String name;
	/**
	 * Dad借出时间
	 */
	Date time;
	String[][] dvdArr=new String[5][20];
	
	  /**
	   * 0为现有DVD
	   * 1为删除的DVD
	   * 2为借出的的DVD
	   * 3为归还的的DVD
	   * 4新增的DVD
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