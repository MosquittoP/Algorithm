import java.util.Scanner;
  
public class SWEA_4615 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n + 2][n + 2];
            map[(map.length / 2) - 1][(map.length / 2)] = 1;
            map[(map.length / 2)][(map.length / 2) - 1] = 1;
            map[(map.length / 2) - 1][(map.length / 2) - 1] = 2;
            map[(map.length / 2)][(map.length / 2)] = 2;
            int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int ny;
            int nx;
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int user = sc.nextInt();
                map[y][x] = user;
                for (int j = 0; j < 8; j++) {
                    ny = y + dy[j];
                    nx = x + dx[j];
                    int count = 0;
                    if (map[ny][nx] != 0 && map[ny][nx] != user) {
                        int ay = y;
                        int ax = x;
                        while (map[ny][nx] != user && map[ny][nx] != 0) {
                            count++;
                            ny = ny + dy[j];
                            nx = nx + dx[j];
                        }
                        if (map[ny][nx] == 0)
                            continue;
                        for (int k = 0; k < count; k++) {
                            ay += dy[j];
                            ax += dx[j];
                            map[ay][ax] = user;
                        }
                    }
                }
            }
            for (int j = 1; j < map.length - 1; j++) {
                for (int k = 1; k < map.length - 1; k++) {
                    if (map[j][k] == 1)
                        count1++;
                    else if (map[j][k] == 2)
                        count2++;
                }
            }
            System.out.println("#" + test_case + " " + count1 + " " + count2);
        }
    }
}
