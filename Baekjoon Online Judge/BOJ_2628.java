import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class BOJ_2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a = sc.nextInt();
		int[][] b = new int[a][2];
		int countx = 0;
		int county = 0;
		for (int i = 0; i < a; i++) {
			b[i][0] = sc.nextInt();
			b[i][1] = sc.nextInt();
			if (b[i][0] == 0)
				county++;
			else
				countx++;
		}
		Arrays.sort(b, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int[][] map = new int[n + county][m + countx];
		int checky = 0;
		int checkx = 0;
		for (int i = 0; i < a; i++) {
			if (b[i][0] == 0) {
				for (int j = 0; j < map[0].length; j++)
					map[b[i][1] + checky][j] = 1;
				checky++;
			}
			else {
				for (int j = 0; j < map.length; j++)
					map[j][b[i][1] + checkx] = 1;
				checkx++;
			}
		}
		int y;
		int x;
		int count = 0;
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					int ny = i;
					int nx = j;
					while (ny < map.length && map[ny][j] == 0)
						ny++;
					while (nx < map[i].length && map[i][nx] == 0)
						nx++;
					for (int k = i; k < ny; k++) {
						for (int l = j; l < nx; l++) {
							map[k][l] = 2;
							count++;
						}
					}
					if (max < count)
						max = count;
					count = 0;
				}
			}
		}
		System.out.println(max);
	}
}
