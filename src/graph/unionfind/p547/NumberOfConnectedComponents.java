package graph.unionfind.p547;

import java.util.HashSet;

/**
 * LeetCode P547. Number of Provinces
 *
 * @author Jay Jang
 * @version Apr, 2022
 */
public class NumberOfConnectedComponents {

    public NumberOfConnectedComponents() {
    }

    /**
     * Return the total number of provinces using Iterative DFS.
     *
     * a province: a group of directly or indirectly connected cities
     * and no other cities outside of the group
     *
     * @param isConnected as 2D array representing n x n matrix
     * @return total number of provinces as an int
     *
     * Used Algorithm: Union-Find
     */
    public static int findNumberOfConnectedComponents(final int[][] isConnected) {
        int numberOfNode = isConnected.length;

        // set the parent of each vertex to itself
        int[] parent = new int[numberOfNode];
        for (int i = 0; i < numberOfNode; i++) {
            parent[i] = i;
        }

        // Iterate through the adjacency matrix and union two vertices if they are connected
        for (int i = 0; i < numberOfNode; i++) {
            for (int j = 0; j < numberOfNode; j++) {
                int[] adjList = isConnected[i];
                if (i != j && adjList[j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        // Create set to hold unique top most parents
        HashSet<Integer> uniqueParent = new HashSet<>();

        // Traverse all vertices and insert all topmost parents
        for (int j = 0; j < numberOfNode; j++) {
            uniqueParent.add(findParent(parent, j));
        }

        // Return the size unique parents, which is the number of connected components
        return uniqueParent.size();
    }

    /**
     * Find the topmost parent of a given node.
     *
     * @param parent an array containing the parent of each vertex
     * @param node an int representing a vertex
     */
    public static int findParent(final int[] parent, int node) {
        while( node != parent[node]) {
            node = parent[node];
        }
        return node;
    }

    /**
     * Join first set containing the first node and second set containing the second node
     * into a single subset.
     *
     * @param parent an array containing the parent of each vertex
     * @param firstNode an int representing a vertex
     * @param secondNode an int representing a vertex
     */
    public static void union(int[] parent, int firstNode, int secondNode) {
        int firstParent = findParent(parent, firstNode);
        int secondParent = findParent(parent, secondNode);
        parent[firstParent] = secondParent;
    }

    /**
     * Runs the program.
     *
     * @param args not used
     */
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
