import java.util.*;

class Node implements Comparable<Node> {
    public int index;
    public int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getInstance() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance)
            return -1;
        return 1;
    }

}

public class Solution {
    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[100001];
    public static int n, m, c;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getInstance();
            int dist = node.getDistance();
            if (d[now] < dist)
                continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getInstance()]) {
                    d[graph.get(now).get(i).getInstance()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getInstance(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = 3;
        m = 2;
        c = 1;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        graph.get(1).add(new Node(2, 4));
        graph.get(1).add(new Node(3, 2));

        Arrays.fill(d, INF);

        dijkstra(c);
        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF)
                System.out.println("INFINITY");
            else
                System.out.println(d[i]);
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (d[i] != INF)
                answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }
}