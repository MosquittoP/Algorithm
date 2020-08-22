import java.util.Scanner;

class SWEA_4012 { // SWEA 4012 요리사
	static int n, min, mid, sum;
	static int[][] map;
	static int[] num, half1, half2, two;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			}
			mid = n / 2;
			v = new boolean[n];
			half1 = new int[mid];
			half2 = new int[mid];
			min = Integer.MAX_VALUE;
			solve(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	static void solve(int idx, int start) {
		if (idx == mid) {
			sum = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (!v[i])
					half2[cnt++] = i;
			}
			two = new int[2];
			insolve(0, 0, half1);
			int a = sum;
			sum = 0;
			insolve(0, 0, half2);
			int b = sum;
			int div = Math.abs(a - b);
			if (min > div)
				min = div;
			return;
		}
		for (int i = start; i < n; i++) {
			half1[idx] = i;
			v[i] = true;
			solve(idx + 1, i + 1);
			v[i] = false;
		}
	}
	static void insolve(int idx, int start, int[] num) {
		if (idx == 2) {
			sum += map[two[0]][two[1]] + map[two[1]][two[0]];
			return;
		}
		for (int i = start; i < mid; i++) {
			two[idx] = num[i];
			insolve(idx + 1, i + 1, num);
		}
	}
}
