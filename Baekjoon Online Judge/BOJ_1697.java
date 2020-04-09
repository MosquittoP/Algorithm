import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
	static int[] map;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		map = new int[100000 + 1];
		bfs(n, k);
		System.out.println(res);
	}
	static void bfs(int n, int k) {
		Queue<Data> q = new LinkedList();
		q.offer(new Data(n, 0));
		Data d;
		int idx;
		while (!q.isEmpty()) {
			d = q.poll();
			if (d.idx == k) {
				res = d.cnt;
				return;
			}
			idx = d.idx + 1;
			if (idx <= 100000 && map[idx] == 0) {
				map[idx] = 1;
				q.offer(new Data(idx, d.cnt + 1));
			}
			idx = d.idx - 1;
			if (idx >= 0 && map[idx] == 0) {
				map[idx] = 1;
				q.offer(new Data(idx, d.cnt + 1));
			}
			idx = d.idx * 2;
			if (idx <= 100000 && map[idx] == 0) {
				map[idx] = 1;
				q.offer(new Data(idx, d.cnt + 1));
			}
		}
	}
	static class Data {
		int idx;
		int cnt;
		public Data(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
