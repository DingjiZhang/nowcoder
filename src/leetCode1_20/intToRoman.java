package leetCode1_20;

public class intToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            String s = symbols[i];
            while (num >= v) {
                num -= v;
                roman.append(s);
            }
            if (num == 0) break;
        }
        return roman.toString();
    }

    public String intToRoman2(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000])
                .append(hundreds[num % 1000 / 100])
                .append(tens[num % 100 / 10])
                .append(ones[num % 10]);
        return roman.toString();
    }
}
