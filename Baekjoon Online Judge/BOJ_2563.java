import java.util.Scanner;

public class BOJ_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[100][100];
		int count = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			for (int j = b; j < b + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					a[100 - j][k] = 1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (a[i][j] == 1)
					++count;
			}
		}
		System.out.println(count);
	}
}
