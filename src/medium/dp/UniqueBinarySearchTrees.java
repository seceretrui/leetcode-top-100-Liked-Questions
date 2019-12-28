package medium.dp;

/**
 * Created by seceretrui 2019/12/28/17:26
 * 96.Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {
    /**
     *[1,2,3] = 1 * [2,3] + [1] * [3] + [1,2] * 1
     * f(i, n) = g(i-1) * g(n-i) (1<=i<=n)
     *solution1
     */
    public int numTrees(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) {
                    dp[i] = dp[i-1];
                } else if (j==i) {
                    dp[i] += dp[i-1];
                } else {
                    dp[i] += dp[i-1-j] * dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

    /**
     * solution2
     * 可通过设置一个头节点，让索引从2开始，避免对数组第一个和最后一个的值非负判断，这种技巧在一些链表的题中也很有用，
     * dp[0]=dp[1]=1;
     */
    public int numTrees2(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n];
        dp[0] = dp[1] = 1;
        for (int i=2; i<n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] = dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }


}