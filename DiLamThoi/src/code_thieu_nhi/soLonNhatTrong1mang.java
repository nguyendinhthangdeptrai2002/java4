package code_thieu_nhi;

import java.util.Scanner;

public class soLonNhatTrong1mang {

	static int solon=1;
	public static void main(String[] args) {
		solonnhat();
		
	}
	private static void solonnhat() {
		
		Scanner nhap = new Scanner(System.in);
	
		int n = nhap.nextInt();
		int[] mang= new int[n];
		for(int i=0; i<n; i++) {
			System.out.printf("a[%d] =",i);
			mang[i]= nhap.nextInt();
		}
		System.out.println("cac phan tu cua mang :");
		 show(mang);
		 System.out.println();
		solon(mang);
	}
	   public static void show(int[] mang) {
	        for (int i = 0; i < mang.length; i++) {
	            System.out.print(mang[i] + " ");
	        }
	    }
	   public static void solon(int[] mang ) {
		   for (int i=0;i<mang.length;i++)
		   {
			   if(solon<mang[i]) {
				   solon=mang[i];
			   }
		   }
		   System.out.println("solon nhat la : "+solon);
	   }
}
