package nums;

public class Nums {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int flag = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[flag]) {
                continue;
            } else {
                nums[flag + 1] = nums[i];
                count++;
                flag++;
            }
        }
        return count;
    }

    // 3355.零数组变换I
    /**
     * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
     *对于每个查询 queries[i]：
     *在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
     *将选中的每个下标对应的元素值减 1。
     *零数组 是指所有元素都等于 0 的数组。
     *如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            diff[l]++;
            diff[r + 1]--;
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        for (int i = 0; i < n; i++) {
            if (res[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    //3356.零数组变换II
    /**
     * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri, k]。
     *对于每个查询 queries[i]：
     *在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
     *将选中的每个下标对应的元素值加上 k。
     *零数组 是指所有元素都等于 0 的数组。
     *如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        return 0;
    }
}
