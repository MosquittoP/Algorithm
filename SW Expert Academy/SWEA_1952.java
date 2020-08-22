import java.util.Scanner;

class SWEA_1952 { // SWEA 1952 수영장
	static int n, min;
	static int[] money, day, cal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			money = new int[4];
			for (int i = 0; i < 4; i++)
				money[i] = sc.nextInt();
			day = new int[12];
			cal = new int[14];
			for (int i = 0; i < 12; i++) {
				day[i] = sc.nextInt();
				if (day[i] != 0) {
					int sum = day[i] * money[0];
					if (sum < money[1])
						cal[i] = sum;
					else
						cal[i] = money[1];
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0, 0);
			if (min < money[3])
				System.out.println("#" + t + " " + min);
			else
				System.out.println("#" + t + " " + money[3]);
		}
	}
	static void dfs(int idx, int sum) {
		if (idx > 11) {
			if (min > sum)
				min = sum;
			return;
		}
		if (cal[idx] == 0)
			dfs(idx + 1, sum);
		dfs(idx + 1, sum + cal[idx]);
		dfs(idx + 3, sum + money[2]);
	}
}
