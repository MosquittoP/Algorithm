import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
  
class SWEA_7793 {
    static int min, n, m;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Data> q1;
    static Queue<Data> q2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            min = Integer.MAX_VALUE;
            n = sc.nextInt();
            m = sc.nextInt();
            map = new char[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = sc.next().toCharArray();
            }
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'S')
                        q2.offer(new Data(i, j, 0));
                    if (map[i][j] == '*')
                        q1.offer(new Data(i, j, 0));
                }
            }
            while(true) {
                if (q2.size() == 0) {
                    System.out.println("#" + test_case + " GAME OVER");
                    break;
                }
                bfs1();
                int result = bfs2();
                if (result != -1) {
                    System.out.println("#" + test_case + " " + result);
                    break;
                }
            }
        }
    }
    static void bfs1() {
        int nx;
        int ny;
        int size = q1.size();
        while (size-- > 0) {
            Data data = q1.poll();
            for (int i = 0; i < 4; i++) {
                ny = data.y + dy[i];
                nx = data.x + dx[i];
                if (isIn(ny, nx)) {
                    if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
                        map[ny][nx] = '*';
                        q1.offer(new Data(ny, nx, data.cnt + 1));
                    }
                }
            }
        }
    }
    static int bfs2() {
        int nx;
        int ny;
        int size = q2.size();
        while (size-- > 0) {
            Data data = q2.poll();
            for (int i = 0; i < 4; i++) {
                ny = data.y + dy[i];
                nx = data.x + dx[i];
                if (isIn(ny, nx)) {
                    if (map[ny][nx] == 'D')
                        return data.cnt + 1;
                    else if (map[ny][nx] == '.') {
                        map[ny][nx] = 'S';
                        q2.offer(new Data(ny, nx, data.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isIn(int y, int x) {
        return 0 <= y && 0 <= x && y < n && x < m;
    }
    static class Data {
        int x, y, cnt;
        public Data(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
