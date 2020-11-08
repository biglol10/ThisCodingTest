import java.util.*;

public class TargetMoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 화폐 단위 개수
		int m = sc.nextInt(); // 타겟 화폐

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 계산된 결과를 저장하기 위한 DP 테이블 초기화
		int[] d = new int[m + 1];
		Arrays.fill(d, 10001);

		// DP 진행 (바텀업)
		d[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= m; j++) {
				// (i - k)원을 만드는 방법이 존재하는 경우
				if (d[j - arr[i]] != 10001) {
					d[j] = Math.min(d[j], d[j - arr[i]] + 1);
				}
			}
		}

		// 계산된 결과 출력
		if (d[m] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(d[m]);
		}
	}
}