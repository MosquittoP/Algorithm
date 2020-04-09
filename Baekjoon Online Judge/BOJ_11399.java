import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		for (int i = 0; i < n; i++)
			sum += a[i] * (n - i);
		System.out.println(sum);
	}
}
