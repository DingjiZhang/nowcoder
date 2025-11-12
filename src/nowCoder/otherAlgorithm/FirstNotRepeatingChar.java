package nowCoder.otherAlgorithm;

public class FirstNotRepeatingChar {

    // 第 1 遍统计每个字符出现次数；第 2 遍按原顺序找到第一个计数为 1 的位置。时间 O(n)，空间 O(1)（常数 256 的计数表）
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;

        int[] cnt = new int[256]; // ASCII计数
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (cnt[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
