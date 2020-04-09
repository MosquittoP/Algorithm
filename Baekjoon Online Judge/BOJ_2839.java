import java.util.Scanner; // 입력을 받기 위한 Scanner import

public class BOJ_2839 {
	public static void main(String[] args) { // main 함수
		Scanner sc = new Scanner(System.in); // Scanner 생성
			int m = sc.nextInt(); // 배달해야 될 m을 입력 받는다.
			int basket = 0; // 총 봉지의 수 basket
			while (true) { // 나누어 떨어질 때 까지 계속 반복
				if (m % 5 == 0) { // m이 5kg 봉지로만 가능할 때 (5kg이 3kg보다 크기 때문에 5kg이 많을수록 최소의 봉지가 된다.)
					basket += m / 5; // 봉지 수에 5kg으로 담은 갯수를 더한다.
					break; // 모두 담았기 때문에 while문을 빠져나간다.
				}
				if (m < 0) { // m이 3kg, 5kg으로 나누어 떨어지지 않을 때
					basket = -1; // -1을 준다.
					break; // 더 이상 나눌 수 없기 때문에 while문을 빠져나간다.
				}
				m -= 3; // 3kg으로 하나 담는다.
				basket++; // 3kg 봉지 하나를 추가한다.
			}
			System.out.println(basket); // 총 담은 봉지 출력
	}
}
