package nowCoder.myStack;

import java.util.Stack;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().isEmpty()) return "";

        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

}
