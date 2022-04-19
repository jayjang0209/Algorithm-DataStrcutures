package Graph.DFS.P547;

import java.util.Stack;

public class NumberOfProvinces {

    private NumberOfProvinces() {
    }

    public static int findCircleNum(int[][] isConnected) {
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
                    System.out.println(vtx + "visited");

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

    public static void main(String[] args) {
        int[][] test1 = new int[3][3];
        test1[0][0] = 1;
        test1[0][1] = 1;
        test1[0][2] = 0;
        test1[1][0] = 1;
        test1[1][1] = 1;
        test1[1][2] = 0;
        test1[2][0] = 0;
        test1[2][1] = 0;
        test1[2][2] = 1;

        int[][] test2 = new int[3][3];
        test2[0][0] = 1;
        test2[0][1] = 0;
        test2[0][2] = 0;
        test2[1][0] = 0;
        test2[1][1] = 1;
        test2[1][2] = 0;
        test2[2][0] = 0;
        test2[2][1] = 0;
        test2[2][2] = 1;

        int[][] test3 = new int[4][4];
        test3[0] = new int[]{1, 0, 0, 1};
        test3[1] = new int[]{0, 1, 1, 0};
        test3[2] = new int[]{0, 1, 1, 1};
        test3[3] = new int[]{1, 0, 1, 1};


        System.out.println(findCircleNum(test1));
        System.out.println(findCircleNum(test2));
        int r = findCircleNum(test3);
        System.out.println(r);
    }
}
