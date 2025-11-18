package leetCode100.doublePointer;

public class maxArea {

    /*
     * 双指针指向左右两端，相遇停止
     * a. 更新最大面积
     * b. 选中两板子中的短板，向中间收一格
     * 返回
     * 因为：向内移动长板，短板可能不变或者变小，面积一定是变小的
     *
     * */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, ((j - i) * height[i++])) :
                    Math.max(res, ((j - i) * height[j--]));
        }
        return res;
    }
}
