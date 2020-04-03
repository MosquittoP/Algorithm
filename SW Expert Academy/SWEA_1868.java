import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
class SWEA_1868 {
    static char[][] map;
    static int[][] bomb;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static boolean[][] v;
    static Queue<Data> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new char[n][n];
            int count = 0;
            for (int i = 0; i < n; i++)
                map[i] = sc.next().toCharArray();
            q.clear();
            int ny, nx;
            int cnt;
            v = new boolean[n][n];
            bomb = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        bomb[i][j] = -1;
                        v[i][j] = true;
                        continue;
                    }
                    cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        ny = i + dy[k];
                        nx = j + dx[k];
                        if (ny < 0 || ny > n - 1 || nx < 0 || nx > n - 1)
                            continue;
                        if (map[ny][nx] == '*')
                            cnt++;
                    }
                    bomb[i][j] = cnt;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb[i][j] == 0 && !v[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb[i][j] > 0 && !v[i][j]) {
                        count++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
    static void bfs(int y, int x) {
        q.offer(new Data(y, x));
        int ny, nx;
        while (!q.isEmpty()) {
            Data data = q.poll();
            for (int i = 0; i < 8; i++) {
                ny = data.y + dy[i];
                nx = data.x + dx[i];
                if (ny < 0 || ny > n - 1 || nx < 0 || nx > n - 1)
                    continue;
                if (v[ny][nx])
                    continue;
                if (bomb[ny][nx] > 0)
                    v[ny][nx] = true;
                if (bomb[ny][nx] == 0) {
                    q.offer(new Data(ny, nx));
                    v[ny][nx] = true;
                }
            }
        }
    }
    static class Data {
        int y;
        int x;
        public Data(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
