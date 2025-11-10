package nowCoder.myOrder;

public class duplicate {
    // 原地换位，把值v放到下标为v的位置上
    public int duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        int n = numbers.length;

        // 非法校验
        for (int x : numbers) if (x < 0 || x >= n) return -1;

        for (int i = 0; i < n; i++) {
            while (numbers[i] != i) {
                int v = numbers[i];
                if (numbers[v] == v) return v; // 重复的
                // 交换numbers[i] 和 [v]
                int temp = numbers[i];
                numbers[i] = numbers[v];
                numbers[v] = temp;
            }
        }
        return -1;
    }

}
