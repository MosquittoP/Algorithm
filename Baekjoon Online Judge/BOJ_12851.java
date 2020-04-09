import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 백준 12851 숨바꼭질 2
public class BOJ_12851 {
	static int N; // 수빈이 위치
	static int M; // 동생의 위치
	static int[] v; //방문 체크
	static int result = 987654321;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new int[1000000 + 1];
		//		Arrays.fill(v, -1);// 방문배열 숫자로 초기화 시킴
		//		동생을 못찾는 경우는 없다
		bfs();
		System.out.println(result);
		System.out.println(count);
	}
	static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(N,0));
		v[N] = 1; // 방문체크
		int idx;
		Data d;
		while(!q.isEmpty()) {
			d = q.poll();
			if(d.x == M) {// 현재 위치가 동생 위치임으로 기존의 최소 회수와 비교해서 보다 더 적으면 최소 회수 변경하고
						  // 카운드 회수 초기화
					      // 도착한 횟수가 같으면 count 변수 누적
				if(d.cnt < result) {
					count = 1;
					result = d.cnt;
				}else if(d.cnt == result) {
					count++;
				}
			}
			int[] nx = {d.x+ 1, d.x-1, d.x *2};
			for(int i = 0; i< 3; i++) {
				if(nx[i] < 0  || nx[i] >= 1000000) { //범위가 벗어나면 다시 안함
					continue;
				}
				if(v[nx[i]] != 0 && v[nx[i]] != d.cnt + 1) { // 방문한 적이 있는데 그것이
															  // 이전 방문에서 한번만에 온 것이면 계속적 작업 해줌
					continue;
				}
				v[nx[i]] = d.cnt + 1;  //방문체크를 회수를 이용해서 체크
				q.offer(new Data(nx[i], d.cnt + 1));
			}
		}
	}
	static class Data{
		int x; // 나의 위치
		int cnt; // 내가 이동한 횟수
		public Data(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

	}

}
