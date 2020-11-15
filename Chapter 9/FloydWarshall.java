import java.util.*;

public class Solution {
    public static final int INF = (int) 1e9;
    // 노드의 개수(N), 간선의 개수(M)
    // 노드의 개수는 최대 500개라고 가정
    public static int n, m;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        // D(a,b) = min(D(a,b), D(a,k)+D(k,b))
        n = 4;
        m = 7;

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아 그 값으로 초기화
        graph[1][2] = 4;
        graph[1][4] = 6;
        graph[2][1] = 3;
        graph[2][3] = 7;
        graph[3][1] = 5;
        graph[3][4] = 4;
        graph[4][3] = 2;

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 0; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == INF)
                    System.out.print("INFINITY");
                else
                    System.out.print(graph[a][b] + " ");
            }
            System.out.println();
        }
    }
}
