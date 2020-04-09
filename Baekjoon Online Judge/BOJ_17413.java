import java.util.Scanner;
import java.util.StringTokenizer;
 
public class BOJ_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), "<> ", true);
		String a;
		String b;
		while(st.hasMoreTokens()) {
			a = st.nextToken();
			if (a.contains("<")) {
				System.out.print(a);
				if (!a.contains(">")) {
					while (true) {
						b = st.nextToken();
						System.out.print(b);
						if (b.contains(">"))
							break;
					}
				}
			}
			else {
				System.out.print((new StringBuffer(a)).reverse());
			}
		}
	}
}
