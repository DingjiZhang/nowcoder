package leetCode100.myHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        for (int a : nums) numsList.add(a);
        return quickSelect(numsList, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        // 基于快排的快速选择
        // 随机选一个基准
        Random random = new Random();
        int p = nums.get(random.nextInt(nums.size()));

        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();

        for (int a : nums) {
            if (a > p) big.add(a);
            else if (a < p) small.add(a);
            else equal.add(a);
        }

        if (k <= big.size()) {
            return quickSelect(big, k);
        } else if (big.size() + equal.size() < k) {
            return quickSelect(small, k - (big.size() + equal.size()));
        }
        return p;
    }

}
