import java.util.Scanner;

public class BOJ_17070 { // 백준 17070 파이프 옮기기 1
	static int n, m, cnt;
	static int[][] map;
	static int[] dy = {0, 1, 1};
	static int[] dx = {1, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		}
		m = 0;
		cnt = 0;
		dfs(m, 0, 1);
		System.out.println(cnt);
	}
	static void dfs(int m, int y, int x) {
		if (y > n - 1 || x > n - 1 || map[y][x] == 1)
			return;
		if (y == n - 1 && x == n - 1) {
			cnt++;
			return;
		}
		int ny, nx;
		if (m == 0) {
			for (int i = 0; i < 2; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (i == 1) {
					if (ny > n - 1 || nx > n - 1 || map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1)
						continue;
				}
				dfs(i, ny, nx);
			}
		}
		else if (m == 1) {
			for (int i = 0; i < 3; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (i == 1) {
					if (ny > n - 1 || nx > n - 1 || map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1)
						continue;
				}
				dfs(i, ny, nx);
			}
		}
		else {
			for (int i = 1; i < 3; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (i == 1) {
					if (ny > n - 1 || nx > n - 1 || map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1)
						continue;
				}
				dfs(i, ny, nx);
			}
		}
	}
}