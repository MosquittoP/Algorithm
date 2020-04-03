import java.util.Scanner;
  
class SWEA_5601 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            System.out.print("#" + t + " ");
            for (int i = 0; i < n; i++)
                System.out.printf("1/%d ", n);
            System.out.println();
        }
    }
}
