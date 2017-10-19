package cn.yunhe.book.system;

import java.util.Scanner;

public class BookManege {
	/**
	 * 键盘输入对象
	 */
	Scanner scan=new Scanner(System.in);
	  /**建立book数组，BookClass类型
	   */
	   BookClass [] bookArr;
	   int count=5;
	  
	   boolean flag=false;
	   /**初始化数组，建立50个数据，给前5个初始化赋值
	    */
       public void init(){    	  
    	   bookArr=new BookClass[50];
    	   bookArr[0]=new BookClass(1,"java","null","null",4,false);
    	   bookArr[1]=new BookClass(2,"ui","null","null",2,false);
    	   bookArr[2]=new BookClass(3,"ios","null","null",3,false);
    	   bookArr[3]=new BookClass(4,"c","null","null",1,false);
    	   bookArr[4]=new BookClass(5,"c++","null","null",0,false);
    	   
       }
     /**建立菜单索引
      */
	public void menu(){
		System.out.println("1、添加书籍");
		System.out.println("2、查看书籍");
		System.out.println("3、删除书籍");
		System.out.println("4、借出书籍");
		System.out.println("5、返回书籍");
		System.out.println("0、退出");
		System.out.println("请输入操作代码");
		 int num=scan.nextInt();
		 switch(num){
		 case 1:
		 System.out.println("请输入添加书名"); 
			String name=scan.next();
			 add(name);
			 break;
		 case 2:
			 check();
			 break;
		 case 3:
			 System.out.println("请输入删除书名"); 
		     String dname=scan.next();
	    	 delete(dname);
	    	 break;
		 case 4:
			
			 lease();
			 break;
		 case 5:
			    System.out.println("请输入添加书名"); 
				String bname=scan.next();
				back(bname);
	    		break;
		 case 0:
			System.out.println("欢迎下次光临");
			 break;
		 }
		 
	}
	
	 /**
	  * 添加新书
	  */
    public void add(String name){
    	for(int i=0;i<bookArr.length;i++){
    		if(bookArr[i]==null){
    			int num=i+1;
    			bookArr[i]=new BookClass(num,name,"null","null",0,false);
    			break;
    	       }
    	}
    	System.out.println("已添加成功");
    	choise();
    }
    /**
     * 查询书籍
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
     * 借书
     */
    public void lease(){
    	System.out.println("请输入添加书名"); 	    	
		String lname=scan.next();
		System.out.println("请输入借书时间"); 
		String loanDate=scan.next();
         for(int q=0;q<bookArr.length;q++){
        	if(bookArr[q]!=null){
        	    if(lname.equals(bookArr[q].name)&&!bookArr[q].state){
        		bookArr[q].count++;
        		bookArr[q].loanDate=loanDate;
        		bookArr[q].state=true;
        		System.out.println("借出成功");
        		flag=true;
        		break;
        	  }flag=false;
        	 }
        	if(!flag){
          	  System.out.println("借出失败");
          	   break;
          	   }
         }
           
         choise();
    }
    /**
     * 删书
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
         		   System.out.println("删除成功");
       		         break;
	
         	   }
         	 } flag=false;
          }
    	  if(!flag){
    		  System.out.println("删除不成功"); 
    	  }
    	 choise();
    }
    /**
     * 还书
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
     * 选择判断继续操作还退出
     */
    public void choise(){
    	System.out.println("1、选择继续添加书籍"); 
    	System.out.println("2、选择继续借书");
    	System.out.println("3、选择删除书名"); 
    	System.out.println("4、选择继续还书"); 
    	System.out.println("5、返回项目栏"); 
    	int number=scan.nextInt();
    	switch(number){
    	case 1:
    		System.out.println("请输入添加书名"); 
			String name=scan.next();
			 add(name);
			break;
    	case 2:
    	
			lease();
			break;
    	case 3:
    		System.out.println("请输入删除书名"); 
			String dname=scan.next();
    		delete(dname);
    		break;
    	case 4:
    		System.out.println("请输入还书书名"); 
			String bname=scan.next();
			 back(bname);
    		break;
    	
    	case 5:
    		menu();
    		break;
    	}
    	
    }
    /**
     * 按count 借书次次数进行排序
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


