package BOJ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1197 { // 백준 1197 최소 스패닝 트리
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		ArrayList<Edge>[] list = new ArrayList[v];
		for(int i = 0; i < v; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < e; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			list[a].add(new Edge(a,b,c));
			list[b].add(new Edge(b,a,c));
		}
		boolean[] visit = new boolean[v];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		int[] p = new int[v];
		p[0] = -1;
		int[] d = new int[v];
		visit[0] = true;
		queue.addAll(list[0]);
		int cnt = 0;
		int res = 0;
		while(cnt != v - 1) {
			Edge edge = queue.poll();
			if(visit[edge.dest])
				continue;
			p[edge.dest] = edge.start;
			res += edge.cost;
			queue.addAll(list[edge.dest]);
			visit[edge.dest] = true;
			cnt++;
		}
		System.out.println(res);
	}
	static class Edge implements Comparable<Edge>{
		int start;
		int dest; 
		int cost;
		Edge(int s, int d, int c){
			start = s;
			dest = d;
			cost = c;
		}
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
