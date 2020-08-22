package BOJ;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class BOJ_2468 { // 백준 2468 안전 영역
	static int[][] map;
	static int[] high;
	static boolean[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int n, cnt, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				set.add(map[i][j]);
			}
		}
		Iterator<Integer> it = set.iterator();
		high = new int[set.size()];
		int check = 0;
		while(it.hasNext())
			high[check++] = it.next();
		max = 1;
		for (int i = 0; i < high.length; i++) {
			cnt = 0;
			v = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (!v[j][k] && map[j][k] > high[i]) {
						dfs(j, k, high[i]);
						cnt++;
					}
				}
			}
			if (cnt > max)
				max = cnt;
		}
		System.out.println(max);
	}
	static void dfs(int y, int x, int high) {
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || ny > n - 1 || nx < 0 || nx > n - 1)
				continue;
			if (v[ny][nx] || map[ny][nx] <= high)
				continue;
			v[ny][nx] = true;
			dfs(ny, nx, high);
		}
	}
}
