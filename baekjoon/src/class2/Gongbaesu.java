package class2;

import java.util.Scanner;

public class Gongbaesu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int bigger = (A > B) ? A : B;
		int smaller = (A < B) ? A : B;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i=1; i<=bigger; i++) {
			if (A % i == 0 && B % i == 0)
				max = Math.max(max, i);
		}
		
		for (int i=smaller; i<=A*B; i++) {
			if (i % A == 0 && i % B == 0)
				min = Math.min(min, i);
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}
}
