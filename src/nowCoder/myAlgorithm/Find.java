package nowCoder.myAlgorithm;

public class Find {
    //左到右，上到下递增，右上角开始，大了左移，小了下移
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;

        int n = array.length, m = array[0].length;
        int r = 0, c = m - 1; // 右上角
        while (r < n && c >= 0) {
            int x = array[r][c];
            if (x == target) return true;
            else if (x > target) c--;
            else r++;
        }
        return false;
    }
}
