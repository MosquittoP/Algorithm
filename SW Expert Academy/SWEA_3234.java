import java.util.Scanner;

class SWEA_3234 { // SWEA 3234 준환이의 양팔저울
	static int n, cnt, sum;
	static int[] arr, num;
	static boolean[] v, check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			v = new boolean[n];
			num = new int[n];
			cnt = 0;
			solve(0);
			System.out.println("#" + t + " " + cnt);
		}
	}
	static void solve(int x) {
		if (x == n) {
			dfs(0, 0, 0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			v[i] = true;
			num[x] = arr[i];
			solve(x + 1);
			v[i] = false;
		}
	}
	static void dfs(int idx, int left, int right) {
		if (idx == n) {
			cnt++;
			return;
		}
		sum = left + num[idx];
		dfs(idx + 1, sum, right);
		sum = right + num[idx];
		if (sum <= left)
			dfs(idx + 1, left, sum);
	}
}
