package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 비교 기준 수 배열
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 비교 수 배열
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		// 기준 수 정렬
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<M; i++) {
			// 비교 수가 기준 배열의 최소나 최대보다 크면 스트링빌더에 0 추가하고 continue 
			if (arr2[i] > arr[N-1] || arr2[i] < arr[0]) {
				sb.append(0 + "\n");
				continue;
			// 비교 수가 기준 배열에 없다고 가정해두고 (없는 것이 true)
			// 비교 수가 기준 배열에서 같은 수를 만나면 1을 추가하고 가정은 뒤집고 (false) break
			} else {
				boolean flag = true;
				for (int j=0; j<N; j++) {
					if (arr2[i] == arr[j]) {
						sb.append(1 + "\n");
						flag = false;
						break;
					} 
				}
				// 기준 배열을 다 돌아고 비교 수가 처음 가정대로 같은 수를 만나지 못하면 0을 추가
				if (flag)
					sb.append(0 + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
}
