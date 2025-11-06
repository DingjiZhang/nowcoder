package nowCoder.myTree;

import java.util.ArrayList;

public class VerifySquenceOfBST {
    // 根据末尾（顶）划分
    private boolean solve(ArrayList<Integer> list) {
        if (list.size() == 0 || list.size() == 1) {
            return true;
        }

        ArrayList<Integer> minList = new ArrayList<>(); // 小的一堆
        ArrayList<Integer> maxList = new ArrayList<>(); // 大的一堆
        int endNum = list.get(list.size() - 1);

        int minIndex = -1; // 小的一堆起始点
        int maxIndex = -1; // 大的一堆起始点
        // 分堆处理
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > endNum) {
                if (maxIndex == -1) {
                    maxIndex = i; // 大的一堆的起始点
                }
                maxList.add(list.get(i));
            } else if (list.get(i) < endNum) {
                if (minIndex == -1) { // 小的一堆的起始点
                    minIndex = i;
                }
                minList.add(list.get(i));
            }
        }
        if (minIndex != -1 && maxIndex != -1) { // 只有全大/全小的是正确的
            if (minIndex > maxIndex) { // 前部分（若有）一定比后部分（若有）的值小，即 minIndex < maxIndex
                return false;
            }
            // 这里minIndex < maxIndex
            for (int i = maxIndex; i < list.size(); i++) {
                if (list.get(i) < endNum) { // 大堆里面有小的就不对
                    return false;
                }
            }
        }
        return solve(minList) && solve(maxList);
    }

    // LRN 后序遍历
    // 1. N 在末尾 2. 左子树都小于N，右子树都大于N
    // 左右各部分必须连续。 4132 就不对 要么 3412 要么 4213
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sequence.length; i++) {
            list.add(sequence[i]);
        }
        return solve(list);
    }
}
