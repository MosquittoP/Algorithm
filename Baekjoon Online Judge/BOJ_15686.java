package BOJ;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686 { // 백준 15686 치킨 배달
	static int n, m, min;
	static int[] arr, num;
	static List<Data> house, chicken;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x;
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				x = sc.nextInt();
				if (x == 1)
					house.add(new Data(i, j));
				else if (x == 2)
					chicken.add(new Data(i, j));
			}
		}
		arr = new int[chicken.size()];
		num = new int[m];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;
		min = Integer.MAX_VALUE;
		solve(0, 0);
		System.out.println(min);
	}
	static void solve(int idx, int cnt) {
		if (idx == m) {
			Data h, c;
			int smin, now;
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				smin = Integer.MAX_VALUE;
				h = house.get(i);
				for (int j = 0; j < m; j++) {
					c = chicken.get(num[j]);
					now = Math.abs(h.y - c.y) + Math.abs(h.x - c.x);
					if (smin > now)
						smin = now;
				}
				sum += smin;
			}
			if (min > sum)
				min = sum;
			return;
		}
		for (int i = cnt; i < arr.length; i++) {
			num[idx] = arr[i];
			solve(idx + 1, i + 1);
		}
	}
	static class Data {
		int y, x;
		public Data(int y, int x) {
			this.y = y;
			this.x = x;
		}	
	}
}
