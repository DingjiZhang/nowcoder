package nowCoder.myDynamic;

public class maxProfit {
    // 只允许买卖一次，等价 在所有j找：
    // max(p[j] - min(p[0..j-1]))
    // 维护：1. minPrice 迄今为止最低价 2. maxProfit 最大收益
    // maxProfit = max(maxProfit, p - minPrice)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
