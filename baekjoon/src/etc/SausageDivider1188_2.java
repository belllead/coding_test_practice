package etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SausageDivider1188_2 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
	
		if (N % M == 0)
			System.out.println(0);
		else
			System.out.println(M-1);
		
	}
	
}