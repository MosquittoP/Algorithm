import java.util.Scanner;
 
public class BOJ_2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		int num = 0;
		for (int i = 1; i <= 10; i++) {
			if (a.length % i == 0) {
				if (a.length / i >= i && i > num)
					num = i;
			}
		}
		int count = 0;
		char[][] b = new char[num][a.length / num];
		for (int i = 0; i < a.length / num; i++) {
			for (int j = 0; j < num; j++) {
				b[j][i] = a[count++];
			}
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++)
				System.out.print(b[i][j]);
		}
	}
}
