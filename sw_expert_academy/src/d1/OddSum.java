package d1;

import java.util.Scanner;

public class OddSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		
		for (int i=0; i<T; i++) {
			int sum = 0;
					
			for (int j=0; j<10; j++) {
				int num = sc.nextInt();
				if (num % 2 == 1)
					sum += num;
			}
			
			ans[i] = sum;
		}
		
		for (int i=0; i<T; i++)
			System.out.println("#" + (i+1) + " " + ans[i]);
		
	}
	
}
