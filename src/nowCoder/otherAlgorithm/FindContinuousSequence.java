package nowCoder.otherAlgorithm;

import java.util.ArrayList;

public class FindContinuousSequence {

    // 用滑动窗口（双指针）找所有连续正整数段，窗口内用一个变量维护当前和。
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (sum < 3) return ans; // 至少需要两个正整数

        int l = 1, r = 2; // 窗口[l, r]
        int cur = l + r; // 窗口和

        while (l < r) {
            if (cur == sum) { // 记录下这段
                ArrayList<Integer> seq = new ArrayList<>();
                for (int x = l; x <= r; x++) seq.add(x);
                ans.add(seq);
                cur -= l++;  // 缩左边。继续找下一个
            } else if (cur < sum) { // 和小了，扩右边
                r++;
                cur += r;
            } else {  // 和大了，缩左边
                cur -= l++;
            }
        }
        return ans;
    }

}
