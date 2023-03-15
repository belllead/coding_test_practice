package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PokemonMaster1620_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		String[] pokedex = new String[N];
		int idx = 0;
		for (int i=0; i<N; i++) {
			pokedex[idx++] = br.readLine();
		}
		
		for (int i=0; i<M; i++) {
			String s = br.readLine();
			
			try {
				int num = Integer.parseInt(s);
				sb.append(pokedex[num - 1] + "\n");
			} catch (Exception e) {
				for (int j=0; j<N; j++) {
					if (pokedex[j].equals(s)) {
						sb.append((j + 1) + "\n");
						break;
					}
				}
			}
			
		}
		
		System.out.println(sb);
	}
}
