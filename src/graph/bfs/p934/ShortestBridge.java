package graph.bfs.p934;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import static java.lang.Math.abs;

public class ShortestBridge {

    public static int shortestBridge(int[][] grid) {
        int l = grid.length;

        int[][] marker = DFS(grid);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(marker[i][j]);
            }
            System.out.println();
        }
        int sp = findShortestLength(marker);
        return sp;
    }




    public static int[][] BFS(final int[][] grid) {
        int l = grid.length;
        int[][] gridVisited = new int[l][l];
        int islandNumber = 1;

        // there are n * n number of nodes
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == 1 && gridVisited[i][j] == 0) {
                    bfs(i, j, islandNumber, gridVisited, grid);
                    islandNumber++;
                }
            }
        }
        return gridVisited;
    }

    public static void bfs(final int i, final int j, final int islandNumber, final int[][] gridVisited, final int[][] grid) {
        gridVisited[i][j] = islandNumber;
        int l = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        int[] currentGrid = {i, j};
        q.add(currentGrid);
        while (q.size() != 0) {
            ArrayList<int[]> adj = new ArrayList<>();
            if (i - 1 >= 0) {
                adj.add(new int[]{i - 1, j});
            }
            if (i + 1 <= l - 1) {
                adj.add(new int[]{i + 1, j});
            }
            if (j - 1 >= 0) {
                adj.add(new int[]{i ,j - 1});
            }
            if (j + 1 <= l - 1) {
                adj.add(new int[]{i ,j + 1});
            }
            for (int[] adjGrid : adj) {
                if (grid[adjGrid[0]][adjGrid[1]] == 1 && gridVisited[adjGrid[0]][adjGrid[1]] == 0) {
                    gridVisited[adjGrid[0]][adjGrid[1]] = islandNumber;
                    q.add(new int[]{adjGrid[0], adjGrid[1]});
                }
            }
            q.poll();
        }
    }

    public static int findShortestLength(int[][] gridMap) {
        int l = gridMap.length;
        int minLength = l * l;
        ArrayList<int[]> first = new ArrayList<>();
        ArrayList<int[]> second = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (gridMap[i][j] == 1) {
                    first.add(new int[]{i ,j});
                } else if (gridMap[i][j] == 2) {
                    second.add(new int[]{i ,j});
                }
            }
        }

        for (int[] gridInFirst: first) {
            for (int[] gridInSecond: second) {
                int length = abs(gridInSecond[0] - gridInFirst[0]) + abs(gridInSecond[1]  - gridInFirst[1]) - 1;
                if (length < minLength) {
                    minLength = length;
                }
            }
        }
        return minLength;

    }

    public static void main(String[] args) {
        int[][] test3 = new int[3][3];
        test3[0] = new int[]{0, 1, 0};
        test3[1] = new int[]{0, 0, 0};
        test3[2] = new int[]{0, 0, 1};
        int ans = shortestBridge(test3);
        System.out.println(ans);

        int[][] test1 = new int[5][5];
        test1[0] = new int[]{1, 1, 1, 1, 1};
        test1[1] = new int[]{1, 0, 0, 0, 1};
        test1[2] = new int[]{1, 0, 1, 0, 1};
        test1[3] = new int[]{1, 0, 0, 0, 1};
        test1[4] = new int[]{1, 1, 1, 1, 1};
        int ans1 = shortestBridge(test1);
        System.out.println(ans1);
    }
}
