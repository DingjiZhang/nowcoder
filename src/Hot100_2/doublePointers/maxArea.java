package Hot100_2.doublePointers;

public class maxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            // 移动短板
            ans = height[i] < height[j] ?
                    Math.max(ans, (j - i) * height[i++]) :
                    Math.max(ans, (j - i) * height[j--]);
        }
        return ans;
    }
}
