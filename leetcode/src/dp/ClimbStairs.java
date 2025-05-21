package dp;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }

    /**
     * 746. 使用最小花费爬楼梯
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     */
    public int minCostClimbingStairs(int[] cost) {
        //
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int[] cost = {10, 15, 20};
        int result = climbStairs.minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
