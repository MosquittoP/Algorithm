import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
   
class SWEA_1247 {
    static int[][] con;
    static int[][] fcon;
    static int min;
    static int[] res;
    static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            con = new int[n + 2][2];
            con[n + 1][0] = sc.nextInt();
            con[n + 1][1] = sc.nextInt();
            con[0][0] = sc.nextInt();
            con[0][1] = sc.nextInt();
            fcon = new int[n][2];
            for (int i = 0; i < fcon.length; i++) {
                for (int j = 0; j < 2; j++)
                    fcon[i][j] = sc.nextInt();
            }
            Arrays.sort(fcon, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return (o2[0] + o2[1]) - (o1[0] + o2[1]);
                }
            });
            min = 1000;
            res = new int[n];
            v = new boolean[n];
            dfs(0);
            System.out.println("#" + test_case + " " + min);
        }
    }
    static void dfs(int n) {
        if (n == fcon.length) {
            int sum = 0;
            for (int i = 1; i < n + 1; i++) { 
                con[i][0] = fcon[res[i - 1]][0];
                con[i][1] = fcon[res[i - 1]][1];
            }
            for (int i = 0; i < con.length - 1; i++)
                sum += Math.abs(con[i][0] - con[i + 1][0]) + Math.abs(con[i][1] - con[i + 1][1]);
            if (min > sum)
                min = sum;
            return;
        }
        for (int i = 0; i < fcon.length; i++) {
            if (v[i])
                continue;
            res[n] = i;
            v[i] = true;
            dfs(n + 1);
            v[i] = false;
        }
    }
}
