import java.util.Scanner;

public class BOJ_2804 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		String[] c = a.split("");
		String[] d = b.split("");
		int x = 0;
		int y = 0;		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if (c[i].equals(d[j])) {
					x = i;
					y = j;
					break;
				}
			}
			if (x != 0 || y != 0)
				break;
		}
		String[][] res = new String[d.length][c.length];
		for (int i = 0; i < d.length; i++) {
			if (i == y) {
				System.out.println(a);
				continue;
			}
			for (int j = 0; j < c.length; j++) {
				if (j == x) {
					System.out.print(d[i]);
					continue;
				}
				System.out.print(".");;
			}
			System.out.println();
		}
	}
}
