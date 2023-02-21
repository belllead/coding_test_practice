package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumCard2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken()); 
		} 
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<M; i++) {
			if (arr2[i] > arr[N-1] || arr2[i] < arr[0]) {
				sb.append(0 + " ");
				continue;
			} else {
				boolean flag = true;
				int cnt = 0;
				int idx = 0;
				
				while (idx < N && arr2[i] >= arr[idx]) {
					if (arr2[i] == arr[idx]) {
						cnt++;
						flag = false;
					}
					idx++;
				}
				
				if (flag)
					sb.append(0 + " ");
				else
					sb.append(cnt + " ");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
