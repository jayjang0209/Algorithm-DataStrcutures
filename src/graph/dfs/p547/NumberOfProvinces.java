package graph.dfs.p547;

import java.util.Stack;

/**
 * LeetCode P547. Number of Provinces
 *
 * @author Jay Jang
 * @version Apr, 2022
 */
public final class NumberOfProvinces {

    private NumberOfProvinces() {
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
     */
    public static int findCircleNumUsingIterDFS(final int[][] isConnected) {
        int totalNumberOfProvinces = 0;

        int numberOfNode = isConnected.length;
        int[] nodeVisited = new int[numberOfNode]; // mark all vertices as not visited 0

        for (int v = 0; v < numberOfNode; v++) {
            if (nodeVisited[v] == 0) {

                Stack<Integer> stack = new Stack<>(); // Create a stack for DFS
                stack.push(v);

                while (!stack.empty()) {
                    int vtx = stack.pop(); // pop a vertex from stack
                    nodeVisited[vtx] = 1;
                    int[] adjList = isConnected[vtx];
                    for (int j = 0; j < numberOfNode; j++) { // get all adjacent vertices
                        int u = adjList[j];
                        // only adjacent vertices that has not been visited
                        if (vtx != j && u == 1 && nodeVisited[j] == 0) {
                            stack.push(j);
                        }
                    }
                }
                totalNumberOfProvinces++;
            }
        }
        return totalNumberOfProvinces;
    }

    /**
     * Return the total number of provinces using Recursive DFS.
     *
     * a province: a group of directly or indirectly connected cities
     * and no other cities outside of the group
     *
     * @param isConnected as 2D array representing n x n matrix
     * @return total number of provinces as an int
     *
     */
    public static int findCircleNumUsingRecurDFS(final int[][] isConnected) {
        int totalNumberOfProvinces = 0;

        int numberOfNode = isConnected.length;
        int[] nodeVisited = new int[numberOfNode]; // mark all vertices as not visited 0

        for (int v = 0; v < numberOfNode; v++) {
            if (nodeVisited[v] == 0) {
                dfs(v, nodeVisited, isConnected);
                totalNumberOfProvinces++;
            }
        }
        return totalNumberOfProvinces;
    }

    /**
     * Helper function for Depth-First Search(DFS).
     *
     * @param v an int representing a vertex
     * @param nodeVisited an array representing vertex visit status
     * @param isConnected as 2D array representing n x n matrix
     */
    public static void dfs(final int v, final int[] nodeVisited,
                           final int[][] isConnected) {
        nodeVisited[v] = 1;
        for (int j = 0; j < nodeVisited.length; j++) {
            if (isConnected[v][j] == 1 && nodeVisited[j] == 0) {
                dfs(j, nodeVisited, isConnected);
            }
        }
    }

    /**
     * Runs the program.
     *
     * @param args not used
     */
    public static void main(final String[] args) {

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
        System.out.println("number of provinces of test1: " + findCircleNumUsingIterDFS(test1));
        System.out.println("number of provinces of test2: " + findCircleNumUsingIterDFS(test2));
        System.out.println("number of provinces of test3: " + findCircleNumUsingIterDFS(test3));
        System.out.println("Recursive DFS");
        System.out.println("number of provinces of test1: " + findCircleNumUsingRecurDFS(test1));
        System.out.println("number of provinces of test1: " + findCircleNumUsingRecurDFS(test2));
        System.out.println("number of provinces of test1: " + findCircleNumUsingRecurDFS(test3));
    }
}
