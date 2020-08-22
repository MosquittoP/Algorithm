
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1753 { // 백준 1753 최단경로
	static class Edge {
		int v, weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine()) - 1;
		List<Edge>[] adj = new ArrayList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken()) - 1].add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}
		boolean[] check = new boolean[v];
		int[] d = new int[v];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[s] = 0;
		for (int i = 0; i < v - 1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < v; j++) {
				if (!check[j] && min > d[j]) {
					min = d[j];
					index = j;
				}
			}
			if (index == -1)
				break;
			for (Edge n : adj[index]) {
				if (!check[n.v] && d[n.v] > d[index] + n.weight) {
					d[n.v] = d[index] + n.weight;
				}
			}
			check[index] = true;
		}
		for (int i = 0; i < v; i++) {
			if (d[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}
	}
}
