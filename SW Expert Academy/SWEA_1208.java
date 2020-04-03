import java.util.Arrays;
import java.util.Scanner;
  
class SWEA_1208 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            int[] box = new int[100];
            for (int i = 0; i < 100; i++)
                box[i] = sc.nextInt();
            int max;
            int min;
            int cmax;
            int cmin;
            for (int i = 0; i < n; i++) {
                max = 0;
                min = 100;
                cmax = 0;
                cmin = 100;
                for (int j = 0; j < 100; j++) {
                    if (max < box[j]) {
                        max = box[j];
                        cmax = j;
                    }
                    if (min > box[j]) {
                        min = box[j];
                        cmin = j;
                    }
                }
                box[cmax]--;
                box[cmin]++;
            }
            Arrays.sort(box);
            System.out.println("#" + t + " " + (box[99] - box[0]));
        }
    }
}
