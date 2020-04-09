import java.util.Scanner;

public class BOJ_2798 {
	static int[] arr;
	static int[] result = new int[3];
	static boolean[] v;
	static int max;
	static int big;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		max = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		big = 0;
		v = new boolean[n];
		solve(0);
		System.out.println(big);
	}
	static void solve(int s) {
		if (s == result.length) {
			int sum = 0;
			for (int i = 0; i < s; i++)
				sum += result[i];
			if (sum <= max) {
				if (sum > big) {
					big = sum;
				}
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (v[i])
				continue;
			result[s] = arr[i];
			v[i] = true;
			solve(s + 1);
			v[i] = false;
		}
	}
}
