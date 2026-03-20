package Hot100_2.binarySearch;

public class search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        if (n == 1) return target == nums[0] ? 0 : -1;

        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1])
                    left = mid + 1;
                else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
