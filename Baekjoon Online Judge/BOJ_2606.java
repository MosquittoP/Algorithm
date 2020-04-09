import java.util.Scanner;

public class BOJ_2606 {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
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
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (findSet(1) == findSet(i))
				count++;
		}
		System.out.println(count);
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
