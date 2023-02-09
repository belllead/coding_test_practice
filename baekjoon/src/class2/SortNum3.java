package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortNum3 {

	public static void main(String[] args) throws IOException {
		long a = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
//		int[] num = new int[N];
//		for (int i=0; i<N; i++) {
//			num[i] = Integer.parseInt(br.readLine());
//		}
//		Arrays.sort(num);
//		for (int i=0; i<N; i++) {
//			System.out.println(num[i]);
//		}
//		
		List<Integer> list = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		System.out.println(list.toString());
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		while (list.size() != 0) {
			for (int i=0; i<list.size(); i++) {
				if (min > list.get(i)) {
					min = list.get(i);
					minIndex = i;
				}
			}
			System.out.println(min);
			list.remove(minIndex);
			min = Integer.MAX_VALUE;
		}
		
		
		
		long b = System.currentTimeMillis();
		System.out.println(b - a);
	}
}
