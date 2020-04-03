import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
  
class JUNGOL_1169 {
    static int[] arr = {1, 2, 3, 4, 5, 6};
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6};
        result = new int[n];
        if (m == 1)
            solve1(0);
        else if (m == 2)
            solve2(0, 0);
        else if (m == 3) {
            visited = new boolean[arr.length];
            solve3(0);
        }
              
    }
    static void solve1(int num) {
        if (num == result.length) {
            StringTokenizer a = new StringTokenizer(Arrays.toString(result), "[,]");
            while(a.hasMoreTokens()) {
                System.out.print(a.nextToken());
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            result[num] = arr[i];
            solve1(num + 1);
        }
    }
    static void solve2(int num1, int num2) {
        if (num2 == result.length) {
            StringTokenizer a = new StringTokenizer(Arrays.toString(result), "[,]");
            while(a.hasMoreTokens()) {
                System.out.print(a.nextToken());
            }
            System.out.println();
            return;
        }
        for (int i = num1; i < arr.length; i++) {
                result[num2] = arr[i];
            solve2(i, num2 + 1);
        }
    }
    static void solve3(int num) {
        if (num == result.length) {
            StringTokenizer a = new StringTokenizer(Arrays.toString(result), "[,]");
            while(a.hasMoreTokens()) {
                System.out.print(a.nextToken());
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            result[num] = arr[i];
            visited[i] = true;
            solve3(num + 1);
            visited[i] = false;
        }
    }
}
