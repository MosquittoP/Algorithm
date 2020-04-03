import java.util.Scanner;
 
class SWEA_5604 {
    static long a, b, sum, arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            a = sc.nextLong();
            b = sc.nextLong();
            sum = 0;
            arr = new long[10];
            long n = 1;
            plus(a, b, n);
            for (int i = 0; i < arr.length; i++)
                sum += arr[i] * i;
            System.out.println("#" + test_case + " " + sum);
        }
    }
    static void part(long n, long x) {
        while (n > 0) {
            arr[(int)(n % 10)] += x;
            n /= 10;
        }
    }
    static void plus(long a, long b, long n) {
        if (a == 0 && b == 0)
            return;
        while (a % 10 != 0 && a <= b) {
            part(a, n);
            a++;
        }
        if (a > b)
            return;
        while (b % 10 != 9 && a <= b) {
            part(b, n);
            b--;
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] += (b / 10 - a / 10 + 1) * n;
        plus(a / 10, b / 10, n * 10);
    }
}
