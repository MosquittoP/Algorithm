import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
class SWEA_6719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            double a = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            Double[] num = new Double[n];
            for (int i = 0; i < n; i++)
                num[i] = sc.nextDouble();
            Arrays.sort(num, Comparator.reverseOrder());
            for (int i = k - 1; i >= 0; i--)
                a = (a + num[i]) / 2;
            System.out.println("#" + test_case + " " + a);
        }
    }
}
