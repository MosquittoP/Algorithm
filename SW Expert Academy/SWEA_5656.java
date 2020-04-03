import java.util.Scanner;
  
class SWEA_5656 {
    static int n, w, h, result;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            w = sc.nextInt();
            h = sc.nextInt();
            int count = 0;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] != 0)
                        count++;
                }
            }
            result = count;
            per(n, result, map);
            System.out.println("#" + test_case + " " + result);
        }
    }
    static void per(int num, int min, int[][] map) {
        if (num == 0) {
            result = Math.min(min, result);
            return;
        }
        for (int i = 0; i < w; i++) {
            int[][] clone = clone(map);
            Data data = getData(i, clone);
            if (data == null)
                continue;
            int cnt = crash(data, clone);
            if (cnt >= min) {
                result = 0;
                return;
            }
            clean(clone);
            per(num - 1, min - cnt, clone);
        }
    }
    static int crash(Data data, int[][] map) {
        int num = 0;
        map[data.y][data.x] = 0;
        num++;
        int nx, ny;
        for (int i = 1; i < data.cnt; i++) {
            for (int j = 0; j < 4; j++) {
                ny = data.y + dy[j] * i;
                nx = data.x + dx[j] * i;
                if (isIn(ny, nx) && map[ny][nx] != 0)
                    num += crash(new Data(ny, nx, map[ny][nx]), map);
            }
        }
        return num;
    }
    static void clean(int[][] map) {
        for (int i = 0; i < w; i++) {
            for (int j = h - 1, k = h - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    int temp = map[j][i];
                    map[j][i] = 0;
                    map[k--][i] = temp;
                }
            }
        }
    }
    static boolean isIn(int y, int x) {
        return 0 <= y && 0 <= x && y < h && x < w;
    }
    static Data getData(int w, int[][] map) {
        for (int i = 0; i < h; i++) {
            if (map[i][w] != 0)
                return new Data(i, w, map[i][w]);
        }
        return null;
    }
    static int[][] clone(int[][] map) {
        int[][] temp = new int[h][w];
        for (int i = 0; i < h; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
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
