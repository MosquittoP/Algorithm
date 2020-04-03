import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class JUNGOL_1809 {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        StringTokenizer st = new StringTokenizer(sc.readLine(), " ");
        int[] a = new int[n];
        int count = 0;
        while (st.hasMoreTokens()) {
            a[count] = Integer.parseInt(st.nextToken());
            ++count;
        }
        int[] b = new int[n];
        StringBuilder sb = new StringBuilder("0 ");
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] < a[j]) {
                    b[i] = j + 1;
                    break;
                }
            }
            sb.append(b[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
