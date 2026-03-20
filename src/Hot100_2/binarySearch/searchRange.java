package Hot100_2.binarySearch;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findEdge(nums, target, true), findEdge(nums, target, false)};
    }

    public int findEdge(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        int tmpIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                tmpIndex = mid;
                if (isLeft) right = mid - 1;
                else left = mid + 1;
            }
        }
        return tmpIndex;
    }
}
