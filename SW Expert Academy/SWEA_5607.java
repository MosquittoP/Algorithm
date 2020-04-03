import java.util.Scanner;
 
class SWEA_5607 {
    static int mod = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            long fac[] = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i < n + 1; i++)
                fac[i] = fac[i - 1] * i % mod;
            long mul = pow(fac[r] * fac[n - r] % mod, mod - 2);
            System.out.println("#" + test_case + " " + fac[n] * mul % mod);
        }
    }
    static long pow(long a, int b) {
        if (b == 0) return 1;
        long res = pow(a, b / 2);
        if (b % 2 == 0)
            return res * res % mod;
        else
            return (res * res % mod) * a % mod;
    }
}