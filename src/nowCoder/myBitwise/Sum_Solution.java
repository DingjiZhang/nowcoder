package nowCoder.myBitwise;

public class Sum_Solution {
    public int Sum_Solution(int n) {
        int sum = n; // 本层n计入
        // n>0 才会执行右侧
        boolean stop = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
