import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Set;

public class BOJ_1764 { // 백준 1764 듣보잡
	static int n, m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Set<String> list = new HashSet<>();
		Set<String> set = new TreeSet<>();
		for (int i = 0; i < n; i++)
			list.add(br.readLine());
		String s;
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			if (list.contains(s)) {
				set.add(s);
				continue;
			}
		}
		System.out.println(set.size());
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			sb.append(it.next() + "\n");
		System.out.println(sb);
	}
}
