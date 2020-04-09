import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<Data> q = new LinkedList<>();
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
    	int m = sc.nextInt();
    	map = new int[m][n];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++)
    			map[i][j] = sc.nextInt();
    	}
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (map[i][j] == 1)
    				q.offer(new Data(i, j));
    		}
    	}
    	bfs();
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (map[i][j] == 0) {
    				System.out.println("-1");
    				return;
    			}
    		}
    	}
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (map[i][j] > count)
    				count = map[i][j];
    		}
    	}
    	System.out.println(count - 1);
	}
	static void bfs() {
		int nx, ny;
		Data d;
		while (!q.isEmpty()) {
			d = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = d.y + dy[i];
				nx = d.x + dx[i];
				if (ny < 0 || ny > map.length - 1 || nx < 0 || nx > map[0].length - 1)
					continue;
				if (map[ny][nx] != 0)
					continue;
				map[ny][nx] = map[d.y][d.x] + 1;
				q.offer(new Data(ny, nx));
			}
		}
	}
	static class Data {
		int y;
		int x;
		Data(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
