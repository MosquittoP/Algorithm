import java.util.Scanner;

public class BOJ_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum > 100) {
				if (sum - 100 > 100 + a[i] - sum) {
					sum = sum - a[i];
					break;
				}
				else
					break;
			}
		}
		System.out.println(sum);
	}
}
