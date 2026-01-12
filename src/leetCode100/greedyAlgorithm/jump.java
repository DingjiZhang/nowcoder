package leetCode100.greedyAlgorithm;

public class jump {

    public int jump(int[] nums) {
        int ans = 0;
        int curUnlock = 0; // 当前能跳的最高级别
        int maxUnlock = 0; // 可选公司最多能帮你提到几级
        for (int i = 0; i < nums.length - 1; i++) {
            maxUnlock = Math.max(maxUnlock, i + nums[i]);
            if (i == curUnlock) {
                curUnlock = maxUnlock;
                ans++;
            }
        }
        return ans;
    }
}
