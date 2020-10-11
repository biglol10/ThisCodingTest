import java.util.*;

public class RiceCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 파라메트릭 서치는 최적화 문제를 결정 문제로 바꾸어 해결하는 기법
        // 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제에 주로 파라메트릭 서치를 사용
        // 탐색 범위는 1부터 10억까지의 정수 중 하나인데 이처럼 큰 수를 보면 이진 탐색을 떠올려야 한다

        // 떡의 개수(N)와 요청한 떡의 길이(M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9;

        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid)
                    total += arr[i] - mid;
            }
            if (total < m) { // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                end = mid - 1;
            } else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }
    }
}