package nowCoder.otherAlgorithm;

import java.util.ArrayList;

public class FindNumbersWithSum {
    // 用升序数组的“双指针”即可：左指针从最小、右指针从最大开始，和小了左移、和大了右移，等于就返回。
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) return res;

        int l = 0, r = array.length - 1;
        while (l < r) {
            long s = (long) array[l] + array[r];
            if (s == sum) {
                res.add(array[l]);
                res.add(array[r]);
                return res;
            } else if (s < sum) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
