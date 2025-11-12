package nowCoder.otherAlgorithm;

public class LastRemaining_Solution {

    /*
    * 这题就是经典约瑟夫环。用递推式一行搞定：
	•	设 f(n) 为 n 个人（编号 0…n-1）、每次报到 m 删人后最后留下的编号
	•	删除一个人后，圈规模从 n 变 n-1，编号整体向左平移 m 位
	•	有递推：f(1)=0, f(n) = (f(n-1) + m) mod n
	*
	* 时间O(n) 空间O(1)
    * */
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;   // 牛客常规的非法输入约定
        int ans = 0;                       // f(1) = 0
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;           // f(i) = (f(i-1)+m) % i
        }
        return ans;                        // 返回最后剩下的编号
    }
}
