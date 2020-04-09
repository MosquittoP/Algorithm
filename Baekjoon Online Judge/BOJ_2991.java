import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2991 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt() - 1;
		int m = sc.nextInt() - 1;
		int n = sc.nextInt() - 1;
		int[] dog1 = new int[a + b];
		for (int i = 0; i < a; i++)
			dog1[i] = 1;
		int[] dog2 = new int[c + d];
		for (int i = 0; i < c; i++)
			dog2[i] = 1;
		int pcnt = 0;
		int mcnt = 0;
		int ncnt = 0;
		if (dog1[p % (a + b)] == 1)
			pcnt++;
		if (dog2[p % (c + d)] == 1)
			pcnt++;
		if (dog1[m % (a + b)] == 1)
			mcnt++;
		if (dog2[m % (c + d)] == 1)
			mcnt++;
		if (dog1[n % (a + b)] == 1)
			ncnt++;
		if (dog2[n % (c + d)] == 1)
			ncnt++;
		System.out.printf("%d\n%d\n%d", pcnt, mcnt, ncnt);
		System.out.println();
	}
}
