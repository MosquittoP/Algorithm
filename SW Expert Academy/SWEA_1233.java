import java.util.Scanner;
import java.util.StringTokenizer;
  
class SWEA_1233 {
    static String[] b;
    static char[] c;
    static int cnt;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(sc.nextLine());
            b = new String[n + 1];
            for (int i = 1; i < b.length; i++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                while (st.hasMoreTokens()) {
                    b[Integer.parseInt(st.nextToken())] = st.nextToken();
                    break;
                }
            }
            c = new char[n + 1];
            cnt = 1;
            inOrder(1);
            for (int i = 1; i < c.length - 1; i++) {
                if (!Character.isDigit(c[i]) && !Character.isDigit(c[i + 1])) {
                    System.out.println("#" + t + " 0");
                    break;
                }
                if (i == c.length - 2)
                    System.out.println("#" + t + " 1");
            }
        }
    }
    static void inOrder(int temp) {
        if (temp >= b.length)
            return;
        inOrder(temp * 2);
        c[cnt++] = b[temp].charAt(0);
        inOrder(temp * 2 + 1);
    }
}
