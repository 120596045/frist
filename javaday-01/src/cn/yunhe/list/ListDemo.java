package cn.yunhe.list;

public class ListDemo {
    public static void main(String[] args){
    	/*ListDvd ld = new ListDvd();
    	ld.DVD();*/
    	 String [][] array= new String[5][4];
    	 array[0][0]="a";
    	/* array[1][]={"a","b","c","d"};*/
    	 for(int i=0;i<5;i++){
    		 for(int j=0;j<array[i].length;j++){
    	 System.out.println(array[i][j]);
    		 }
    	 }
    }
}

 class ListDvd{
	String [] dvd ={"ս��","ս��2","ս��3","ɱ����","ɱ����2","ɱ����3"};
	   
	  public void DVD(){
		  for(int i=0;i<dvd.length;i++)
		       {
			  System.out.println(dvd[i]);
		       }
		   }
	 	  
 }		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  



