package nowCoder.mySimulate;

public class IsContinuous {

    /*
     *可以把 0 当作大小王（万能牌）。要成顺子需满足两点：
	1.	非 0 牌不能重复（同点数重复无法用 0 补救）
	2.	非 0 牌的最大值与最小值之差 < 5（用 0 去填中间的缺口就够）

用一次线性扫描就能判定：忽略 0，记录非 0 的最小/最大值，并用布尔表查重。
     * */
    public boolean IsContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;

        boolean[] seen = new boolean[14]; // 1-13, 0不计入
        int min = 14, max = 0;

        for (int x : numbers) {
            if (x == 0) continue;
            if (x < 1 || x > 13) continue;
            if (seen[x]) return false; // 重复了
            seen[x] = true;

            if (x < min) min = x;
            if (x > max) max = x;
        }
        return max - min < 5;
    }
}
