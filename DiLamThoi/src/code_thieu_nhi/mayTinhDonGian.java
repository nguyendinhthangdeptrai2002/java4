package code_thieu_nhi;

import java.util.Scanner;

public class mayTinhDonGian {

	
	public static void main(String[] args) { tinhtoan();}
	public static int tinhtoan(){
	    Scanner nhap = new Scanner(System.in);
	    
	    System.out.println("ph?p t?nh :");
	    String pheptoan = nhap.nextLine();
	   if(pheptoan.equals("+")|pheptoan.equals("-")|pheptoan.equals("*")|pheptoan.equals("/")) {
	    
	System.out.println("so thu nhat:");
	    
	     int a= nhap.nextInt();
	     
	 
	     
	     System.out.println("so thu hai :");
	    int b= nhap.nextInt(); 
	    
	    int tinh = 0 ;
	    if(pheptoan.equals("+")){
	        tinh=a+b;
	       System.out.println("haha");
	       
	    }
	     else if(pheptoan.equals("-")){
	        tinh=a-b;	       
	      
	    }
	     else if(pheptoan.equals("*")){
	        tinh=a*b;
	        	       
	    }
	     else if(pheptoan.equals("/")){
	        tinh=a/b;
	       
	       
	    }
		
	   System.out.println(" ket qua la :"+tinh);
	
	}
	else {
		System.out.println("khong co phep toan nay !");
	}
	   return tinhtoan();
	}
}


