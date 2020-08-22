package BOJ;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_14502 { // 백준 14502 연구소
	static int[][] map;
	static int n, m, max;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static List<Data> list;
	static boolean[][] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					list.add(new Data(i, j));
			}
		}
		max = 0;
		solve(0, 0);
		System.out.println(max);
	}
	static void solve(int go, int idx) {
		if (idx == 3) {
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!v[i][j] && map[i][j] == 2)
						dfs(i, j);
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(!v[i][j] && map[i][j] == 0)
						cnt++;
				}
			}
			if (cnt > max)
				max = cnt;
			return;
		}
		Data data;
		for (int i = go; i < list.size(); i++) {
			data = list.get(i);
			map[data.y][data.x] = 1;
			solve(i + 1, idx + 1);
			map[data.y][data.x] = 0;
		}
	}
	static void dfs(int y, int x) {
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >=m)
				continue;
			if (v[ny][nx] || map[ny][nx] != 0)
				continue;
			v[ny][nx] = true;
			dfs(ny, nx);
		}
	}
	static class Data {
		int y, x;
		public Data(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
