package class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	
		String[] arr = new String[N];
		
		int maxLen = 0;
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.next();
			maxLen = Math.max(maxLen, arr[i].length());
		}
		
		int[] cntLen = new int[maxLen+1];
		
		for (int i=0; i<N; i++) {
			cntLen[arr[i].length()]++;
		}
		
		System.out.println(Arrays.toString(cntLen));
		
		
	}
}
