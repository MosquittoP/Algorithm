import java.util.Scanner;
  
class SWEA_7465 {
    static int[] parent;
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            n = sc.nextInt();
            int m = sc.nextInt();
            parent = new int[n + 1];
            makeSet();
            int a;
            int b;
            for (int i = 0; i < m; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                union(a, b);
            }
            System.out.println("#" + t + " " + n);
        }
    }
    static void union(int x, int y) {
        int nx = findSet(x);
        int ny = findSet(y);
        if (nx == ny)
            return;
        n--;
        parent[ny] = nx;
    }
    static void makeSet() {
        for (int i = 1; i < parent.length; i++)
            parent[i] = i;
    }
    static int findSet(int x) {
        if (x == parent[x])
            return x;
        int nx = findSet(parent[x]);
        parent[x] = nx;
        return nx;
    }
}
