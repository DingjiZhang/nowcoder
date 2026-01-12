package leetCode100.binarySearch;

public class findMin {
    public int findMin(int[] nums) {
        if (nums == null) return -1;
        int n = nums.length;
        if (n == 1) return 0;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= nums[n - 1]) {
                r = mid - 1;
            } else {
                l = mid - 1;
            }
        }
        return nums[l];
    }
}
