import java.util.Scanner;
 
class SWEA_4012 {
    static int n, map[][], min;
    static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    map[i][j] = sc.nextInt();
            }
            v = new boolean[n];
            min = Integer.MAX_VALUE;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + min);
        }
    }
    static void dfs(int num, int cnt) {
        int sum1, sum2, res;
        if (cnt > n / 2 || num > n - 1) return;
        if (cnt == n / 2) {
            sum1 = 0;
            sum2 = 0;
            for (int i = 0; i < n; i++) {
                if (v[i]) {
                    for (int j = i + 1; j < n; j++) {
                        if (v[j])
                            sum1 += map[i][j] + map[j][i];
                    }
                }
                else {
                    for (int j = i + 1; j < n; j++) {
                        if (!v[j])
                            sum2 += map[i][j] + map[j][i];
                    }
                }
            }
            res = Math.abs(sum1 - sum2);
            if (min > res)
                min = res;
            return;
        }
        v[num] = true;
        dfs(num + 1, cnt + 1);
        v[num] = false;
        dfs(num + 1, cnt);
    }
}
