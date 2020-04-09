import java.util.Scanner;
 
public class BOJ_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int[] a = new int[n];
		a[0] = 1;
		int check = 0;
		int count = 0;
		while (true) {
			if (a[check] == m)
				break;
			if (a[check] % 2 == 1) {
				check += l;
				if (check > n - 1)
					check -= n;
				a[check]++;
				count++;
			}
			else {
				check -= l;
				if (check < 0)
					check += n;
				a[check]++;
				count++;
			}
		}
		System.out.println(count);
	}
}
