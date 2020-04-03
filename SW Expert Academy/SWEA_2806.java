import java.util.Scanner;
  
class SWEA_2806 {
    static int[] map;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            map = new int[n];
            cnt = 0;
            dfs(0);
            System.out.println("#" + test_case + " " + cnt);
        }
    }
    static void dfs(int lev) {
        if (lev == map.length) {
            cnt++;
            return;
        }
        for (int i = 0; i < map.length; i++) {
            map[lev] = i;
            if (isPromming(lev, i))
                dfs(lev + 1);
            map[lev] = 0;
        }
    }
    static boolean isPromming(int lev, int c) {
        for (int i = 0; i < lev; i++) {
            if (map[i] == map[lev])
                return false;
            if (Math.abs(lev - i) == Math.abs(map[lev] - map[i]))
                return false;
        }
        return true;
    }
}
