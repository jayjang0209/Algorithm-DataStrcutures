package graph.unionfind.p323;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberOfConnectedComponents {

    public NumberOfConnectedComponents() {
    }

    public static int findNumberOfConnectedComponents(final int[][] isConnected) {
        int numberOfNode = isConnected.length;
        int[] parent = new int[numberOfNode];

        for (int i = 0; i < numberOfNode; i++) {
            parent[i] = i;
        }

        HashSet<Integer> uniqueParent = new HashSet<>();

        for (int j = 0; j < numberOfNode; j++) {
            uniqueParent.add(findParent(parent, j));
        }

        return uniqueParent.size();
    }

    public static int findParent(int[] parent, int node) {
        while( node != parent[node]) {
            node = parent[node];
        }
        return node;
    }

    public static void union(int[] parent, int firstNode, int secondNode) {
        int firstParent = findParent(parent, firstNode);
        int secondParent = findParent(parent, secondNode);
        parent[firstParent] = secondParent;
    }
}
