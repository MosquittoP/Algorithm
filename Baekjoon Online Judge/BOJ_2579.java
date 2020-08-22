
import java.util.Scanner;

public class BOJ_2579 { // 백준 2579 계단 오르기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] score = new int[301];
		long[] dp = new long[301];
		for (int i = 1; i < n + 1; i++)
			score[i] = sc.nextInt();
		dp[1] = score[1];
		dp[2] = Math.max(score[2], score[1] + score[2]);
		dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);
		for (int i = 4; i < n + 1; i++)
			dp[i] = Math.max((dp[i - 2] + score[i]), (dp[i - 3] + score[i - 1] + score[i]));
		System.out.println(dp[n]);
	}
}
