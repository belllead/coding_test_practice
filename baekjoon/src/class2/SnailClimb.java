package class2;

import java.util.Scanner;

public class SnailClimb {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
//		int climb = 0;
		int day = 0;
		
		int progress = A - B;
		
		if ((V-A) % progress == 0) {
			day = (V-A) / progress;
		} else 
			day = (V-A) / progress + 1;
		
//		for (int climb=0; climb<V-A; climb+=progress) {
//			day++;
//		}
		
//		while (true) {
//			if (climb < V) {
//				climb += A;
//				day++;
//				
//				if (climb < V) {
//					climb -= B;
//				} else break;
//			}
//		}
		
		System.out.println(day+1);
		sc.close();
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
