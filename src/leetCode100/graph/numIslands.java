package leetCode100.graph;

import java.util.HashSet;
import java.util.Set;

public class numIslands {

    // dfs 问题
    /*
     * 岛屿数量
     * */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 取所有陆地
                if (grid[i][j] == '1') {
                    // 遍历所有陆地
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c) || grid[r][c] != '1') return;

        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }


    /*
     * 岛屿最大面积
     * */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int a = area(grid, r, c);
                ans = Math.max(ans, a);
            }
        }
        return ans;
    }

    // dfs
    private int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return 0;

        if (grid[r][c] != 1) return 0;

        grid[r][c] = 2;

        return 1
                + area(grid, r - 1, c)
                + area(grid, r + 1, c)
                + area(grid, r, c - 1)
                + area(grid, r, c + 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    /*
     * 岛屿周长
     * */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfsP(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int dfsP(int[][] grid, int r, int c) {
        // 当前格子因为超出边界而返回，返回一个黄色边（周长+1）
        if (!inArea(grid, r, c)) return 1;

        // 当前格子因为是海洋格子而返回，返回一个蓝色边（周长+1）
        if (grid[r][c] == 0) return 1;

        // 已经遍历的陆地格子，无事发生, 对周长没影响
        if (grid[r][c] != 1) return 0;

        // 标记已经访问过
        grid[r][c] = 2;

        return dfsP(grid, r - 1, c)
                + dfsP(grid, r + 1, c)
                + dfsP(grid, r, c - 1)
                + dfsP(grid, r, c + 1);
    }


    /*
     * 最大的人工岛屿 n * n的棋盘
     * */
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // 1. 给每个岛屿编号，从2开始，记录面积
        int n = grid.length;
        int id = 2;
        int[] area = new int[n * n + 2];
        int maxArea = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int a = dfsMark(grid, r, c, id); // 把这整块岛屿标记成id
                    area[id] = a;
                    maxArea = Math.max(maxArea, a);
                    id++;
                }
            }
        }
        // 2. 尝试把每个0变成1，看能连多大
        int ans = maxArea; // 如果没有0可改，要返回最大岛，即原始棋盘面积
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) { // 只访问海洋格
                    // 使用set去重，存访问过的陆地id
                    Set<Integer> seen = new HashSet<>();
                    int cur = 1; // 把这个0填成1

                    // 四个方向
                    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        int nid = grid[nr][nc]; // 邻居的岛编号
                        if (nid > 1 && seen.add(nid)) {
                            cur += area[nid];
                        }
                    }
                    ans = Math.max(ans, cur);
                }
            }
        }
        // 如果没有0，不会进入循环，那么原始岛就是最大
        return ans == 0 ? n * n : ans;
    }

    // 标记成id 并返回面积
    private int dfsMark(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n) return 0;
        if (grid[r][c] != 1) return 0;

        grid[r][c] = id;
        int area = 1
                + dfsMark(grid, r - 1, c, id)
                + dfsMark(grid, r + 1, c, id)
                + dfsMark(grid, r, c - 1, id)
                + dfsMark(grid, r, c + 1, id);
        return area;
    }

}
