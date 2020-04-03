import java.util.Scanner;
  
public class SWEA_2805 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("#" + test_case + " " + sc.next());
                continue;
            }
            String a = new String();
            int[][] b = new int[n][n];
            String[][] c = new String[n][n];
            for (int i = 0; i < n; i++) {
                a = sc.next();
                c[i] = a.split("");
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    b[i][j] = Integer.parseInt(c[i][j]);
            }
            int sum = 0;
            for (int i = 0; i <= n / 2; i++) {
                int count = 0;
                for (int j = 0; j < n / 2 - i; j++)
                    count++;
                for (int j = 0; j < 2 * i + 1; j++)
                    sum += b[i][j + count];
            }
            for (int i = n / 2 + 1; i < n; i++) {
                int count = 0;
                for (int j = 0; j < i - n / 2; j++)
                    count++;
                for (int j = 0; j < n - (2 * (i - n / 2)); j++)
                    sum += b[i][j + count];
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}
