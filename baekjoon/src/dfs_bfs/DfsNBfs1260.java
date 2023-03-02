package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsNBfs1260 {

	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int N, M, V;
	static boolean[] visitedDfs;
	static boolean[] visitedBfs;
	static Node[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		visitedDfs = new boolean[N+1];
		visitedBfs = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		dfs(V);
		
	}
	
	static void dfs(int vertex) {
		visitedDfs[vertex] = true;
		System.out.print(vertex + " ");
		
		for (Node temp = adjList[vertex]; temp != null; temp = temp.next) {
			if (!visitedDfs[temp.vertex])
				dfs(temp.vertex);
		}		
	}
	
}
