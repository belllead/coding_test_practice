package 모의_SW_역량테스트;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}};
		int[] b = a[0];
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(a[0] == b);
	}
}
