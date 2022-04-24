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

        for (int i = 0; i < numberOfNode; i++) {
            for (int j = 0; j < numberOfNode; j++) {
                int[] adjList = isConnected[i];
                if (i != j && adjList[j] == 1) {
                    union(parent, i, j);
                }
            }
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

    public static void main(String[] args) {
        int[][] test1 = new int[3][3];
        test1[0] = new int[]{1, 1, 0};
        test1[1] = new int[]{1, 1, 0};
        test1[2] = new int[]{0, 0, 1};

        int[][] test2 = new int[3][3];
        test2[0] = new int[]{1, 0, 0};
        test2[1] = new int[]{0, 1, 0};
        test2[2] = new int[]{0, 0, 1};

        int[][] test3 = new int[4][4];
        test3[0] = new int[]{1, 0, 0, 1};
        test3[1] = new int[]{0, 1, 1, 0};
        test3[2] = new int[]{0, 1, 1, 1};
        test3[3] = new int[]{1, 0, 1, 1};

        System.out.println("Iterative DFS");
        System.out.println("number of provinces of test1: " + findNumberOfConnectedComponents(test1));
        System.out.println("number of provinces of test2: " + findNumberOfConnectedComponents(test2));
        System.out.println("number of provinces of test3: " + findNumberOfConnectedComponents(test3));
        System.out.println("Recursive DFS");
        System.out.println("number of provinces of test1: " + findNumberOfConnectedComponents(test1));
        System.out.println("number of provinces of test1: " + findNumberOfConnectedComponents(test2));
        System.out.println("number of provinces of test1: " + findNumberOfConnectedComponents(test3));
    }
}
