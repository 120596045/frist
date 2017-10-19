package cn.yunhe.list;
public class Change {
	 public static void main(String[] args){
	  int [] array={1,2,3,4,5,6};
	  for(int i=0;i<array.length;i++)
	     {
                   		  
		  if(i<(array.length-1)/2){
			  int a=0;  
		      a=array[i];
		      array[i]=array[array.length-1-i];
		      array[array.length-1-i]=a;
		  }
		     System.out.println(array[i]);
	      }
	        int a=0;
	        int b=0;
	  for(int i=0;i<array.length;i++){
		    
		  if(array[i]>a){
			  a=array[i];
			}else{
			  b=array[i];
			}
		  
	  }
	  System.out.println(a);
	  System.out.println(b); 
	  
	  int c=3;
	  for(int i=0;i<array.length;i++){
		  if(array[i]==3){
			  System.out.println(i);
			  return;
		  }
	  }
    }
	 
}