import java.util.Scanner;

public class BOJ_4963 {
	static int[][] map;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // 상하좌우
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static boolean[][] v;
	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int count = 0;
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)
					map[i][j] = sc.nextInt();
			}
			v = new boolean[map.length][map[0].length];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (v[i][j] == false && map[i][j] == 1) {
						dfs(j, i);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	static void dfs(int x, int y) {
		int nx, ny;
		for (int i = 0; i < 8; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length)
				continue;
			if (v[ny][nx])
				continue;
			if (map[ny][nx] == 0)
				continue;
			v[ny][nx] = true;
			map[ny][nx] = 0;
			dfs(nx, ny);
		}
	}
}
