package nowCoder.myAlgorithm;

public class minNumberInRotateArray {
    public int minNumberInRotateArray(int[] nums) {
        /*用二分找“拐点”（最小值）。关键是比较 mid 与右端 r：
	•	若 nums[mid] > nums[r]：最小值在 右半边（不含 mid），l = mid + 1
	•	若 nums[mid] < nums[r]：最小值在 左半边（含 mid），r = mid
	•	若 nums[mid] == nums[r]：无法判断方向，但可以安全地丢掉 r，r--（应对重复值）
	*/
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
