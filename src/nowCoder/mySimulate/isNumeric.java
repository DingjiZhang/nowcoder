package nowCoder.mySimulate;

public class isNumeric {

    // 用线性扫描 + 状态标记就能判定是否是数值（支持整数、小数、科学计数法，允许首尾空格）。
    /*
     *	•	先去掉前导空格；途中若遇到尾随空格，后面必须全是空格。
	•	只允许两个地方出现符号：开头、或紧跟在 e/E 后。
	•	. 只能出现一次，且不能出现在 e/E 之后。
	•	e/E 只能出现一次，且前面必须已有数字；e/E 之后必须跟整数（可带符号）。
	•	用 seenDigit 记录到当前为止是否见过数字；遇到 e/E 时把它重置为 false，强制要求指数部分也要有数字。
     * */
    public boolean isNumeric(String str) {
        if (str == null) return false;
        int n = str.length(), i = 0;

        // 空格
        while (i < n && str.charAt(i) == ' ') i++;
        if (i == n) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        while (i < n) {
            char c = str.charAt(i);

            if (c >= '0' && c <= '9') {
                seenDigit = true;
            } else if (c == '.') {
                // 小数点只能出现一次，且不能在e后
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // e只能出现一次，且前面必须有数字
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false;       // e后面的部分也要有数字
            } else if (c == '+' || c == '-') {
                // 符号只能在开头or紧跟e后
                if (i > 0 && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') return false;
            } else if (c == ' ') {
                // 遇到空格：后面必须全是空格
                while (i < n && str.charAt(i) == ' ') i++;
                return seenDigit && i == n;
            } else {
                return false;
            }
            i++;
        }
        // 结束时必须见过数字（避免 "1e"、"+"、"." 等）
        return seenDigit;
    }
}
