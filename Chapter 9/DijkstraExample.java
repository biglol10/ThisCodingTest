import java.util.*;

public class Solution {
    public class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }
    }

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정

    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(start)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    public static boolean[] visited = new boolean[100001];

    // 최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
    }

    public static void main(String[] args) {
        System.out.println("Asdf");

    }
}