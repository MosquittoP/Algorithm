import java.util.Scanner;
 
class SWEA_2056 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            String[] a = sc.next().split("");
            String b = a[4] + a[5];
            String c = a[6] + a[7];
            String d = a[0] + a[1] + a[2] + a[3];
            if (Integer.parseInt(b) < 1 || Integer.parseInt(b) > 12 || Integer.parseInt(c) < 1 || Integer.parseInt(c) > 28)
                System.out.println("#" + test_case + " -1");
            else
                System.out.println("#" + test_case + " " + d + "/" + b + "/"+ c);
        }
    }
}
