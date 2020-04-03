import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
  
class SWEA_2105 {
    static int n;
    static int max;
    static int[][] map;
    static boolean[][] v;
    static int dr;
    static int dc;
    static HashSet<Integer> list = new HashSet<>();
    static int[][] di = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            max = 0;
            n = Integer.parseInt(in.readLine());
            map = new int[n][n];
            v = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dr = i;
                    dc = j;
                    list.clear();
                    for (int k = 0; k < n; k++)
                        Arrays.fill(v[k],  false);
                    dfs(i, j, 0);
                }
            }
            System.out.println("#" + test_case + " " + (max == 0 ? -1 : max));
        }
    }
    static void dfs(int r, int c, int d) {
        v[r][c] = true;
        list.add(map[r][c]);
        for (int i = d; i < 4; i++) {
            int nr = r + di[i][0];
            int nc = c + di[i][1];
            int cnt = list.size();
            if (nr == dr && nc == dc && cnt >= 4) {
                if (cnt > max) {
                    max = cnt;
                    return;
                }
            }
            if (nr > -1 && nr < n && nc > -1 && nc < n && !v[nr][nc] && !list.contains(map[nr][nc]))
                dfs(nr, nc, i);
        }
        v[r][c] = false;
        list.remove(map[r][c]);
    }
}