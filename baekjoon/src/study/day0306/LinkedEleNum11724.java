package study.day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedEleNum11724 {

	// 인접리스트 만들기를 위한 연결 리스트 노드 클래스
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}
	
	static int N, M; 
	static StringTokenizer st;
	static BufferedReader br;
	static Node[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		visited = new boolean[N+1];
		
		// 인접리스트 만들기
		makeAdjList();		
		
		// 방문하지 않은 정점에 한해 dfs 실행
		int ans = 0;
		for (int i=1; i<N+1; i++) {
			if (!visited[i]) {
				findCC(i);
				ans++;
			}			
		}
		
		System.out.println(ans);		
	}
	
	static void makeAdjList() throws IOException {
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
			
		}
		
//		for (Node n : adjList) {
//			System.out.println(n);
//		}
	}
	
	static void findCC(int vertex) {
		visited[vertex] = true;
		
		for (Node temp = adjList[vertex]; temp != null; temp = temp.next) {
			if (!visited[temp.vertex]) {
				findCC(temp.vertex);
			}
		}
	}
}





















