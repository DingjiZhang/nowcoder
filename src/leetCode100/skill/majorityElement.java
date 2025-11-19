package leetCode100.skill;

public class majorityElement {
    public int majorityElement(int[] nums) {
        // 投票算法
        int cnt = 0;
        int candidate = 0;

        for (int x : nums) {
            if (cnt == 0) candidate = x;
            cnt += (x == candidate) ? +1 : -1;
        }
        return candidate;
    }
}
