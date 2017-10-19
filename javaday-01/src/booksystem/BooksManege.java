package booksystem;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

/**
 * 
 * 图书管理系统
 */
public class BooksManege {
	BooksInfos [] bifs;
	Scanner scan= new Scanner(System.in);
	 /**
	  * 给一个整数类型全局变量代表id序号
	  */
	 int count;
	 /**
	  * 增加一个变量标记，判断使用
	  */
	 boolean flag;
	/**
	 * 初始化书籍
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
	    * 系统首页，选项菜单，根据编号进行操作
	    */
    public void menu(){
    	 
    	 System.out.println("1、查看图书"+"\n"+"2、添加图书"+"\n"+
                 "3、借书"+"\n"+"4、还书"+"\n"+"5、删除图书"
                 +"\n"+"6、借出图书排序"+"\n"+"0、退出");
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
			 System.out.println("退出成功,欢迎光临");
			 break;
		 }
    }
    /**
	  * 查询所有图书信息
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
     * 添加图书
     */
    public void add(){
    	 flag=false;
         count=0;
    	System.out.println("请输入添加图书名字");
    	String name =scan.next();
       for(int i=0;i<bifs.length;i++){
    	   count++;
    	   if(bifs[i]!=null){
    		   if(name.equals(bifs[i].getName())){
    			   System.out.println("图书已存在无法添加");
    			   flag=true;
    		   }
    	   }else if(!flag){
    		   if(bifs[i]==null){
    			   bifs[i]=new BooksInfos(count,name,"","",0,false);
    			   System.out.println("图书添加成功");
    			   break;
    		   }
    	   }
       }
       choose();
    }
    /**
     * 借书
     */
    public void loan(){
    	flag=false;
    	count=0;
    	System.out.println("请输入借阅图书名字");
    	String name =scan.next();
    	for(int i=0;i<bifs.length;i++){
    		if(bifs[i]!=null){
    			if(name.equals(bifs[i].getName())&&!bifs[i].getState()){
    				count=bifs[i].getCount();
    				bifs[i].setCount(++count);
    				String loanDate ="2017.8.23";
    				bifs[i].setLoanDate(loanDate);
    				bifs[i].setState(true);
    				System.out.println("借书成功");
    				flag=true;
    				break;
    		   }
    		}
    	}if(!flag){
    		System.out.println("借书失败");
    	}
    	choose();
    }
   /**
    *  还书
    啦啦啦*/
    public void back(){
    	flag=false;
    	System.out.println("请输入要换图书名字");
    	String name =scan.next();
    	for(int i=0;i<bifs.length;i++){
    		if(bifs[i]!=null){
    			if(name.equals(bifs[i].getName()) &&bifs[i].getState()){
    				String backDate ="2017.8.23";
    				bifs[i].setBackDate(backDate);
    				bifs[i].setState(false);
    				flag=true;
    				System.out.println("还书成功");
    				break;
    			}
    		}
    	}
    	if(!flag){
    		System.out.println("还书失败");
    	}
    	choose();
    }
    public void del(){
    	flag=false;
    	count=0;
    	System.out.println("请输入要删除书籍名字");
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
    	    				System.out.println("删除书籍成功");
    	    				break;
    		    	  }else{
    		    		  bifs[i]=null;
    		    		  flag=true;
    		    	  }
    		      }
    		     
	    		  bifs[count]=null;
	    		  flag=true;
  				  System.out.println("删除书籍成功");
  				  break;
    			}
    		}
    	}
    	if(!flag){
    		System.out.println("删除书籍失败");
    	}
    	
    	choose();
    }
    public void order(){
    	BooksInfos[] array = new BooksInfos[50];
    	count=0;
    	/*建立数组*/
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
    	/*排序*/
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
     * 二次选择
     */
    public void choose()
    {   
   	 System.out.println("请选择："+"\n"+"1、添加书籍"+"\n"+"2、借书"
   			            +"\n"+"3、还书"+"\n"+"4、删除书籍"+"\n"+"5、借阅排序"+"\n"
   			             +"6、返回" );
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
