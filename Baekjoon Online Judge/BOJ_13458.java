
import java.util.Scanner;

public class BOJ_13458 { // 백준 13458 시험 감독
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] test = new int[n];
		for (int i = 0; i < n; i++)
			test[i] = sc.nextInt();
		int md = sc.nextInt();
		int sd = sc.nextInt();
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			test[i] -= md;
			cnt++;
			if (test[i] > 0) {
				cnt += (test[i] / sd);
				if ((test[i] % sd) > 0)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
