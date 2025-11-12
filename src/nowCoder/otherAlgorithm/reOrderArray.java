package nowCoder.otherAlgorithm;

public class reOrderArray {

    // 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变

    // 1. 时间O(n) 空间O(n)
    // 数一遍奇数个数，开新数组，第二遍按原顺序把奇数放到前半、偶数放到后半
    public int[] reOrderArray1(int[] array) {
        if (array == null || array.length == 0) return array;
        int n = array.length;

        // 统计odd个数
        int oddCnt = 0;
        for (int x : array) if ((x & 1) == 1) oddCnt++;

        int[] ans = new int[n];
        int i = 0; // odd写指针
        int j = oddCnt; // even写指针
        for (int x : array) {
            if ((x & 1) == 1) ans[i++] = x;
            else ans[j++] = x;
        }
        return ans;
    }

    // 2. 时间O(n^2) 空间O(1)
    // “稳定插入法”：遇到奇数就把它插到当前奇数段末尾，插入位置到当前位置的元素整体右移一格（向右空出当前位置）
    public int[] reOrderArray2(int[] array) {
        if (array == null || array.length == 0) return array;
        int k = 0; // 已就位的奇数段长度，下一个奇数插入位置
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int tmp = array[i];
                int j = i;
                while (j > k) {
                    array[j] = array[j - 1];
                } // 右移
                array[k] = tmp;
                k++;
            }
        }
        return array;
    }

    // 不要求相对位置，但是时间On，空间O1
    public int[] reOrderArray3(int[] array) {
        if (array == null || array.length == 0) return array;

        int l = 0, r = array.length - 1;
        while (l < r) {
            while (l < r && (array[l] & 1) == 1) l++; // 左边找odd
            while (l < r && (array[r] & 1) == 0) r--; // 右边找even
            if (l < r) {
                int t = array[l];
                array[l] = array[r];
                array[r] = t;
            }
        }
        return array;
    }
}
