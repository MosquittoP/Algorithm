import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 { // 백준 11723 집합
	static int n, m;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(br.readLine());
		v = new boolean[21];
		String s;
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			switch(s) {
			case "add":
				n = Integer.parseInt(st.nextToken());
				v[n] = true;
				break;
			case "remove":
				n = Integer.parseInt(st.nextToken());
				v[n] = false;
				break;
			case "check":
				n = Integer.parseInt(st.nextToken());
				if (v[n])
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
				break;
			case "toggle":
				n = Integer.parseInt(st.nextToken());
				if (v[n])
					v[n] = false;
				else
					v[n] = true;
				break;
			case "all":
				for (int j = 1; j < 21; j++)
					v[j] = true;
				break;
			case "empty":
				for (int j = 1; j < 21; j++)
					v[j] = false;
				break;
			}
		}
		System.out.println(sb);
	}
}
