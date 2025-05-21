package math;

public class Difference {

    /**
     * 3355.零数组变换I
     * 给你一个长度为 n 的整数数组 nums 和一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
     * 对于每个查询，你需要将 nums 数组中下标在 [li, ri] 范围内的所有元素都变成 0 。
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {   // 暴力解法 此算法超出时间限制
        int n = queries.length;
        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            for (int j = l; j <= r; j++) {
                if (nums[j] > 0) {
                    nums[j]--;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArrayI(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];    // 差分数组
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            diff[l]++;
            diff[r + 1]--;
        }
        //计算实际每个位置的操作次数
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        //检查是否所有元素都变为0
        for (int i = 0; i < n; i++) {
            if (res[i] < nums[i]) {    // 当原数组中的元素为0时不会受操作数影响，即原数组元素小于操作数返回true
                return false;
            }
        }
        return true;
    }
}
