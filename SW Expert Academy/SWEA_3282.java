import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


import java.util.Scanner;
import java.util.Stack;

class SWEA_3282 {
	static int[][] item;
	static int dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			dp = new int[n][k + 1];
			item = new int[n][2];
			for (int i = 0; i < n; i++) {
				item[i][0] = sc.nextInt();
				item[i][1] = sc.nextInt();
			}
			for(int[] a : dp) {
				Arrays.fill(a, -1);
			}
			System.out.println("#" + t + " " + knapsack(0, k));		
		}
	}  
	static int knapsack(int pos, int capacity) {
		if (pos == item.length)
			return 0;	     
		int ret = dp[pos][capacity];
		if (ret != -1)
			return ret;
		if (item[pos][0] <= capacity)
			ret = knapsack(pos + 1, capacity - item[pos][0]) + item[pos][1];
		ret = Math.max(ret, knapsack(pos + 1, capacity));
		return dp[pos][capacity] = ret;
	}
}