import java.util.Scanner;

public class BOJ_3985 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int[] cake = new int[l];
		int[][] a = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++)
				a[i][j] = sc.nextInt();
			a[i][2] = i + 1;
		}
		int num = 0;
		int fake = 0;
		for (int i = 0; i < n; i++) {
			if (num < a[i][1] - a[i][0]) {
				num = a[i][1] - a[i][0];
				fake = i + 1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = a[i][0] - 1; j < a[i][1]; j++) {
				if (cake[j] == 0)
					cake[j] = a[i][2];
			}
		}
		int[] cnt = new int[n];
		for (int i = 0; i < l; i++) {
			if (cake[i] > 0)
				cnt[cake[i] - 1]++;
		}
		int max = 0;
		int real = 0;
		for (int i = 0; i < n; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				real = i + 1;
			}
		}
		System.out.printf("%d\n%d\n", fake, real);
	}
}
