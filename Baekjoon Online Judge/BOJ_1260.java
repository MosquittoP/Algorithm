import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		int[][] g = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g[a][b] = 1;
			g[b][a] = 1;
		}
		boolean[] v1 = new boolean[n + 1];
		boolean[] v2 = new boolean[n + 1];
		dfs(start, g, v1);
		System.out.println();
		bfs(start, g, v2);
		
	}
	static void dfs(int idx, int[][] g, boolean[] v) {
		v[idx] = true;
		System.out.print(idx + " ");
		for (int i = 1; i < g.length; i++) {
			if (v[i])
				continue;
			if (g[idx][i] == 0)
				continue;
			dfs(i, g, v);
		}
	}
	static void bfs(int start, int[][] g, boolean[] v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		int idx;
		while (!q.isEmpty()) {
			idx = q.poll();
			System.out.print(idx + " ");
			v[idx] = true;
			for (int i = 1; i < g.length; i++) {
				if (v[i])
					continue;
				if (g[idx][i] == 0)
					continue;
				if (q.contains(i))
					continue;
				q.offer(i);
			}
		}
	}
}
