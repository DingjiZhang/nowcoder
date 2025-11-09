package nowCoder.myDynamic;

public class Fibonacci {
    // 线性迭代 O(n)
    public int Fibonacci1(int n) {
        if (n <= 2) return 1;
        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    
}
