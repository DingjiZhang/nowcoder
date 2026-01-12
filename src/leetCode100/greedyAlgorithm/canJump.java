package leetCode100.greedyAlgorithm;

public class canJump {

    public boolean canJump(int[] nums) {
        if (nums == null) return false;

        int k = 0; //前n-1个元素能到达的最远距离
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
