import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class JUNGOL_1828 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] b = new int [n][2];
        int[] a = new int [10271];
        int count = 0;
        for (int i = 0; i < n; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        Arrays.sort(b, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = b[i][0] + 270; j <= b[i][1] + 270; j++) {
                a[j] += 1;
                if (a[j] > 1) {
                    for (int k = b[i][0] + 270; k <= j; k++)
                        a[k]--;
                    break;
                }
                if (j == b[i][1] + 270)
                    count++;
            }
        }
        System.out.println(count);
    }
}
