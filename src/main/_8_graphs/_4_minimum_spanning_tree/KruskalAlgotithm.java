package _8_graphs._4_minimum_spanning_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgotithm {

    private static int[] unionSet;

    public static List<UndirectedEdge> getMST(List<UndirectedEdge> graph, int N) {
        unionSet = new int[N];
        for (int i = 0; i < N; i++) {
            unionSet[i] = i;
        }
        List<UndirectedEdge> MST = new ArrayList<>();
        Collections.sort(graph);
        for (UndirectedEdge edge : graph) {
            if (find(edge.endpointA) != find(edge.endpointB)) {
                union(edge.endpointA, edge.endpointB);
                MST.add(edge);
            }
        }
        return MST;
    }

    private static int find(int node) {
        while (unionSet[node] != node) {
            node = unionSet[node];
        }
        return node;
    }

    private static void union(int A, int B) {
        int _A = find(A);
        int _B = find(B);
        unionSet[_A] = _B;
    }

    public static void main(String[] args) {
        List<UndirectedEdge> graph = new ArrayList<>();
        graph.add(new UndirectedEdge(0, 1, 2));
        graph.add(new UndirectedEdge(0, 2, 3));
        graph.add(new UndirectedEdge(1, 2, 4));
        graph.add(new UndirectedEdge(1, 3, 6));
        graph.add(new UndirectedEdge(1, 4, 9));
        graph.add(new UndirectedEdge(2, 4, 5));
        graph.add(new UndirectedEdge(3, 4, 4));
        graph.add(new UndirectedEdge(2, 5, 1));
        graph.add(new UndirectedEdge(4, 5, 3));
        graph.add(new UndirectedEdge(3, 6, 8));
        graph.add(new UndirectedEdge(5, 6, 7));

        List<UndirectedEdge> MST = getMST(graph, 7);
        System.out.println(MST);
    }

    public static class UndirectedEdge implements Comparable<UndirectedEdge> {
        protected int endpointA = 0;
        protected int endpointB = 0;
        protected int cost = 0;

        public UndirectedEdge(int A, int B, int cost) {
            endpointA = A;
            endpointB = B;
            this.cost = cost;
        }

        @Override
        public int compareTo(UndirectedEdge other) {
            return this.cost - other.cost;
        }

        @Override
        public String toString() {
            return endpointA + "-" + endpointB;
        }
    }
}
