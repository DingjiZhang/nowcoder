package nowCoder.myDynamic;

import java.util.Arrays;

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;

        int cur = array[0];  // 局部：以当前下标为结尾的最大和
        int best = array[0]; // 全局：所有cur的最大

        for (int i = 1; i < array.length; i++) {
            // 继续累加更大 还是重新开始更大
            cur = Math.max(array[i], cur + array[i]);
            best = Math.max(best, cur);
        }
        return best;
    }

    // Kadane + 记录区间 [L,R]。维护当前段的起点 curL 和和 curSum；
    // 每次决定“续上还是重新开一段”。更新到全局最优时，若和相等则按长度更长的覆盖
    public int[] FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0) return new int[0];

        // 当前连续段
        int curL = 0;
        int curSum = array[0];

        // 全局最优
        int bestL = 0, bestR = 0;
        int bestSum = array[0];

        for (int i = 1; i < array.length; i++) {
            // 累加 vs 重开？
            if (curSum < 0) { // c < 0 则重开
                curSum = array[i];
                curL = i;
            } else {
                curSum += array[i];
            }

            // 更新全局
            if (curSum > bestSum ||
                    (curSum == bestSum && (i - curL) > (bestR - bestL))) {
                bestSum = curSum;
                bestL = curL;
                bestR = i;
            }
        }
        return Arrays.copyOfRange(array, bestL, bestR + 1);
    }
}
