import java.util.Scanner;

class SWEA_4530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            String a = sc.next();
            String b = sc.next();
            String a4 = four(a);
            String b4 = four(b);
            if (a.charAt(0) == '-' && b.charAt(0) != '-') {
                System.out.println("#" + test_case + " " + (ten(b4) - ten(a4) - 1));                
            }
            else
                System.out.println("#" + test_case + " " + (ten(b4) - ten(a4)));                
        }
    }
    static String four(String n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '-') {
                sb.append('-');
                continue;
            }
            if (n.charAt(i) > '4')
                sb.append(n.charAt(i) - '1');
            else
                sb.append(n.charAt(i));
        }
        return sb.toString();
    }
    static long ten(String n) {
        long cnt = 0;
        long num = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '-') {
                num *= -1;
                break;
            }
            num += (n.charAt(i) - '0') * Math.pow(9, cnt++);
        }
        return num;
    }
}