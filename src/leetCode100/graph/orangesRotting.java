package leetCode100.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class orangesRotting {
    // bfs 问题
    public int orangesRotting(int[][] grid) {
        // 使用层序遍历
        // 1. 遍历初始化新鲜的橘子，队列第一层
        // 2. 层序遍历，每次将新鲜橘子变为腐烂橘子，加入队列
        if (grid == null || grid.length == 0) return -1;

        int M = grid.length, N = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        int count = 0; // 新鲜橘子数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) count++;
                else if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        //2. 层序遍历
        int round = 0;
        while (count > 0 && !q.isEmpty()) {
            round++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] orange = q.poll();
                int r = orange[0], c = orange[1];

                // 四个方向
                int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        count--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        if (count > 0) return -1;
        return round;

    }
}
