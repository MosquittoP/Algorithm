
import java.util.Scanner;

public class BOJ_14503 { // 백준 14503 로봇 청소기
	static int[][] map;
	static int n, m, cnt;
	static int[] dy = {0, 1, 0, -1, 0, 1, 0};
	static int[] dx = {-1, 0, 1, 0, -1, 0, 1};
	static boolean[][] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int y = sc.nextInt();
		int x = sc.nextInt();
		int move = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		}
		if (move == 1)
			move = 3;
		else if (move == 3)
			move = 1;
		v = new boolean[n][m];
		v[y][x] = true;
		cnt = 1;
		while(true) {
			int ny, nx;
			boolean check = false;
			for (int i = move; i < move + 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (v[ny][nx] || map[ny][nx] == 1)
					continue;
				y = ny;
				x = nx;
				cnt++;
				v[ny][nx] = true;
				move = (i + 1) % 4;
				check = true;
				break;
			}
			if (check)
				continue;
			else {
				if (map[y + dy[move + 1]][x + dx[move + 1]] == 1)
					break;
				y = y + dy[move + 1];
				x = x + dx[move + 1];
			}
		}
		System.out.println(cnt);
	}
}
