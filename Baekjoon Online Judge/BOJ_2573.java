package BOJ;
import java.util.Scanner;

public class BOJ_2573 { // 백준 2573 빙산
	static int n, m;
	static int[][] map, div;
	static boolean[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		}
		int ny, nx;
		int cnt = 0;
		int check = 0;
		while (check < 2) {
			check = 0;
			div = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							ny = i + dy[k];
							nx = j + dx[k];
							if (map[ny][nx] == 0)
								div[i][j]++;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						map[i][j] -= div[i][j];
						if (map[i][j] < 0)
							map[i][j] = 0;
					}
				}
			}
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0 && !v[i][j]) {
						dfs(i, j);
						check++;
					}
				}
			}
			cnt++;
			if (check == 0)
				break;
		}
		System.out.println(check == 0 ? 0 : cnt);
	}
	static void dfs(int y, int x) {
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (v[ny][nx] || map[ny][nx] == 0)
				continue;
			v[ny][nx] = true;
			dfs(ny, nx);
		}
	}
}
