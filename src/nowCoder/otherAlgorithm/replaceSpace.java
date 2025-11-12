package nowCoder.otherAlgorithm;

public class replaceSpace {

    public String replaceSpace(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder(s.length() * 3);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
