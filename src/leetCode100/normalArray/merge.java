package leetCode100.normalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {

    // 1.起点升序 2.扫描合并
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        // 按起点升序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 扫描合并
        // s e:当前的合并后区间， ns ne当前扫描到的区间
        List<int[]> ans = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0], ne = intervals[i][1];
            if (ns > e) { // 不相交
                // 记录当前区间
                ans.add(new int[]{s, e});
                // 开辟新区间
                s = ns;
                e = ne;
            } else {
                e = Math.max(e, ne); // 扩展右端
            }
        }
        ans.add(new int[]{s, e});
        return ans.toArray(new int[ans.size()][]);
    }
}
