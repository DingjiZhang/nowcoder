package leetCode21_40;

public class strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);
        int n = haystack.length();
        int m = needle.length();

        int i = 0; // haystack index
        int j = 0; // needle index

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m) return i - j; // match start
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // jump in pattern
                } else {
                    i++; // move in haystack
                }
            }
        }
        return -1;
    }

    public int[] buildLPS(String p) {
        int m = p.length();
        int[] lps = new int[m];

        int len = 0; // length of longest prefix-suffix for p[0..i-1]
        int i = 1;
        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // shorten current prefix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public int strStr2(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2) return -1;
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.substring(i, i + len2).equals(needle))
                return i;
        }
        return -1;
    }
}
