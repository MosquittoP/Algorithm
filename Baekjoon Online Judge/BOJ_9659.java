import java.util.Scanner;
 
public class BOJ_9659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		if (n % 2 == 1)
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}
