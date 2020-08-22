import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

class SWEA_5658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String code = sc.next();
			ArrayList<String> list = new ArrayList<>();
			TreeSet<String> set = new TreeSet<>();
			for (int i = 0; i < code.length(); i++)
				list.add(Character.toString(code.charAt(i)));
			for (int i = 0; i < n / 4; i++) {
				for (int j = 0; j < 4; j++) {
					String s = "";
					for (int l = 0; l < n / 4; l++)
						s += list.get((n / 4) * j  + l);
					set.add(s);
				}
				list.add(0, list.get(list.size() - 1));
				list.remove(list.size() - 1);
			}
			Queue<Integer> pq = new LinkedList<>();
			Iterator<String> it = set.iterator();
			while(it.hasNext())
				pq.add(Integer.parseInt(it.next(), 16));
			int num = 0;
			int cnt = pq.size();
			for (int i = 0; i < cnt - k + 1; i++)
				num = pq.poll();
			System.out.println("#" + t + " " + num);
		}
	}
}