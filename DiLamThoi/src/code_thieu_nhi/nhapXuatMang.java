package code_thieu_nhi;

import java.util.Scanner;

public class nhapXuatMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mang();
       
	}
	static void mang() {
		 Scanner nhap = new Scanner(System.in);
		 	 System.out.println(" nhap phan tu mang: ");
		 int n = nhap.nextInt();
		 int[] arr= new int[n];
	
		 for(int i=0;i<arr.length;i++) {
			 System.out.printf("a[%d]",+i);
			 arr[i] = nhap.nextInt();
		 }
		 show(arr);
		 sapxep(arr);
		 solonsobe(arr);
	}
	static void show(int[] arr) {
		System.out.println("cac phan tu cua mang:");
		for (int i=0;i<arr.length;i++) {
			System.out.println(""+arr[i]);
		}
	}
	static void sapxep(int[] arr) {
		System.out.println(" mang sau khi sap xep :");
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j = i +1 ; j <arr.length; j ++) {
				if(arr[j]<arr[i]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				
				}
			}
		}
		for(int i = 0; i<arr.length;i++) {
			System.out.printf("%d", +arr[i]);
		}
	}
	static void solonsobe(int[] arr) {
		System.out.println(" mang sau khi sap xep :");
		int temp=0;
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<arr.length;i++) {
		 if(arr[i]>max) {
			 max =arr[i];
		 }
		 else if(arr[i]<min) {
			 min = arr[i];
		 }
			}
		System.out.println("so lon nhat la:"+max);
		System.out.println("so nho nhat la:"+min);
	}
}
