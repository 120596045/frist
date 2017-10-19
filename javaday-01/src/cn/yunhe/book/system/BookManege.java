package cn.yunhe.book.system;

import java.util.Scanner;

public class BookManege {
	/**
	 * �����������
	 */
	Scanner scan=new Scanner(System.in);
	  /**����book���飬BookClass����
	   */
	   BookClass [] bookArr;
	   int count=5;
	  
	   boolean flag=false;
	   /**��ʼ�����飬����50�����ݣ���ǰ5����ʼ����ֵ
	    */
       public void init(){    	  
    	   bookArr=new BookClass[50];
    	   bookArr[0]=new BookClass(1,"java","null","null",4,false);
    	   bookArr[1]=new BookClass(2,"ui","null","null",2,false);
    	   bookArr[2]=new BookClass(3,"ios","null","null",3,false);
    	   bookArr[3]=new BookClass(4,"c","null","null",1,false);
    	   bookArr[4]=new BookClass(5,"c++","null","null",0,false);
    	   
       }
     /**�����˵�����
      */
	public void menu(){
		System.out.println("1������鼮");
		System.out.println("2���鿴�鼮");
		System.out.println("3��ɾ���鼮");
		System.out.println("4������鼮");
		System.out.println("5�������鼮");
		System.out.println("0���˳�");
		System.out.println("�������������");
		 int num=scan.nextInt();
		 switch(num){
		 case 1:
		 System.out.println("�������������"); 
			String name=scan.next();
			 add(name);
			 break;
		 case 2:
			 check();
			 break;
		 case 3:
			 System.out.println("������ɾ������"); 
		     String dname=scan.next();
	    	 delete(dname);
	    	 break;
		 case 4:
			
			 lease();
			 break;
		 case 5:
			    System.out.println("�������������"); 
				String bname=scan.next();
				back(bname);
	    		break;
		 case 0:
			System.out.println("��ӭ�´ι���");
			 break;
		 }
		 
	}
	
	 /**
	  * �������
	  */
    public void add(String name){
    	for(int i=0;i<bookArr.length;i++){
    		if(bookArr[i]==null){
    			int num=i+1;
    			bookArr[i]=new BookClass(num,name,"null","null",0,false);
    			break;
    	       }
    	}
    	System.out.println("����ӳɹ�");
    	choise();
    }
    /**
     * ��ѯ�鼮
     */
    public void check(){
    	for(int i=0;i<bookArr.length;i++){
    	 if(bookArr[i]!=null){
    		 
    		 System.out.println(bookArr[i].id+"\t"+bookArr[i].name+"\t"+bookArr[i].loanDate+"\t"+bookArr[i].loanDate+"\t"+bookArr[i].count+"\t"+bookArr[i].state);
    		}
    	}
    	
    	menu();
    }
    /**
     * ����
     */
    public void lease(){
    	System.out.println("�������������"); 	    	
		String lname=scan.next();
		System.out.println("���������ʱ��"); 
		String loanDate=scan.next();
         for(int q=0;q<bookArr.length;q++){
        	if(bookArr[q]!=null){
        	    if(lname.equals(bookArr[q].name)&&!bookArr[q].state){
        		bookArr[q].count++;
        		bookArr[q].loanDate=loanDate;
        		bookArr[q].state=true;
        		System.out.println("����ɹ�");
        		flag=true;
        		break;
        	  }flag=false;
        	 }
        	if(!flag){
          	  System.out.println("���ʧ��");
          	   break;
          	   }
         }
           
         choise();
    }
    /**
     * ɾ��
     */
    public void delete(String dname){
    	for(int j=0;j<bookArr.length;j++){
         	if(bookArr[j]!=null ){
         	 if(dname.equals(bookArr[j].name)&& !bookArr[j].state){
         		  for(int i=j;i<bookArr.length-1;i++){
         			if(bookArr[i+1]!=null){
         				int temp = bookArr[i+1].id;
         				bookArr[i]=bookArr[i+1];
         				bookArr[i].id=temp-1;
            			flag=true;
         			}else{
         				bookArr[i]=null;
         				
         				flag=true;
         				
         			} 
         		  }
         		   bookArr[--count]=null;
         		   System.out.println("ɾ���ɹ�");
       		         break;
	
         	   }
         	 } flag=false;
          }
    	  if(!flag){
    		  System.out.println("ɾ�����ɹ�"); 
    	  }
    	 choise();
    }
    /**
     * ����
     */
    public void back(String bname){
    	 for(int j=0;j<bookArr.length;j++){
         	if(bookArr[j]!=null){
         	 if(bname.equals(bookArr[j].name)){
         		bookArr[j].backDate="2017.8.22";
         		bookArr[j].state=false;
         	  }
         	 }
          }
    	 choise();
    }
    
    /**
     * ѡ���жϼ����������˳�
     */
    public void choise(){
    	System.out.println("1��ѡ���������鼮"); 
    	System.out.println("2��ѡ���������");
    	System.out.println("3��ѡ��ɾ������"); 
    	System.out.println("4��ѡ���������"); 
    	System.out.println("5��������Ŀ��"); 
    	int number=scan.nextInt();
    	switch(number){
    	case 1:
    		System.out.println("�������������"); 
			String name=scan.next();
			 add(name);
			break;
    	case 2:
    	
			lease();
			break;
    	case 3:
    		System.out.println("������ɾ������"); 
			String dname=scan.next();
    		delete(dname);
    		break;
    	case 4:
    		System.out.println("�����뻹������"); 
			String bname=scan.next();
			 back(bname);
    		break;
    	
    	case 5:
    		menu();
    		break;
    	}
    	
    }
    /**
     * ��count ����δ�����������
     */  
    public void  order(){
    	
    	for(int k=0;k<bookArr.length-1;k++){
        	if(bookArr[k+1]!=null){
        		for(int m=0;m<bookArr.length-1-k;m++){
        		if(bookArr[m+1]!=null){
        			if(bookArr[m].count<bookArr[m+1].count){
        				BookClass a;
                		a = bookArr[m+1];
                		bookArr[m+1]=bookArr[m];
                		bookArr[m]=a;
        			}
                
        		}
        	}
          }
        }
    	for(int h=0;h<bookArr.length;h++){
    		if(bookArr[h]!=null){
    		  /*String d="ui";
    		System.out.println(d.equals(bookArr[h].name)&&bookArr[h].state==false);
    		System.out.println(bookArr[h].name);*/
    	   System.out.println(bookArr[h].name+"\t"+bookArr[h].loanDate+"\t"+bookArr[h].count+"\t"+bookArr[h].state);
    	   }
    	}
    }
     
  
}


