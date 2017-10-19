package booksystem;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

/**
 * 
 * ͼ�����ϵͳ
 */
public class BooksManege {
	BooksInfos [] bifs;
	Scanner scan= new Scanner(System.in);
	 /**
	  * ��һ����������ȫ�ֱ�������id���
	  */
	 int count;
	 /**
	  * ����һ��������ǣ��ж�ʹ��
	  */
	 boolean flag;
	/**
	 * ��ʼ���鼮
	 */
    public void init(){
    	bifs = new BooksInfos[50];
    	bifs[0] = new BooksInfos(1,"java","","",3,false);
    	bifs[1] = new BooksInfos(2,"ui","","",5,false);
    	bifs[2] = new BooksInfos(3,"php","","",8,false);
    	bifs[3] = new BooksInfos(4,"h5","","",4,false);
    	bifs[4] = new BooksInfos(5,"vr","","",1,false);
    	bifs[5] = new BooksInfos(6,"c","","",3,false);
    	bifs[6] = new BooksInfos(7,"c++","","",2,false);
    	
    }
	   /**
	    * ϵͳ��ҳ��ѡ��˵������ݱ�Ž��в���
	    */
    public void menu(){
    	 
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
	  * ��ѯ����ͼ����Ϣ
	  */
    public void select(){
    	init();
    	for(int i=0;i<bifs.length;i++){
    		if(bifs[i]!=null){
    			System.out.println(bifs[i].getId()+"\t"+bifs[i].getName()+"\t"+
    					bifs[i].getLoanDate()+"\t"+bifs[i].getBackDate()+"\t"
    					+bifs[i].getCount()+"\t"+bifs[i].getState()+"\t");
    		}
    	}
    	choose();
    }
    /**
     * ���ͼ��
     */
    public void add(){
    	 flag=false;
         count=0;
    	System.out.println("���������ͼ������");
    	String name =scan.next();
       for(int i=0;i<bifs.length;i++){
    	   count++;
    	   if(bifs[i]!=null){
    		   if(name.equals(bifs[i].getName())){
    			   System.out.println("ͼ���Ѵ����޷����");
    			   flag=true;
    		   }
    	   }else if(!flag){
    		   if(bifs[i]==null){
    			   bifs[i]=new BooksInfos(count,name,"","",0,false);
    			   System.out.println("ͼ����ӳɹ�");
    			   break;
    		   }
    	   }
       }
       choose();
    }
    /**
     * ����
     */
    public void loan(){
    	flag=false;
    	count=0;
    	System.out.println("���������ͼ������");
    	String name =scan.next();
    	for(int i=0;i<bifs.length;i++){
    		if(bifs[i]!=null){
    			if(name.equals(bifs[i].getName())&&!bifs[i].getState()){
    				count=bifs[i].getCount();
    				bifs[i].setCount(++count);
    				String loanDate ="2017.8.23";
    				bifs[i].setLoanDate(loanDate);
    				bifs[i].setState(true);
    				System.out.println("����ɹ�");
    				flag=true;
    				break;
    		   }
    		}
    	}if(!flag){
    		System.out.println("����ʧ��");
    	}
    	choose();
    }
   /**
    *  ����
    ������*/
    public void back(){
    	flag=false;
    	System.out.println("������Ҫ��ͼ������");
    	String name =scan.next();
    	for(int i=0;i<bifs.length;i++){
    		if(bifs[i]!=null){
    			if(name.equals(bifs[i].getName()) &&bifs[i].getState()){
    				String backDate ="2017.8.23";
    				bifs[i].setBackDate(backDate);
    				bifs[i].setState(false);
    				flag=true;
    				System.out.println("����ɹ�");
    				break;
    			}
    		}
    	}
    	if(!flag){
    		System.out.println("����ʧ��");
    	}
    	choose();
    }
    public void del(){
    	flag=false;
    	count=0;
    	System.out.println("������Ҫɾ���鼮����");
    	String name =scan.next();
    	for(int i=0;i<bifs.length;i++){
    		 count++;
    		if(bifs[i]!=null ){
    			if(name.equals(bifs[i].getName()) && !bifs[i].getState()){
    		      for(int j=i;j<bifs.length;j++){
    		    	  if(bifs[j+1]!=null){
    		    			int Id=bifs[i+1].getId();
    	    				bifs[i]=null;
    	    				bifs[i]=bifs[i+1];
    	    				bifs[i].setId(Id-1);
    	    				flag=true;
    	    				System.out.println("ɾ���鼮�ɹ�");
    	    				break;
    		    	  }else{
    		    		  bifs[i]=null;
    		    		  flag=true;
    		    	  }
    		      }
    		     
	    		  bifs[count]=null;
	    		  flag=true;
  				  System.out.println("ɾ���鼮�ɹ�");
  				  break;
    			}
    		}
    	}
    	if(!flag){
    		System.out.println("ɾ���鼮ʧ��");
    	}
    	
    	choose();
    }
    public void order(){
    	BooksInfos[] array = new BooksInfos[50];
    	count=0;
    	/*��������*/
    	for(int i=0;i<bifs.length;i++){
    		if(bifs[i]!=null && bifs[i].getCount()>0){
    			for(int j=0;j<array.length;j++){
    				if(array[j]==null){
    					array[j]=bifs[i];
    					array[j].setId(++count);
    					break;
    				}
    			}
    		}
    	}
    	/*����*/
    	for(int i=0;i<array.length-1;i++){
    		if(array[i]!=null){
    			for(int j=0;j<array.length-1-i;j++){
    				if(array[j+1]!=null){
    					if(array[j].getCount()<array[j+1].getCount()){
    						BooksInfos list =array[j];
    						int numId=array[j].getId();
    						int numId2=array[j+1].getId();
    						array[j]=array[j+1];
    						array[j].setId(numId);
    						array[j+1]=list;
    						array[j+1].setId(numId2);   						
    						break;
    					}
    				}
    			}
    		}
    		
    	}
    	for(int i=0;i<array.length;i++){
    		if(array[i]!=null){
    			System.out.println(array[i].getId()+"\t"+array[i].getName()+"\t"+
    					array[i].getLoanDate()+"\t"+array[i].getBackDate()+"\t"
    					+array[i].getCount()+"\t"+array[i].getState()+"\t");
    		}
    	}
    	choose();
    }
    
    /**
     * ����ѡ��
     */
    public void choose()
    {   
   	 System.out.println("��ѡ��"+"\n"+"1������鼮"+"\n"+"2������"
   			            +"\n"+"3������"+"\n"+"4��ɾ���鼮"+"\n"+"5����������"+"\n"
   			             +"6������" );
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
