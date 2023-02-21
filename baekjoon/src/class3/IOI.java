package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IOI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int NN = 2 * N + 1;
		
		char[] pattern = new char[NN];
		
		for (int i=0; i<NN; i++) {
			if (i % 2 == 0)
				pattern[i] = 'I';
			else
				pattern[i] = 'O';
		}
		
		int M = Integer.parseInt(br.readLine());
		
		char[] arr = new char[M];
		
		String s = br.readLine();
		
		for (int i=0; i<M; i++) {
			arr[i] = s.charAt(i);
		}
		
		System.out.println(Arrays.toString(pattern));
		System.out.println(Arrays.toString(arr));
		
		int cnt = 0;
		
		for (int i=0; i<M; i++) {
			
			int idx = 0;
			
			boolean flag = false;
			
			if (arr[i] == 'I' && (i + NN) <= M) {
				while (idx < NN) {
					if (pattern[idx] == arr[idx + i]) {
						flag = true;
					} else {
						flag = false;
						break;
					}
					idx++;
				}
			}
			
			if (flag) {
				cnt++;
				System.out.println(i);
			}
			
			
		}
		
		System.out.println(cnt);
	}
}
