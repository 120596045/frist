package cn.yunhe.lease;

import java.util.Scanner;

/**
 * 
 * ͼ�����ϵͳ
 */
public class BooksManage {
	
	 Scanner scan= new Scanner(System.in);
	  //�������鳤��
	 BooksInfos[] booksArr=new BooksInfos[50];
	 /**
	  * ��һ����������ȫ�ֱ�������id���
	  */
	 int count;
	 /**
	  * ����һ��������ǣ��ж�ʹ��
	  */
	 boolean flag;
	
	   /**
	    * ϵͳ��ҳ��ѡ��˵������ݱ�Ž��в���
	    */
	 public void menu()
	 {   
		
		 System.out.println("1���鿴ͼ��"+"\n"+"2�����ͼ��"+"\n"+
	                        "3������"+"\n"+"4������"+"\n"+"5��ɾ��ͼ��"
	                        +"\n"+"6�����ͼ������"+"\n"+"0���˳�");
		 int num = scan.nextInt();
		 switch(num)
		 {
		 case 1:
			 select();
			 break;
		 case 2:
			 add();
			 break;
		 case 3:
			 loan();
			 break;
		 case 4:
			 back();
			 break;
		 case 5:
			 del();
			 break;
		 case 6:
			 order();
			 break;
		 case 0:
			 System.out.println("�˳��ɹ�,��ӭ����");
			 break;
		 }
	 }
	 /**
	  * ��ʼ��ͼ�飬��ͼ�鸳ֵ
	  */
	 public void init()
	 {
		 booksArr[0]=new BooksInfos(1,"java","","",5,false);
		 booksArr[1]=new BooksInfos(2,"html","","",7,false);
		 booksArr[2]=new BooksInfos(3,"ui","","",3,false);
		 booksArr[3]=new BooksInfos(4,"c","","",2,false);
		 booksArr[4]=new BooksInfos(5,"c++","","",4,false);
		 booksArr[5]=new BooksInfos(6,"php","","",1,false);
		 booksArr[6]=new BooksInfos(7,"h5","","",3,false);
		 System.out.println("��ӭ����XXXX���");
	 }
	 /**
	  * ��ѯ����ͼ����Ϣ
	  */
	 public void select()
	 {
	    for(int i=0;i<booksArr.length;i++)
	    {   
	    	if(booksArr[i]!=null)//�ж��������Ϊ�գ������ָ��
	    	{
	    		System.out.println(booksArr[i].id+"\t"+booksArr[i].name+"\t"+
	    				booksArr[i].loanDate+"\t"+booksArr[i].backDate+"\t"
	    				+booksArr[i].count+"\t"+booksArr[i].state);
	    	}
	    }
	    menu();	 
	 }
	 
