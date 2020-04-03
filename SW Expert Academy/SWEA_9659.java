import java.util.Scanner;

class SWEA_9659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			long[] dp;
			int[][] t = new int[n + 1][3];
			for (int i = 2; i < t.length; i++) {
				for (int j = 0; j < 3; j++) {
					t[i][j] = sc.nextInt();
				}
			}
			int m = sc.nextInt();
			long[] x = new long[m];
			for (int i = 0; i < m; i++) {
				dp = new long[n + 1];
				dp[0] = 1;
				dp[1] = sc.nextInt();
				for (int j = 2; j < t.length; j++) {
					switch(t[j][0]) {
					case 1:
						dp[j] = (dp[t[j][1]] + dp[t[j][2]]) % 998244353;
						break;
					case 2:
						dp[j] = (t[j][1] * dp[t[j][2]]) % 998244353;
						break;
					case 3:
						dp[j] = (dp[t[j][1]] * dp[t[j][2]]) % 998244353;
						break;
					}
				}
				x[i] = dp[n] % 998244353;
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < m; i++) {
				System.out.print(x[i] + " ");
			}
			System.out.println();
		}
	}
}
