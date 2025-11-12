package nowCoder.otherAlgorithm;

public class printNumbers {

    public int[] printNumbers(int n) {
        if (n <= 0) return new int[0];

        int m = 1;  // m = 10^n
        for (int i = 0; i < n; i++) m *= 10;

        int max = m - 1;
        int[] ans = new int[max];
        for (int i = 1; i <= max; i++) ans[i - 1] = i;
        return ans;
    }
}
