package BOJ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11727 {// 백준 11727 2×N 타일링 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		System.out.println(dp[n] % 10007);
	}
}
