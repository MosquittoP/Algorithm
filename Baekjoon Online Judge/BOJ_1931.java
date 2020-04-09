import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] com = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++)
				com[i][j] = sc.nextInt();
		}
		Arrays.sort(com, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(com, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int time = -1;
		int count = 0;
		for (int i = 0; i < com.length; i++) {
			if (time > com[i][0])
				continue;
			time = com[i][1];
			count++;
		}
		System.out.println(count);
	}
}
