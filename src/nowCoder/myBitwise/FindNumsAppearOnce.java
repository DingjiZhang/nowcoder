package nowCoder.myBitwise;

public class FindNumsAppearOnce {

    public int[] FindNumsAppearOnce(int[] nums) {
        int xor = 0;
        for (int x : nums) xor ^= x; // a ^ b

        int mask = xor & -xor; // 取最低位的1， a b 在这位上不同

        int a = 0, b = 0;
        for (int x : nums) {
            if ((x & mask) == 0) a ^= x;
            else b ^= x;
        }
        //
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        return new int[]{a, b};
    }
}
