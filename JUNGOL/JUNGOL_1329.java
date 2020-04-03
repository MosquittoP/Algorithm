import java.util.Scanner;
 
public class JUNGOL_1329 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 100 || n % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(' ');
            for (int j = 0; j < 2 * i + 1; j++)
                System.out.print('*');
            System.out.println();
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n / 2) - i - 1; j++)
                System.out.print(' ');
            for (int j = n - (2 * (i + 1)); j > 0; j--)
                System.out.print('*');
            System.out.println();
        }
    }
}
