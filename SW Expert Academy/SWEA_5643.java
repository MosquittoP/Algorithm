import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Stack;

class SWEA_5643 {
	static int[][] map;
	static int n, m, result, cnt;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n + 1][m + 1];
			for (int[] arr : map)
				Arrays.fill(arr, Integer.MAX_VALUE);
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					for (int k = 1; k < n + 1; k++) {
						if (map[j][k] > map[j][i] + map[i][k])
							map[j][k] = map[j][i] + map[i][k];
					}
				}
			}
			int[] cnt = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (map[i][j] != Integer.MAX_VALUE) {
						cnt[i]++;
						cnt[j]++;
					}
				}
			}
			result = 0;
			for (int i = 1; i < n + 1; i++) {
				if (cnt[i] == n - 1)
					result++;
			}
//			for (int i = 1; i < n + 1; i++) {
//				cnt = 0;
//				v = new boolean[n + 1];
//				dfs1(i);
//				v = new boolean[n + 1];
//				dfs2(i);
//				if (cnt == n - 1)
//					result++;
//			}
			System.out.println("#" + t + " " + result);
		}
	}
	static void dfs1(int idx) {
		v[idx] = true;
		for (int i = 1; i < n + 1; i++) {
			if (v[i])
				continue;
			if (map[idx][i] == 0)
				continue;
			cnt++;
			dfs1(i);
		}
	}
	static void dfs2(int idx) {
		v[idx] = true;
		for (int i = 1; i < n + 1; i++) {
			if (v[i])
				continue;
			if (map[i][idx] == 0)
				continue;
			cnt++;
			dfs2(i);
		}
	}
}
