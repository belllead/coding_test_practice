package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortNum3_2 {

	public static void main(String[] args) throws IOException {
		long a = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		int min = 10001;
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
			min = 10001;
		}
		
		
		
		long b = System.currentTimeMillis();
		System.out.println(b - a);
	}
}
