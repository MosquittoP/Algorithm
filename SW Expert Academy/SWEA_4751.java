import java.util.Scanner;
  
class SWEA_4751 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            char[] a = sc.next().toCharArray();
            System.out.print(".");
            for (int i = 0; i < a.length; i++)
                System.out.print(".#..");
            System.out.println();
            System.out.print(".");
            for (int i = 0; i < a.length; i++)
                System.out.print("#.#.");
            System.out.println();
            System.out.print("#");
            String ss;
            for (int i = 0; i < a.length; i++) {
                ss = ".";
                ss += a[i];
                System.out.print(ss + ".#");
            }
            System.out.println();
            System.out.print(".");
            for (int i = 0; i < a.length; i++)
                System.out.print("#.#.");
            System.out.println();
            System.out.print(".");
            for (int i = 0; i < a.length; i++)
                System.out.print(".#..");
            System.out.println();
        }
    }
}
