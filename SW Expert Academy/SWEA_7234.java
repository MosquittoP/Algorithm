import java.util.Scanner;
import java.util.StringTokenizer;
  
public class SWEA_7234 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int[][] map = new int[n][n];
            int[] dy = {-1, 0, 1, 0};
            int[] dx = {0, 1, 0, -1};
            for (int i = 0; i < b; i++) {
                int y = sc.nextInt() - 1;
                int x = sc.nextInt() - 1;
                //map[y][x]++;
                for (int j = 0; j < 4; j++) {
                    int ny = y;
                    int nx = x;
                    for (int k = 0; k < 2; k++) {
                        ny = ny + dy[j];
                        nx = nx + dx[j];
                        if(ny < 0 || ny > n - 1 || nx < 0 || nx > n - 1) {
                            break;
                        }
                        map[ny][nx]++;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > count)
                        count = map[i][j];
                }
            }
            System.out.println("#" + test_case + " " + count);
             
        }
    }
}
