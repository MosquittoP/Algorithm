import java.util.Arrays;
import java.util.Scanner;
  
class SWEA_9282 {
    static int result;
    static int n, m;
    static int[][] map;
    static int[][][][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][m];
            d = new int[n + 1][m + 1][n + 1][m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    map[i][j] = sc.nextInt();
            }
            for (int[][][] d1 : d) {
                for (int[][] d2 : d1) {
                    for (int[] d3 : d2)
                        Arrays.fill(d3, Integer.MAX_VALUE);
                }
            }
            result = dfs(0, 0, n, m);
            System.out.println("#" + test_case + " " + result);
        }
    }
    static int dfs(int y, int x, int n, int m) {
        if (n == 1 && m == 1)
            return 0;
        if (d[y][x][n][m] != Integer.MAX_VALUE)
            return d[y][x][n][m];
        int sum = 0;
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + m; j++)
                sum += map[i][j];
        }
        for (int i = 1; i < n; i++) {
            int s1 = dfs(y, x, i, m);
            int s2 = dfs(y + i, x, n - i, m);
            int all = sum + s1 + s2;
            d[y][x][n][m] = Math.min(d[y][x][n][m], all);
        }
        for (int i = 1; i < m; i++) {
            int s1 = dfs(y, x, n, i);
            int s2 = dfs(y, x + i, n, m - i);
            int all = sum + s1 + s2;
            d[y][x][n][m] = Math.min(d[y][x][n][m], all);
        }
        return d[y][x][n][m];
    }
}
