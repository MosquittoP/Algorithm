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

class SWEA_4366 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			String n2 = sc.next();
			String n3 = sc.next();
			long x = 0;
			long[] num2 = new long[n2.length()];
			long[] num3 = new long[n3.length() * 2];
			char[] set2 = n2.toCharArray();
			char[] set3 = n3.toCharArray();
			for (int i = 0; i < n3.length(); i++) {
				if (set3[i] == '0') {
					set3[i] = '1';
					num3[i * 2] = Long.parseLong(String.valueOf(set3), 3);
					set3[i] = '2';
					num3[i * 2 + 1] = Long.parseLong(String.valueOf(set3), 3);
					set3[i] = '0';
				}
				else if (set3[i] == '1') {
					set3[i] = '0';
					num3[i * 2] = Long.parseLong(String.valueOf(set3), 3);
					set3[i] = '2';
					num3[i * 2 + 1] = Long.parseLong(String.valueOf(set3), 3);
					set3[i] = '1';
				}
				else {
					set3[i] = '0';
					num3[i * 2] = Long.parseLong(String.valueOf(set3), 3);
					set3[i] = '1';
					num3[i * 2 + 1] = Long.parseLong(String.valueOf(set3), 3);
					set3[i] = '2';
				}
			}
			long nnum;
			for (int i = 0; i < n2.length(); i++) {
				set2[i] = set2[i] == '0' ? '1' : '0';
				nnum = Long.parseLong(String.valueOf(set2), 2);
				for (int j = 0 ; j < num3.length; j++) {
					if (nnum == num3[j]) {
						x = nnum;
						break;
					}
				}
				if (x != 0)
					break;
				set2[i] = set2[i] == '0' ? '1' : '0';
			}
			System.out.println("#" + t + " " + x);
		}
	}
}
