package leetCode100.binarySearch;

public class searchRange {

    /*
     * 闭区间写法，[left, right] ,left = 0, right = n - 1,
     * 对于所有 i < left, nums[left] < t
     * 对于所有 i > right, nums[right] >= t
     * 要找到第一个i，所以循环条件 while(left <= right),使最终 right，left，那么left就在第一个 >= t的位置
     * */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) return new int[]{-1, -1};

        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    /*
     * 返回第一个 >= t 的数组下标，没找到返回数组长度n
     * 要求，数组非递减
     * */
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
