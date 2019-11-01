package _8_graphs._5_shortest_path;

import java.util.*;

public class DijkstraAlgorithm {

    public static List<Integer> findShortestPath(int[][] graph, int start, int end) {
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new Node(i));
        }
        map.get(start).distance = 0;
        pq.offer(map.get(start));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[curr.id][i] != 0 && graph[curr.id][i] + curr.distance < map.get(i).distance) {
                    Node next = map.get(i);
                    next.distance = graph[curr.id][i] + curr.distance;
                    next.previous = curr;
                    pq.remove(next);
                    pq.offer(next);
                }
            }
        }

        List<Integer> answer = new LinkedList<>();
        Node node = map.get(end);
        while (node != null) {
            answer.add(0, node.id);
            node = node.previous;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] graph = new int[10][10];
        graph[0][1] = 5;
        graph[1][0] = 6;
        graph[0][3] = graph[3][0] = 13;
        graph[1][2] = graph[2][1] = 14;
        graph[3][5] = graph[5][3] = 2;
        graph[1][4] = 13;
        graph[4][1] = 5;
        graph[3][4] = 4;
        graph[4][3] = 12;
        graph[2][7] = 12;
        graph[7][2] = 14;
        graph[4][7] = 16;
        graph[7][4] = 3;
        graph[4][6] = graph[6][4] = 5;
        graph[5][6] = 7;
        graph[6][5] = 5;
        graph[6][7] = graph[7][6] = 2;
        graph[5][8] = graph[8][5] = 12;
        graph[2][8] = 7;
        graph[8][2] = 9;
        graph[7][8] = graph[8][7] = 3;
        graph[8][9] = graph[9][8] = 14;
        graph[7][9] = graph[9][7] = 10;

        List<Integer> path = findShortestPath(graph, 0, 9);
        System.out.println(path);
    }

    public static class Node implements Comparable<Node> {
        public int id;
        public int distance;
        public Node previous = null;

        public Node(int id) {
            this.id = id;
            distance = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Node other) {
            return distance - other.distance;
        }
    }
}
