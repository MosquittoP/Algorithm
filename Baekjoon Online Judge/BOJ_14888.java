package BOJ;
import java.util.Scanner;

public class BOJ_14888 { // 백준 14888 연산자 끼워넣기
	static int[] num, cal, arr;
	static int n;
	static long max, min;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = sc.nextInt();
		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int mul = sc.nextInt();
		int div = sc.nextInt();
		cal = new int[n - 1];
		int check = 0;
		while (check < plus)
			cal[check++] = 1;
		while (check < plus + minus)
			cal[check++] = 2;
		while (check < plus + minus + mul)
			cal[check++] = 3;
		while (check < plus + minus + mul + div)
			cal[check++] = 4;
		arr = new int[n - 1];
		v = new boolean[n - 1];
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		solve(0);
		System.out.println(max);
		System.out.println(min);
	}
	static void solve(int x) {
		if (x == n - 1) {
			int sum = num[0];
			for (int i = 0; i < n - 1; i++) {
				switch(arr[i]) {
				case 1:
					sum += num[i + 1];
					break;
				case 2:
					sum -= num[i + 1];
					break;
				case 3:
					sum *= num[i + 1];
					break;
				case 4:
					sum /= num[i + 1];
					break;
				}
			}
			if (sum > max)
				max = sum;
			if (sum < min)
				min = sum;
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (v[i])
				continue;
			v[i] = true;
			arr[x] = cal[i];
			solve(x + 1);
			v[i] = false;
		}
	}
}
