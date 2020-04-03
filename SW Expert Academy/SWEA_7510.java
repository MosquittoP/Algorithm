import java.util.Scanner;
  
public class SWEA_7510 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int sum;
            int count;
            int check = 1;
            for (int i = 1; i < n; i++) {
                sum = 0;
                count = i;
                while(sum < n) {
                    sum += count;
                    count++;
                }
                if (sum == n)
                    check++;
            }
            System.out.println("#" + test_case + " " + check);
             
        }
    }
}
