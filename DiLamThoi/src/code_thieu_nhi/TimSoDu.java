package code_thieu_nhi;

import java.util.Scanner;

public class TimSoDu {

	public static void main(String[] args) {
		
		timsodune();
	}
	static void timsodune() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("nhap so a di :");
		int a = nhap.nextInt();
		System.out.println("nhap so b di :");
		int b = nhap.nextInt();
		int du = a%b;
		System.out.println("so du cua hai so la : "+du );
	}

}
