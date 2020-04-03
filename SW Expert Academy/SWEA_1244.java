
import java.util.Scanner;
  
class SWEA_1244 {
    static int n;
    static char[] box;
    static int max;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            String s = sc.next();
            n = sc.nextInt();
            box = s.toCharArray();
            max = 0;
            dfs(0, 0);
            System.out.println("#" + t + " " + max);
        }
    }
    static void dfs (int num1, int num2) {
        if (num2 == n) {
            String ss = "";
            for (int i = 0; i < box.length; i++)
                ss += box[i];
            if (Integer.parseInt(ss) > max)
                max = Integer.parseInt(ss);
            return;
        }
        for (int i = num1; i < box.length; i++) {
            for (int j = i + 1; j < box.length; j++) {
                if (box[i] <= box[j]) {
                    swap(box, i, j);
                    dfs(i, num2 + 1);
                    swap(box, i, j);
                }
            }
        }
    }
    static void swap (char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
