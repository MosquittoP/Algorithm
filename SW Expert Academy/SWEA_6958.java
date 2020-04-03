import java.util.Arrays;
import java.util.Scanner;
  
class SWEA_6958 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            int[] game = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += sc.nextInt();
                }
                game[i] = sum;
            }
            Arrays.sort(game);
            int max = game[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                if (game[i] != max)
                    break;
                count++;
            }
            System.out.println("#" + t + " " + count + " " + max);
        }
    }
}
