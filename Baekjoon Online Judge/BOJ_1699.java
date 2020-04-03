import java.util.Scanner;

public class BOJ_1699 {
	static int[] dp = new int[100001]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (dp[i] == 0 || dp[i] > dp[i - j * j] + 1)
					dp[i] = dp[i - j * j] + 1;
			}
		}
		System.out.println(dp[n]);
	}
}
