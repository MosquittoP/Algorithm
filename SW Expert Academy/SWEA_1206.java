import java.util.Scanner;
  
class SWEA_1206 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < b.length; i++)
                b[i] = sc.nextInt();
            int max = 0;
            int sum = 0;
            int count = 0;
            for (int i = 2; i < b.length - 2; i++) {
                if (b[i] > b[i - 1] && b[i] > b[i - 2] && b[i] > b[i + 1] && b[i] > b[i + 2]) {
                    max = 0;
                    count = 0;
                    for (int j = i - 2; j <= i + 2; j++) {
                        if (i == j)
                            continue;
                        if (max < b[j]) {
                            max = b[j];
                            count = j;
                        }
                    }
                    sum += (b[i] - b[count]);
                }
            }
            System.out.println("#" + t + " " + sum);            
        }
    }
}
