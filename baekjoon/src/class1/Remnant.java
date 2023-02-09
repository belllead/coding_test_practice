package class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Remnant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
			int rem = arr[i] % 42;
			if ((!list.contains(rem))) {
				list.add(rem);
			}
		}
		System.out.println(list.size());
		sc.close();
	}
}
