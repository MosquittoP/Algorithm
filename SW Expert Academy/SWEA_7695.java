import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class SWEA_7695 {
    static long[] sum = new long[1000001];
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 1000000; i++) {
            sum[i] = (sum[i - 1] + pow(i)) % 1000000007;
        }
        for(int test_case = 1; test_case <= T; test_case++) {             
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + test_case + " " + sum[n] % 1000000007L);
        }
        br.close();
    }
    static long pow (int i) {
        long result = 1;
        long mul = i;
        while (i > 0) {
            if ((i & 1) == 1)
            result = (result * mul) % 1000000007;
            mul = (mul * mul) % 1000000007;
            i = i >> 1;
        }
        return result % 1000000007;
    }
}
