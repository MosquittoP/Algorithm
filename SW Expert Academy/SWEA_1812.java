import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
 
class SWEA_1812 {
    static class Rectangle implements Comparable<Rectangle>{
        int min, max;
        public Rectangle (int width, int height) {
            if (width < height) {
                min = width;
                max = height;
            }
            else {
                min = height;
                max = width;
            }
        }
        public int compareTo(Rectangle o) {
            return o.min - this.min;
        }
    }
    static int n, m, cnt, size[];
    static PriorityQueue<Rectangle> q;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            size = new int[n];
            cnt = 0;
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < n; i++)
                size[i] = Integer.parseInt(st.nextToken());
            cut();
            sb.append("#" + test_case + " " + cnt + "\n");
        }
        System.out.println(sb.toString());
    }
    static void cut() {
        Arrays.sort(size);
        q = new PriorityQueue<Rectangle>();
        q.offer(new Rectangle(m, m));
        ++cnt;
        for (int i = n - 1; i >= 0; i--)
            go(1 << size[i]);
    }
    static void go(int size) {
        Rectangle r = q.poll();
        if (r.min >= size) {
            q.offer(new Rectangle(r.min - size, size));
            q.offer(new Rectangle(r.min, r.max - size));
        }
        else {
            q.offer(r);
            q.offer(new Rectangle(m - size, size));
            q.offer(new Rectangle(m, m - size));
            ++cnt;
        }
    }
}