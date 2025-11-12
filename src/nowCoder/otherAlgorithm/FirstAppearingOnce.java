package nowCoder.otherAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstAppearingOnce {
    /*
    * 用“计数 + 队列”就能做流式维护：
	•	cnt[256] 统计每个字符出现次数（ASCII）。
	•	队 q 按到达顺序只存“仍可能是首个不重复”的字符。
	•	插入时计数 +1；若是第一次出现就入队；然后把队首那些已重复的都弹掉。
	•	查询时再清一次队首；若队空返回 '#'，否则返回队首。
    * */

    private final int[] cnt = new int[256];
    private final Deque<Character> q = new ArrayDeque<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        cnt[ch]++;
        if (cnt[ch] == 1) q.offerLast(ch); // 第一次出现，成为候选
        while (!q.isEmpty() && cnt[q.peekFirst()] > 1) {
            q.pollFirst(); // 弹掉已重复的候选
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!q.isEmpty() && cnt[q.peekFirst()] > 1) {
            q.pollFirst(); // 弹掉已重复的候选
        }
        return q.isEmpty() ? '#' : q.peekFirst();
    }
}
