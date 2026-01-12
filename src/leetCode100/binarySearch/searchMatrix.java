package leetCode100.binarySearch;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) r++;
            else c--;
        }
        return false;
    }

    // 第二行拼在第一行后面
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];
            if (x < target) low = mid + 1;
            else if (x > target) high = mid - 1;
            else return true;
        }
        return false;
    }

}
