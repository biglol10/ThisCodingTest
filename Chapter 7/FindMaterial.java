import java.util.*;

public class FindMaterial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return binarySearch(arr, target, start, mid - 1);
        else
            return binarySearch(arr, target, mid + 1, end);
    }
}