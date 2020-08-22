import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

class SWEA_4050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			Integer[] cloth = new Integer[n];
			for (int i = 0; i < n; i++)
				cloth[i] = sc.nextInt();
			Arrays.sort(cloth, Collections.reverseOrder());
			int len = 0;
			int sum = 0;
			while (true) {
				if (len > n - 1)
					break;
				if ((len % 3) == 2) {
					len++;
					continue;
				}
				sum += cloth[len++];
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}