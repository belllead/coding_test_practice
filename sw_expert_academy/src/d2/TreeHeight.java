package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class TreeHeight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] tree = new int[N];
			int maxHeight = 0;
			
			for (int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, tree[i]);
			}
			
			int[] cnt = new int[N];
			int day = 0;
			
			ArrayList<Integer> oddHeight = new ArrayList<>();
			ArrayList<Integer> evenHeight = new ArrayList<>();
			
			for (int i=0; i<N; i++) {
				cnt[i] = maxHeight - tree[i];
				if (cnt[i] != 0 && cnt[i] % 2 == 0)
					evenHeight.add(cnt[i]);
				if (cnt[i] % 2 == 1)
					oddHeight.add(cnt[i]);
			}
			
			Collections.sort(oddHeight);
			
			boolean oddDay = true;
			
			while (oddHeight.get(0) == 1 && evenHeight.size() != 0) {
				if (oddDay) {
					oddHeight.set(0, oddHeight.get(0) - 1);
					if (oddHeight.get(0) == 0)
						oddHeight.remove(0);
					
					day++;
					
					oddDay = false;
				} else {
					evenHeight.set(0, evenHeight.get(0) - 2);
					if (evenHeight.get(0) == 0)
						evenHeight.remove(0);

					day++;
					
					oddDay = true;
				}
			}
			
			System.out.println(oddHeight.toString());
			System.out.println(evenHeight.toString());
			
			
			
			
			sb.append("#" + tc + " " + day + "\n");
		}
		System.out.println(sb);
	}
}
