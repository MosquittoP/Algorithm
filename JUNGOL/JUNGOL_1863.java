import java.util.Scanner;
  
public class JUNGOL_1863 {
    private static int N, M;
    private static int people[];
    private static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        people = new int[N + 1];
        makeSet(people);
         
        for (int i = 0; i < M; i++) {
            unionSet(sc.nextInt(), sc.nextInt());
        }
         
        for (int i = 1; i < people.length; i++) {
            if (people[i] != i) {
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
    private static void makeSet(int[] people) {
        for (int i = 1; i < people.length; i++) {
            people[i] = i;
        }
    }
    private static void unionSet(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x == y) return;
        people[y] = x;
    }
    private static int findSet(int x) {
        return x == people[x] ? x : (people[x] = findSet(people[x]));
    }
}
