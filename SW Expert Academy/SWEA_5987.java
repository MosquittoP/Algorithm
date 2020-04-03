import java.util.Scanner;
 
class SWEA_5987 {
    static int n, m, run[];
    static boolean[] v;
    static long cnt, map[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            int f, s;
            run = new int[n];
            map = new long[(1 << n)];
            for (int i = 0; i < m; i++) {
                f = sc.nextInt() - 1;
                s = sc.nextInt() - 1;
                run[f] |= (1 << s);
            }
            v = new boolean[n + 1];
            cnt = dfs(0);
            System.out.println("#" + test_case + " " + cnt);
        }
    }
    static long dfs (int num) {
        if (num == (1 << n) - 1)
            return 1;
        if (map[num] > 0)
            return map[num];
        for (int i = 0; i < n; i++) {
            if ((num & 1 << i) == 0) {
                if ((num & run[i]) == run[i])
                    map[num] += dfs(num | 1 << i);
            }
        }
        return map[num];
    }
}
