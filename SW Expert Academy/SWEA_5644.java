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

class SWEA_5644 { // SWEA 5644 무선충전
	static int[] a;
	static int[] b;
	static int n, m, max, ax, ay, bx, by;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	static BC[] bcmap;
	static LinkedList<BC> listA = new LinkedList<BC>();
	static LinkedList<BC> listB = new LinkedList<BC>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			m = sc.nextInt();
			n = sc.nextInt();
			a = new int[m];
			b = new int[m];
			bcmap = new BC[n];
			for (int i = 0; i < m; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < m; i++)
				b[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				bcmap[i] = new BC(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
			max = 0;
			ax = ay = 1;
			bx = by = 10;
			for (int i = 0; i < m; i++) {
				max += calc();
				ay += dy[a[i]];
				ax += dx[a[i]];
				by += dy[b[i]];
				bx += dx[b[i]];
			}
			max += calc();
			System.out.println("#" + t + " " + max);
		}
	}
	private static int calc() {
		listA.clear();
		listB.clear();
		for (BC bc : bcmap) {
			if (isRange(ay, ax, bc))
				listA.add(bc);
			if (isRange(by, bx, bc))
				listB.add(bc);
		}
		int val = 0;
		int sizeA = listA.size();
		int sizeB = listB.size();
		if (sizeB == 0) {
			for (BC bc : listA)
				val = Math.max(val, bc.p);
		}
		else if (sizeA == 0) {
			for (BC bc : listB)
				val = Math.max(val, bc.p);
		}
		else if (sizeA > 0 && sizeB > 0) {
			for (BC bc1 : listA) {
				for (BC bc2 : listB) {
					if (bc1.idx == bc2.idx)
						val = Math.max(val, bc1.p);
					else
						val = Math.max(val, bc1.p + bc2.p);
				}
			}
		}
		return val;
	}
	private static boolean isRange(int y, int x, BC bc) {
		int d = Math.abs(x - bc.x) + Math.abs(y - bc.y);
		return d <= bc.c ? true : false;
	}
	static class BC {
		int x, y, c, p, idx;
		public BC(int x, int y, int c, int p, int idx) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.idx = idx;
		}
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + ", idx=" + idx + "]";
		}
	}
}
