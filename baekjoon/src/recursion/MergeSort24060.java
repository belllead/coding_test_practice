package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort24060 {
	static List<Integer> save = new ArrayList<>();
	static int saveCnt = 1, K, ans = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		int[] A = new int[N];
		
		for (int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		mergeSort(A, 0, N-1);
		
//		System.out.println(save.toString());
//		System.out.println(Arrays.toString(A));
		
		if (ans == -1)
			System.out.println(-1);
		else
			System.out.println(ans);
//		System.out.println(saveCnt);
//		if (save.size() < K)
//			System.out.println(-1);
//		else
//			System.out.println(save.get(K-1));
	}
	

	static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		int[] temp = new int[A.length]; 
		
		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				
				save.add(A[i]);
				if (saveCnt == K) {
					ans = A[i];
					saveCnt++;
				} else saveCnt++;				
				
				temp[t++] = A[i++];
			} else {
				
				save.add(A[j]);
				if (saveCnt == K) {
					ans = A[j];
					saveCnt++;
				} else saveCnt++;	
				
				temp[t++] = A[j++];
			}
				
		}
		
		while (i <= q) {
			
			save.add(A[i]);
			if (saveCnt == K) {
				ans = A[i];
				saveCnt++;
			} else saveCnt++;	

			temp[t++] = A[i++];			
		}			

		while (j <= r) {
			
			save.add(A[j]);
			if (saveCnt == K) {
				ans = A[j];
				saveCnt++;
			} else saveCnt++;	
			
			temp[t++] = A[j++];			
		}			
		
		i = p;
		t = 0;
		
		while (i <= r) 
			A[i++] = temp[t++];
	}
}
