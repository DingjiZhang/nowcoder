package nowCoder.otherAlgorithm;

public class multiply {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int n = A.length;
        int[] B = new int[n];

        // 向右遍历乘前积
        B[0] = 1;
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        // 向左遍历乘后积
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= suffix;
            suffix *= A[i];
        }
        return B;
    }
}
