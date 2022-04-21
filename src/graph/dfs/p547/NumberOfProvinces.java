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
     * Return the total number of provinces.
     *
     * a province: a group of directly or indirectly connected cities
     * and no other cities outside of the group
     *
     * @param isConnected as 2D array representing n x n matrix
     * @return total number of provinces as an int
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int findCircleNum(final int[][] isConnected) {
        int totalNumberOfProvinces = 0;

        int numberOfNode = isConnected.length;
        int[] nodeVisited = new int[numberOfNode];

        for (int v = 0; v < numberOfNode; v++) {
            if (nodeVisited[v] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(v);
                while (!stack.empty()) {
                    int vtx = stack.pop();
                    nodeVisited[vtx] = 1;
                    int[] adjList = isConnected[vtx];
                    for (int j = 0; j < numberOfNode; j++) {
                        int u = adjList[j];
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
        test1[0] = new int[]{1, 0, 0};
        test1[1] = new int[]{0, 1, 0};
        test1[2] = new int[]{0, 0, 1};

        int[][] test3 = new int[4][4];
        test3[0] = new int[]{1, 0, 0, 1};
        test3[1] = new int[]{0, 1, 1, 0};
        test3[2] = new int[]{0, 1, 1, 1};
        test3[3] = new int[]{1, 0, 1, 1};


        System.out.println("number of provinces of test1: " + findCircleNum(test1));
        System.out.println("number of provinces of test2: " + findCircleNum(test2));
        System.out.println("number of provinces of test3: " + findCircleNum(test3));
    }
}
