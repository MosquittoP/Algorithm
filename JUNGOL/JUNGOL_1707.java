import java.util.Scanner;
  
public class JUNGOL_1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int y = 0;
        int x = 0;
        int num = 1;
        while (num <= n * n) {
            while (x < n && a[y][x] == 0)
                a[y][x++] = num++;
            x--;
            y++;
            while (y < n && a[y][x] == 0)
                a[y++][x] = num++;
            y--;
            x--;
            while (x >= 0 && a[y][x] == 0)
                a[y][x--] = num++;
            x++;
            y--;
            while (y >= 0 && a[y][x] == 0)
                a[y--][x] = num++;
            y++;
            x++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
