package code_thieu_nhi;

import java.util.Scanner;

public class soLonNhatTrong2So {

	public static void main(String[] args) {
		soLonnhat();
	
	}
	static void soLonnhat() {
		Scanner nhap =  new Scanner(System.in);
		int a = nhap.nextInt();
		System.out.println();
		int b = nhap.nextInt();
		int lonnhat;
		if(a<b) {
			lonnhat=b;
		}
		else{
			lonnhat=a;
		}
		System.out.println("so lon nhat la :"+lonnhat);
	}
}
