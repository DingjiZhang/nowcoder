package leetCode1_20;

public class maxArea {
    public int maxArea(int[] height) {
        // 双指针
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            // 移动短板
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
