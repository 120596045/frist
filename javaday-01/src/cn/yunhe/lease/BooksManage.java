package cn.yunhe.lease;

import java.util.Scanner;

/**
 * 
 * 图书管理系统
 */
public class BooksManage {
	
	 Scanner scan= new Scanner(System.in);
	  //定义数组长度
	 BooksInfos[] booksArr=new BooksInfos[50];
	 /**
	  * 给一个整数类型全局变量代表id序号
	  */
	 int count;
	 /**
	  * 增加一个变量标记，判断使用
	  */
	 boolean flag;
	
	   /**
	    * 系统首页，选项菜单，根据编号进行操作
	    */
	 public void menu()
	 {   
		
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
	  * 初始化图书，给图书赋值
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
		 System.out.println("欢迎光临XXXX书店");
	 }
	 /**
	  * 查询所有图书信息
	  */
	 public void select()
	 {
	    for(int i=0;i<booksArr.length;i++)
	    {   
	    	if(booksArr[i]!=null)//判断数组对象不为空，避免空指针
	    	{
	    		System.out.println(booksArr[i].id+"\t"+booksArr[i].name+"\t"+
	    				booksArr[i].loanDate+"\t"+booksArr[i].backDate+"\t"
	    				+booksArr[i].count+"\t"+booksArr[i].state);
	    	}
	    }
	    menu();	 
	 }
	 
	 /**
	  * 添加图书
	  */
     public void add()
     {   
    	 flag=false;//变量初始化赋值，判断图书是否存满
    	 System.out.println("请输入要添加的书名");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]==null)
    		 {
    			 count=i+1;//给序号赋值，序号为下标+1；
    			 booksArr[i]=new BooksInfos(count,name,"","",0,false);
    			 flag=true;
    			 System.out.println("添加图书成功");
    			 break;
    			 
    		 }else 
    		 {     
    			 if(name.equals(booksArr[i].name))/*根据图书名字判断是否存在*/
    			 {    
    				 flag=true;
    				 System.out.println("已有该图书，无法再次已存");
    				 break;
    			 }
    		 }
    	 }
    	 if(!flag)//判断图书是否已存满
    	 {
    		 System.out.println("存入失败，图书已存满无法再次添加"); 
    	 }
    	 choose();
     }
     /**
      * 借出书籍
      */
     public void loan()
     {     
    	 flag=false;//变量初始化
    	 System.out.println("请输入要借出的图书名字");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null)
    		 {    
    			  /*根据图书名字和书籍状态判断是否存在和借出*/
    			 if(name.equals(booksArr[i].name) && !booksArr[i].state)
    			 {
    				 booksArr[i].count++;
    				 booksArr[i].loanDate="2017.8.22";
    				 booksArr[i].state=true;
    				 System.out.println("借书成功");
    				 flag=true;
    				 break;
    			 }
    		 }
    	 }
    	  if(!flag)
    	  {
    		  System.out.println("图书借出失败");
    	  }
    	  choose();
     }
     /**
      * 还书
      */
     public void back()
     {    
    	 flag=false;
    	 System.out.println("请输入要还书的名字");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null)
    		 {
    			 if(name.equals(booksArr[i].name) && booksArr[i].state)
    			 {   				 
    				 booksArr[i].backDate="2017.8.22";
    				 booksArr[i].state=false;
    				 System.out.println("还书成功");
    				 flag=true;
    				 break;
    			 }
    		 }
    	 }if(!flag)
    	 {
    		 System.out.println("还书失败");
    	 }
    	 choose();
     }
     /**
      * 删除书籍
      */
     public void del(){
    	 count=0;
    	 flag=false;
    	 System.out.println("请输入要删除书的名字");
    	 String name=scan.next();
    	 for(int i=0;i<booksArr.length;i++)
    	 {
    		 if(booksArr[i]!=null)
    		 {    /*判断名字是否匹配，状态是否借出*/
    			 if(name.equals(booksArr[i].name) && !booksArr[i].state)
    			 {   /*删除最后一个元素，避免数组越界，因此数组长度需要减1*/
    			   for(int j=i;j<booksArr.length-1;j++)
    			   {   /*判断删除对象后面的对象不为空，时进行互换*/
    				   if(booksArr[j+1]!=null)
    				   {   /*取id,进行序号变更*/
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
    			     System.out.println("删除书籍成功");
    			     break;
    			 }
    		 } flag=false;
    	 } 
    	   if(!flag)
    	   {
    		   System.out.println("请输入要删除书的名字");
    		   
    	   }
    	 choose();
     }
     /**
      * 借出书籍排序
      */
     public void order()
     {    
    	 /** 建立一个新的数组进行赋值
           *  便利循环，查询借出的书籍
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
    	  * 使用冒泡排序，按借书次数，从大往小排
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
    	  * 便利循环查询排序后的数组
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
      * 二次选择
      */
     public void choose()
     {   
    	 System.out.println("请选择："+"\n"+"1、添加书籍"+"\n"+"2、借书"
    			            +"\n"+"3、还书"+"\n"+"4、删除书籍"+"\n"+"5、退出");
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
