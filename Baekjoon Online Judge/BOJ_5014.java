
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014 { // 백준 5014 스타트링크
	static int f, s, g, u, d, min;
	static boolean[] v;
	static Queue<Data> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		min = Integer.MAX_VALUE;
		if (s == g) {
			System.out.println(0);
			return;
		}
		if ((s < g && u == 0) || (s > g && d == 0)) {
			System.out.println("use the stairs");
			return;
		}
		bfs();
		System.out.println(min == Integer.MAX_VALUE ? "use the stairs" : min);
	}
	static void bfs() {
		q = new LinkedList<>();
		v = new boolean[f + 1];
		v[s] = true;
		q.offer(new Data(s, 0));
		Data x;
		while (!q.isEmpty()) {
			x = q.poll();
			if (x.s == g) {
				min = x.cnt;
				return;
			}
			if (x.s + u <= f) {
				if (!v[x.s + u]) {
					q.offer(new Data(x.s + u, x.cnt + 1));
					v[x.s + u] = true;
				}
			}
			if (x.s - d > 0) {
				if (!v[x.s - d]) {
					q.offer(new Data(x.s - d, x.cnt + 1));
					v[x.s - d] = true;
				}
			}
		}
	}
	static class Data {
		int s, cnt;
		public Data(int s, int cnt) {
			this.s = s;
			this.cnt = cnt;
		}
		
	}
}
