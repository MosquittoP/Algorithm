import java.util.Arrays;
import java.util.Scanner;

public class BOJ_8320 {
	static int[] a;
	static int n;
	static int[] result = new int[2];
	static int count;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		v = new boolean[2];
		count = 0;
		solve(0);
		int b = (int)Math.sqrt(n);
		System.out.println((((count - b) / 2) + b));
	}
	static void solve(int num) {
		if (num == result.length) {
			if (result[0] * result[1] <= n)
				count++;
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (v[num])
				continue;
			result[num] = a[i];
			v[num] = true;
			solve(num + 1);
			v[num] = false;
		}
	}
}
