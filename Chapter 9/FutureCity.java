import java.util.*;

public class Solution {
    public static final int INF = (int) 1e9;
    // 노드의 개수(N), 간선의 개수(M), 거쳐 갈 노드(xx), 최종 목적지 노드(kk)
    // 노드의 개수는 최대 100개라고 가정
    public static int n, m, xx, kk;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        // D(a,b) = min(D(a,b), D(a,k)+D(k,b))
        Scanner sc = new Scanner(System.in);
        n = 5;
        m = 7;

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아 그 값으로 초기화 (양방향 이동 가능)
        graph[1][2] = 1;
        graph[2][1] = 1;
        graph[1][3] = 1;
        graph[3][1] = 1;
        graph[1][4] = 1;
        graph[4][1] = 1;
        graph[2][4] = 1;
        graph[4][2] = 1;
        graph[3][4] = 1;
        graph[4][3] = 1;
        graph[3][5] = 1;
        graph[5][3] = 1;
        graph[4][5] = 1;
        graph[5][4] = 1;

        // // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        // for (int i = 0; i < m; i++) {
        // // A와 B가 서로에게 가는 비용은 1이라고 설정
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // graph[a][b] = 1;
        // graph[b][a] = 1;
        // }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == INF)
                    System.out.print("INFINITY ");
                else
                    System.out.print(graph[a][b] + " ");
            }
            System.out.println();
        }

        System.out.println(graph[1][5] + graph[5][4]);
    }
}