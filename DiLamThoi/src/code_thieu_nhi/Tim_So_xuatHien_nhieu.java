package code_thieu_nhi;

import java.util.Scanner;

import javax.sound.midi.VoiceStatus;

public class Tim_So_xuatHien_nhieu {

	public static void main(String[] args) {
		xuathiennhieulan();
		
	}
	public static void xuathiennhieulan() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("nhap vao so phan tu mang :");
		int n = nhap.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length;i++) {
			System.out.printf("nhap vao di: arr[%d] :",+i);
			arr[i]= nhap.nextInt();
		}
		showmang(arr);
		timsonhieu(arr);
	}
	public static void showmang(int[] arr) {
	   for(int i=0;i<arr.length;i++) {
		   System.out.println("cac phan tu cua mang la:"+arr[i]);
	   }
	}
	public static void timsonhieu(int[] arr) {
		int count=0;
		int so = 0 ;
		 for( int i=0;i<arr.length;i++) {
			 for(int j=i+1;j<arr.length;j++) {
				 if(arr[i]==arr[j]) {
					 so=arr[j];
					 count=count+1;
					 j++;
				 }
				
			 }		 
		 }
		 System.out.printf("so xuat hien nhieu : %d",+so);
		 System.out.printf("so lan : %d",+count);
	}
}
