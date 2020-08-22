
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2636 { // 백준 2636 치즈
	static int[][] map;
	static boolean[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int last, max, result;
	static Queue<Cheese> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		map = new int[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++)
				map[i][j] = sc.nextInt();
		}
		int cnt = 0;
		while(true) {
			int ccnt = 0;
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (map[i][j] == 1)
						ccnt++;
				}
			}
			if (ccnt == 0)
				break;
			last = ccnt;
			v = new boolean[y][x];
			bfs();
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(last);
	}
	static void bfs() {
		q = new LinkedList<>();
		int y = 0;
		int x = 0;
		q.offer(new Cheese(y, x));
		int ny, nx;
		while(!q.isEmpty()) {
			Cheese cheese = q.poll();
			y = cheese.y;
			x = cheese.x;
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny < 0 || ny > map.length - 1 || nx < 0 || nx > map[0].length - 1)
					continue;
				if (v[ny][nx] || map[ny][nx] == 1)
					continue;
				v[ny][nx] = true;
				q.offer(new Cheese(ny, nx));
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					ny = i + dy[k];
					nx = j + dx[k];
					if (v[ny][nx]) {
						map[i][j] = 0;
						break;
					}
				}
			}
		}
	}
}
class Cheese {
	int y;
	int x;
	public Cheese(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
