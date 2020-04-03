import java.util.Scanner;
import java.util.StringTokenizer;
 
class SWEA_1231 {
    static char[] b;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(sc.nextLine());
            b = new char[n + 1];
            char c;
            for (int i = 1; i < b.length; i++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                while (st.hasMoreTokens()) {
                    c = st.nextToken().charAt(0);
                    if (!Character.isDigit(c))
                        b[i] = c;
                }
            }
            System.out.print("#" + t + " ");
            inOrder(1);
            System.out.println();
        }
    }
    static void inOrder(int temp) {
        if (temp >= b.length)
            return;
        inOrder(temp * 2);
        System.out.print(b[temp]);
        inOrder(temp * 2 + 1);
    }
}