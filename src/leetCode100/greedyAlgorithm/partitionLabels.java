package leetCode100.greedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class partitionLabels {

    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int indexMax = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            indexMax = Math.max(indexMax, lastIndex.get(c));
            if (i == indexMax) {
                ans.add(i - start + 1);
                start = indexMax + 1;
            }
        }
        return ans;
    }
}
