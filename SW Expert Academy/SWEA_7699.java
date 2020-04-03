import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SWEA_7699 {
    static char map[][];
    static boolean[][] v;
    static char[] check;
    static int result;
    static int r, c;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            r = sc.nextInt();
            c = sc.nextInt();
            map = new char[r][c];
            v = new boolean[r][c];
            for (int i = 0; i < r; i++)
                map[i] = sc.next().toCharArray();
            check = new char[26];
            result = 0;
            set.clear();
            dfs(0, 0, 1);
            System.out.println("#" + test_case + " " + result);
        }
    }
    static void dfs(int y, int x, int cnt) {
        result = Math.max(result, cnt);
        v[y][x] = true;
        set.add(map[y][x]);
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r)
                continue;
            if (v[ny][nx])
                continue;
            if (set.contains(map[ny][nx]))
                continue;
            dfs(ny, nx, cnt + 1);
            v[ny][nx] = false;
            set.remove(map[ny][nx]);
        }
    }
}
