import java.util.ArrayList;
import java.util.Scanner;

class SWEA_1767 { // SWEA 1767 프로세서 연결하기
	static int n, max, min, cnt;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static ArrayList<int[]> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						if ((i == 0 || i == n - 1 || j == 0 || j == n - 1))
							continue;
						list.add(new int[] {i, j});
						cnt++;
					}
				}
			}
			solve(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	static void solve(int idx, int count) {
		if (idx == cnt) {
			int res = getLen();
			if (max < count) {
				max = count;
				min = res;
			}
			else if (max == count) {
				if (res < min)
					min = res;
			}
			return;
		}
		int[] arr = list.get(idx);
		int y = arr[0];
		int x = arr[1];
		for (int i = 0; i < 4; i++) {
			if (isTrue(y, x, i)) {
				setStatus (y, x, i, 2);
				solve(idx + 1, count + 1);
				setStatus(y, x, i, 0);
			}
		}
		solve(idx + 1, count);
	}
	static boolean isTrue(int y, int x, int d) {
		while (true) {
			x += dx[d];
			y += dy[d];
			if (x < 0 || x > n - 1 || y < 0 || y > n - 1)
				break;
			if (map[y][x] >= 1)
				return false;
		}
		return true;
	}
	static void setStatus (int y, int x, int d, int s) {
		while (true) {
			x += dx[d];
			y += dy[d];
			if (x < 0 || x > n - 1 || y < 0 || y > n - 1)
				break;
			map[y][x] = s;
		}
	}
	static int getLen() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 2)
					cnt++;
			}
		}
		return cnt;
	}
}