	 /**
	  * ���ͼ��
	  */
     public void add()
     {   
    	 flag=false;//������ʼ����ֵ���ж�ͼ���Ƿ����
    	 System.out.println("������Ҫ��ӵ�����");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]==null)
    		 {
    			 count=i+1;//����Ÿ�ֵ�����Ϊ�±�+1��
    			 booksArr[i]=new BooksInfos(count,name,"","",0,false);
    			 flag=true;
    			 System.out.println("���ͼ��ɹ�");
    			 break;
    			 
    		 }else 
    		 {     
    			 if(name.equals(booksArr[i].name))/*����ͼ�������ж��Ƿ����*/
    			 {    
    				 flag=true;
    				 System.out.println("���и�ͼ�飬�޷��ٴ��Ѵ�");
    				 break;
    			 }
    		 }
    	 }
    	 if(!flag)//�ж�ͼ���Ƿ��Ѵ���
    	 {
    		 System.out.println("����ʧ�ܣ�ͼ���Ѵ����޷��ٴ����"); 
    	 }
    	 choose();
     }
     /**
      * ����鼮
      */
     public void loan()
     {     
    	 flag=false;//������ʼ��
    	 System.out.println("������Ҫ�����ͼ������");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null)
    		 {    
    			  /*����ͼ�����ֺ��鼮״̬�ж��Ƿ���ںͽ��*/
    			 if(name.equals(booksArr[i].name) && !booksArr[i].state)
    			 {
    				 booksArr[i].count++;
    				 booksArr[i].loanDate="2017.8.22";
    				 booksArr[i].state=true;
    				 System.out.println("����ɹ�");
    				 flag=true;
    				 break;
    			 }
    		 }
    	 }
    	  if(!flag)
    	  {
    		  System.out.println("ͼ����ʧ��");
    	  }
    	  choose();
     }
     /**
      * ����
      */
     public void back()
     {    
    	 flag=false;
    	 System.out.println("������Ҫ���������");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null)
    		 {
    			 if(name.equals(booksArr[i].name) && booksArr[i].state)
    			 {   				 
    				 booksArr[i].backDate="2017.8.22";
    				 booksArr[i].state=false;
    				 System.out.println("����ɹ�");
    				 flag=true;
    				 break;
    			 }
    		 }
    	 }if(!flag)
    	 {
    		 System.out.println("����ʧ��");
    	 }
    	 choose();
     }
     /**
      * ɾ���鼮
      */
     public void del(){
    	 count=0;
    	 flag=false;
    	 System.out.println("������Ҫɾ���������");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null)
    		 {    /*�ж������Ƿ�ƥ�䣬״̬�Ƿ���*/
    			 if(name.equals(booksArr[i].name) && !booksArr[i].state)
    			 {   /*ɾ�����һ��Ԫ�أ���������Խ�磬������鳤����Ҫ��1*/
    			   for(int j=i;j<booksArr.length-1;j++)
    			   {   /*�ж�ɾ���������Ķ���Ϊ�գ�ʱ���л���*/
    				   if(booksArr[j+1]!=null)
    				   {   /*ȡid,������ű��*/
    					   count=booksArr[j+1].id;
    					   booksArr[j]=booksArr[j+1];
    					   booksArr[j].id=count-1;
    					   flag=true;
    				   }else
    				   {
    					   booksArr[j]=null;
    					   flag=true;
    				   }
    			   }
    			     booksArr[booksArr.length-1]=null;
    			     System.out.println("ɾ���鼮�ɹ�");
    			     break;
    			 }
    		 } flag=false;
    	 } 
    	   if(!flag)
    	   {
    		   System.out.println("������Ҫɾ���������");
    		   
    	   }
    	 choose();
     }
     /**
      * ����鼮����
      */
     public void order()
     {    
    	 /** ����һ���µ�������и�ֵ
           *  ����ѭ������ѯ������鼮
    	   */
    	 BooksInfos[] sortArr=new BooksInfos[50];
    	 count=0;
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null && booksArr[i].count>0)
    		 {
    			 for(int j=0;j<sortArr.length;j++)
    			 {  
    			    if(sortArr[j]== null)
    				 {
   			    	 count++;
       				 sortArr[j]=booksArr[i];
       				 sortArr[j].id=count;
       				 break;
    				 }
    			 }
    		 }
    	 }
    	 /**
    	  * ʹ��ð�����򣬰�����������Ӵ���С��
    	  */
    	 for(int i=0;i<sortArr.length-1;i++)
    	 {
    		 if(sortArr[i]!=null)
    		 {
    			for(int j=0;j<sortArr.length-1-i;j++)
    			{
    				if(sortArr[j+1]!=null)
    				{
    					if(sortArr[j].count<sortArr[j+1].count)
    					{
    					   BooksInfos list=sortArr[j];
    					   sortArr[j]=sortArr[j+1];
    					   sortArr[j+1]=list;
    					   break;
    					}
    				}
    			} 
    		 }
    	 }
    	 /**
    	  * ����ѭ����ѯ����������
    	  */
    	 for(int i=0;i<sortArr.length;i++)
    	 {
    		 if(sortArr[i]!=null)
    		 {
    			 System.out.println(sortArr[i].id+"\t"+sortArr[i].name+"\t"+
    					 sortArr[i].loanDate+"\t"+sortArr[i].backDate+"\t"
 	    				+sortArr[i].count+"\t"+sortArr[i].state);
    		 }
    	 }
     }
     /**
      * ����ѡ��
      */
     public void choose()
     {   
    	 System.out.println("��ѡ��"+"\n"+"1������鼮"+"\n"+"2������"
    			            +"\n"+"3������"+"\n"+"4��ɾ���鼮"+"\n"+"5���˳�");
    	 int num=scan.nextInt();
    	 switch(num)
    	 {
    	 case 1:
    		 add();
    		 break;
    	 case 2:
    		 loan();
    		 break;
    	 case 3:
    		 back();
    		 break;
    	 case 4:
    		 del();
    		 break;
    	 case 5:
    		 order();
    		 break;
    	 case 6:
    		 menu();
    		 break;
    	 }
     }
  
}
