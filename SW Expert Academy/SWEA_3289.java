import java.util.Scanner;
  
class SWEA_3289 {
    static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            parent = new int[n + 1];
            int e = 0;
            int[] d = new int[m];
            makeSet();
            System.out.print("#" + t + " ");
            for (int i = 0 ; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();               
                if (a == 0) {
                    union(b, c);
                }
                else {
                    if (findSet(b) == findSet(c))
                        System.out.print("1");
                    else
                        System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    static void union(int x, int y) {
        int nx = findSet(x);
        int ny = findSet(y);
        if (nx == ny)
            return;
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
