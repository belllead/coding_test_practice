package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascending {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (i == 0) {
				nums[0] = temp;
			} else { 
				if (nums[i-1] != temp)
					nums[i] = temp;
			}
		}
		
		for (int i=nums.length-1; i>=0; i--) {
			System.out.println(nums[i]);
		}
				
	}
}
