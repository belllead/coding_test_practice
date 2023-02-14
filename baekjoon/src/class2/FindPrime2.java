package class2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FindPrime2 {

	static Set<Integer> primeNum = new TreeSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] num = new int[N];
				
		primeNum.add(2);
		for (int i=M; i<=N; i++) {
			primeListMaker(i);
		}
		
		for (int i=M; i<=N; i++) {
			if (primeNum.contains(i)) 
				System.out.println(i);
		}
		
	}
	
	public static void primeListMaker(int a) {
		for (int i : primeNum) {
			if (a % i == 0) return;
		}
		primeNum.add(a);
	}
}
