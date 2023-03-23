package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] banking = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			banking[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(banking);
//		System.out.println(Arrays.toString(banking));
		
		int sum = 0;
		int waiting = 0;
		
		for (int i=0; i<N; i++) {
			waiting += banking[i];
			sum += waiting;
		}
		
		System.out.println(sum);
	}
}
