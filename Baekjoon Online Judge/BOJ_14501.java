package BOJ;
import java.util.Scanner;

public class BOJ_14501 { // 백준 14501 퇴사
	static int[][] con;
	static int n, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		con = new int[n][2];
		for (int i = 0; i < n; i++) {
			con[i][0] = sc.nextInt();
			con[i][1] = sc.nextInt();
		}
		max = 0;
		dfs(0, 0, 0);
		System.out.println(max);
	}
	static void dfs(int x, int sum, int last) {
		if (x > n - 1) {
			if (x > n)
				sum -= last;
			if (max < sum)
				max = sum;
			return;
		}
		for (int i = x; i < n; i++) {
			dfs(i + con[i][0], sum + con[i][1], con[i][1]);
		}
	}
}
