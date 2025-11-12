package nowCoder.otherAlgorithm;

public class NumberOf1Between1AndN {

    // 按位统计 - 时间 O(log n)，空间 O(1)
    /*
     *把 1~n 的所有数，看成对“某一位”（个位/十位/百位…）在不停地从 0 到 9 循环。
     * 我们就对每一位单独数这位上出现数字 1 的次数，最后把各位的次数相加
     *
     * 对某一位，用三个量拆分 n：
	•	factor：这位的权重（个位 1，十位 10，百位 100…）
	•	left  = n / (factor*10)：这位左边的高位
	•	cur   = (n / factor) % 10：这位当前的数字
	•	right = n % factor：这位右边的低位
     *
     *	1.	cur == 0
这位完整经历了 left 次 0~9 的循环。每次循环里，这一位为 1 的连续区间长度正好是 factor。
⇒ 贡献 left * factor
	2.	cur == 1
也是有 left 个完整循环，再加上最后不完整的一段，其中这一位为 1 的长度是 right + 1（从 …10… 到 …1(right)…）。
⇒ 贡献 left * factor + right + 1
	3.	cur >= 2
有 left 个完整循环，且最后的不完整一段已经完整覆盖了这一位为 1 的那一整段（长度就是 factor）。
⇒ 贡献 (left + 1) * factor
     *
     * */
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        long factor = 1; // 当前位的权重
        int ans = 0;

        while (factor <= n) {
            long left = n / (factor * 10);
            long cur = (n / factor) % 10;
            long right = n % factor;

            if (cur == 0) ans += left * factor;
            else if (cur == 1) ans += left * factor + right + 1;
            else ans += (left + 1) * factor;

            factor *= 10;
        }
        return ans;
    }


    // 时间 O(n logn)，空间 O(nlogn)
    public int NumberOf1Between1AndN_Solution2(int n) {
        if (n <= 0) return 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(i);
        }

        int cnt = 0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '1') cnt++;
        }
        return cnt;
    }
}
