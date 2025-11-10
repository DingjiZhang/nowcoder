package nowCoder.myTrackback;

import java.util.ArrayDeque;
import java.util.Queue;

public class movingCount {

    // 这题就是：从 (0,0) 出发，只能走上下左右，且只能进入“行号各位和 + 列号各位和 ≤ threshold”的格子；
    // 问能到多少个不同格子。典型 BFS/DFS + visited。
    // 	•	把“是否能进格子 (i,j)”写成 digitsum(i) + digitsum(j) <= k。
    //	•	从 (0,0) 起，用 队列 BFS（或递归 DFS）扩展到四邻格；每个格子只进一次（visited）。
    //	•	计数即为可达格子的个数。时间/空间都是 O(rows*cols)。
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[][] vis = new boolean[rows][cols];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 四个方向

        // 预计算 数字各位和
        int[] rSum = buildDigitSums(rows);
        int[] cSum = buildDigitSums(cols);

        if (rSum[0] + cSum[0] > threshold) return 0; // 入口(0,0)进不去

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0}); // (0,0)ok，符合要求的格子入队
        vis[0][0] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll(); // 符合的格子出队，访问它的四方向
            int i = p[0], j = p[1];
            cnt++; // 进入了一个合法且未访问过的格子

            // 进入四方向
            for (int d[] : dir) {
                int ni = i + d[0], nj = j + d[1];
                if (ni < 0 || ni >= rows || nj < 0 || nj >= cols) continue; // 略过边界
                if (vis[ni][nj]) continue; // 略过访问过的

                if (rSum[ni] + cSum[nj] <= threshold) {
                    vis[ni][nj] = true;
                    q.offer(new int[]{ni, nj}); // 符合的入队
                }
            }
        }
        return cnt;

    }

    // 数字0..n 的各位和表
    private int[] buildDigitSums(int n) {
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = sum[i / 10] + (i % 10);
        }
        return sum;
    }
}
