package BOJ;
import java.util.ArrayList;
import java.util.Scanner;

class BOJ_14891 { // 백준 14891 톱니바퀴
	static int k;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new ArrayList[5];
		String s;
		for (int i = 1; i < 5; i++) {
			map[i] = new ArrayList<>();
			s = sc.next();
			for (int j = 0; j < 8; j++)
				map[i].add(s.charAt(j) - '0');
		}
		k = sc.nextInt();
		int[][] move = new int[k][2];
		for (int i = 0; i < k; i++) {
			move[i][0] = sc.nextInt();
			move[i][1] = sc.nextInt();
		}
		int[] roll;
		for (int i = 0; i < k; i++) {
			roll = new int[5];
			switch(move[i][0]) {
			case 1:
				roll[1] = move[i][1];
				if (map[1].get(2) == map[2].get(6))
					break;
				else {
					if (move[i][1] == 1)
						roll[2] = -1;
					else
						roll[2] = 1;
					if (map[2].get(2) == map[3].get(6))
						break;
					else {
						roll[3] = roll[1];
						if (map[3].get(2) == map[4].get(6))
							break;
						else
							roll[4] = roll[2];
					}
				}
				break;
			case 2:
				roll[2] = move[i][1];
				if (map[1].get(2) != map[2].get(6)) {
					if (move[i][1] == 1)
						roll[1] = -1;
					else
						roll[1] = 1;
				}
				if (map[2].get(2) == map[3].get(6))
					break;
				else {
					if (move[i][1] == 1)
						roll[3] = -1;
					else
						roll[3] = 1;
					if (map[3].get(2) == map[4].get(6))
						break;
					else
						roll[4] = roll[2];
				}
				break;
			case 3:
				roll[3] = move[i][1];
				if (map[3].get(2) != map[4].get(6)) {
					if (move[i][1] == 1)
						roll[4] = -1;
					else
						roll[4] = 1;
				}
				if (map[2].get(2) == map[3].get(6))
					break;
				else {
					if (move[i][1] == 1)
						roll[2] = -1;
					else
						roll[2] = 1;
					if (map[1].get(2) == map[2].get(6))
						break;
					else
						roll[1] = roll[3];
				}
				break;
			case 4:
				roll[4] = move[i][1];
				if (map[3].get(2) == map[4].get(6))
					break;
				else {
					if (move[i][1] == 1)
						roll[3] = -1;
					else
						roll[3] = 1;
					if (map[2].get(2) == map[3].get(6))
						break;
					else {
						roll[2] = roll[4];
						if (map[1].get(2) == map[2].get(6))
							break;
						else
							roll[1] = roll[3];
					}
				}
				break;
			}
			for (int j = 1; j < 5; j++) {
				if (roll[j] == 1)
					rmove(j);
				else if (roll[j] == -1)
					lmove(j);
			}
		}
		int sum = map[1].get(0) == 1 ? 1 : 0;
		for (int i = 2 ; i < 5; i++) {
			if (map[i].get(0) == 1)
				sum += Math.pow(2, (i - 1));
		}
		System.out.println(sum);
	}
	static void rmove(int num) {
		int x = map[num].remove(7);
		map[num].add(0, x);
	}
	static void lmove(int num) {
		int x = map[num].remove(0);
		map[num].add(x);
	}
}
