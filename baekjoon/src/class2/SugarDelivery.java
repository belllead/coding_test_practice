package class2;

import java.util.Scanner;

public class SugarDelivery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		
		if(N<=7) {
			switch(N) {
			case 1:
				ans = -1;
				break;
			case 2:
				ans = -1;
				break;
			case 3:
				ans = 1;
				break;
			case 4: 
				ans = -1;
				break;
			case 5:
				ans = 1;
				break;
			case 6:
				ans = 2;
				break;
			case 7:
				ans = -1;
			}
		} else {
			int a = 0;
			int b = 0;
			int c = 0;
			while(N >= 15) {
				N -= 15;
				a++;
			}
			if(N % 5 == 0) {
				b = N / 5;
				N /= 5;
			}
			if(N % 3 == 0) {
				c = N / 3;
			}
			ans = 3*a + b + c;
		}
	
		System.out.println(ans);
		sc.close();
	}
}

//if N <= 7
//	if N == 1, 2, 4, 7 -> ans = -1
//	if N == 3, 5, 6 -> ans = 1, 1, 2
//if N > 7 
//	then N = 15a + 5b + 3c
//	if N % 15 == 0
//		N = N / 15, a = N / 15
//	if N % 5 == 0
//		N = N / 5, b = N / 5
//	else c = N / 3














