package BOJ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_6987 { // 백준 6987 월드컵
	static int[][] vs;
	static int[] one = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] two = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static boolean cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] ans = new boolean[4];
		for (int t = 0; t < 4; t++) {
			boolean check = false;
			cnt = false;
			vs = new int[6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++)
					vs[i][j] = sc.nextInt();
			}
			for (int i = 0; i < 6; i++) {
				if (vs[i][0] + vs[i][1] + vs[i][2] != 5) {
					check = true;
					break;
				}
			}
			if (check)
				continue;
			dfs(0);
			ans[t] = cnt;
		}
		for (int i = 0; i < 4; i++)
			System.out.print((ans[i] ? 1 : 0) + " ");
	}
	static void dfs(int n) {
		if (cnt)
			return;
		if (n == 15) {
			cnt = true;
			return;
		}
		if (vs[one[n]][0] > 0 && vs[two[n]][2] > 0) {
			vs[one[n]][0]--;
			vs[two[n]][2]--;
			dfs(n + 1);
			vs[one[n]][0]++;
			vs[two[n]][2]++;
		}
		if (vs[one[n]][2] > 0 && vs[two[n]][0] > 0) {
			vs[one[n]][2]--;
			vs[two[n]][0]--;
			dfs(n + 1);
			vs[one[n]][2]++;
			vs[two[n]][0]++;
		}
		if (vs[one[n]][1] > 0 && vs[two[n]][1] > 0) {
			vs[one[n]][1]--;
			vs[two[n]][1]--;
			dfs(n + 1);
			vs[one[n]][1]++;
			vs[two[n]][1]++;
		}
	}
}
