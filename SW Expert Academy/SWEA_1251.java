import java.util.PriorityQueue;
import java.util.Scanner;
  
class SWEA_1251 {
    static int n;
    static double e;
    static long[][] map;
    static long[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new long[n][2];
            for (int i = 0; i < n; i++)
                map[i][0] = sc.nextLong();
            for (int i = 0; i < n; i++)
                map[i][1] = sc.nextLong();
            e = sc.nextDouble();
            graph = new long[n][n];
            long[] fr, to;
            for (int i = 0; i < n; i++) {
                fr = map[i];
                for (int j = i + 1; j < n; j++) {
                    to = map[j];
                    graph[j][i] = graph[i][j] = (fr[0] - to[0]) * (fr[0] - to[0]) + (fr[1] - to[1]) * (fr[1] - to[1]); 
                }
            }
            double cost = prim(0) * e;
            System.out.println("#" + test_case + " " + Math.round(cost));
        }
    }
    static long prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge[] dyGraph = new Edge[n];
        for (int i = 0; i < dyGraph.length; i++) {
            dyGraph[i] = new Edge(i, Long.MAX_VALUE);
            if (i == start) {
                dyGraph[i].cost = 0;
            }
            pq.add(dyGraph[i]);
        }
        long cost = 0;
        while(!pq.isEmpty()) {
            Edge front = pq.poll();
            cost += front.cost;
            for (int i = 0; i < dyGraph.length; i++) {
                Edge child = dyGraph[i];
                if (pq.contains(child)) {
                    long temp = graph[front.idx][child.idx];
                    if (temp < child.cost) {
                        child.cost = temp;
                        pq.remove(child);
                        pq.offer(child);
                    }
                }
            }
        }
        return cost;
    }
    static class Edge implements Comparable<Edge> {
        int idx;
        long cost;
        public Edge(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}
