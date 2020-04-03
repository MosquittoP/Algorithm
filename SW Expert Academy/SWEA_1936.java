import java.util.Scanner;
  
class SWEA_1936 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        switch(n) {
        case 1:
            if (m == 2)
                System.out.println("B");
            else
                System.out.println("A");
            break;
        case 2:
            if (m == 1)
                System.out.println("A");
            else
                System.out.println("B");
            break;
        case 3:
            if (m == 1)
                System.out.println("B");
            else
                System.out.println("A");
            break;
        }
    }
}
