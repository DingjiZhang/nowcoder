package nowCoder.myBitwise;

public class Add {

    public int Add(int num1, int num2) {
        // a b进位，a b无进位的和，进位加上，直到进位为0
        while (num2 != 0) {
            int carry = (num1 & num2) << 1; // 进位
            num1 = num1 ^ num2; // 无进位和
            num2 = carry; // 继续加上进位
        }
        return num1;
    }
}
