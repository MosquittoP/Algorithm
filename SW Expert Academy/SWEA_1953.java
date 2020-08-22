import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SWEA_1953 { // SWEA 1953 탈주범 검거
	static int n, m, r, c, l, cnt, time;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<Data> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			l = sc.nextInt();
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					map[i][j] = sc.nextInt();
			}
			cnt = 1;
			time = 1;
			if (l == 1)
				System.out.println("#" + t + " 1");
			else {
				bfs();
				System.out.println("#" + t + " " + cnt);
			}
		}
	}
	static void bfs() {
		q = new LinkedList<>();
		v = new boolean[n][m];
		q.offer(new Data(r, c));
		v[r][c] = true;
		int y, x, ny, nx;
		Data data;
		while(!q.isEmpty() && time < l) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				data = q.poll();
				y = data.y;
				x = data.x;
				switch(map[y][x]) {
				case 1:
					for (int j = 0; j < 4; j++) {
						ny = y + dy[j];
						nx = x + dx[j];
						if (!isnull(ny, nx))
							continue;
						switch(j) {
						case 0:
							up(ny, nx);
							break;
						case 1:
							right(ny, nx);
							break;
						case 2:
							down(ny, nx);
							break;
						case 3:
							left(ny, nx);
							break;
						}
					}
					break;
				case 2:
					for (int j = 0; j < 2; j++) {
						ny = y + dy[j * 2];
						nx = x + dx[j * 2];
						if (!isnull(ny, nx))
							continue;
						if (j == 0)
							up(ny, nx);
						else
							down(ny, nx);					
					}
					break;
				case 3:
					for (int j = 0; j < 2; j++) {
						ny = y + dy[j * 2 + 1];
						nx = x + dx[j * 2 + 1];
						if (!isnull(ny, nx))
							continue;
						if (j == 0)
							right(ny, nx);
						else
							left(ny, nx);					
					}
					break;
				case 4:
					for (int j = 0; j < 2; j++) {
						ny = y + dy[j];
						nx = x + dx[j];
						if (!isnull(ny, nx))
							continue;
						if (j == 0)
							up(ny, nx);
						else
							right(ny, nx);					
					}
					break;
				case 5:
					for (int j = 1; j < 3; j++) {
						ny = y + dy[j];
						nx = x + dx[j];
						if (!isnull(ny, nx))
							continue;
						if (j == 1)
							right(ny, nx);
						else
							down(ny, nx);					
					}
					break;
				case 6:
					for (int j = 2; j < 4; j++) {
						ny = y + dy[j];
						nx = x + dx[j];
						if (!isnull(ny, nx))
							continue;
						if (j == 2)
							down(ny, nx);
						else
							left(ny, nx);					
					}
					break;
				case 7:
					for (int j = 3; j < 5; j++) {
						ny = y + dy[j % 4];
						nx = x + dx[j % 4];
						if (!isnull(ny, nx))
							continue;
						if (j == 3)
							left(ny, nx);
						else
							up(ny, nx);					
					}
					break;
				}
			}
			time++;
		}
	}
	static boolean isnull (int ny, int nx) {
		if (ny < 0 || ny > n - 1 || nx < 0 || nx > m - 1)
			return false;
		if (v[ny][nx] || map[ny][nx] == 0)
			return false;
		return true;
	}
	static void up(int ny, int nx) {
		if (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7)
			return;
		v[ny][nx] = true;
		q.offer(new Data(ny, nx));
		cnt++;
	}
	static void right(int ny, int nx) {
		if (map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5)
			return;
		v[ny][nx] = true;
		q.offer(new Data(ny, nx));
		cnt++;
	}
	static void down(int ny, int nx) {
		if (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6)
			return;
		v[ny][nx] = true;
		q.offer(new Data(ny, nx));
		cnt++;
	}
	static void left(int ny, int nx) {
		if (map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7)
			return;
		v[ny][nx] = true;
		q.offer(new Data(ny, nx));
		cnt++;
	}
	static class Data {
		int y, x;
		public Data(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
