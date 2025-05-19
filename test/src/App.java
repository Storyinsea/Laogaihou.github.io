import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.RunElement;

public class App {
    private static final int MOD = 1_000_000_007;

    public int countPairs(int[] nums, int k) {
        final int N1 = nums.length - 1;
        int[] indices = new int[101];
        int ans = 0;
        for (int i = N1; i >= 0; i--) {
            // 具体的值
            int val = nums[i];
            // 该值的索引位置
            int ni = indices[val];
            for (int j = ni; j > i; j = nums[j]) {
                if (i * j % k == 0)
                    ans++;
            }
            // 该值的索引位置放到第i个位置
            nums[i] = ni;
            // 索引位置放到
            indices[val] = i;

        }
        return ans;
    }

    public int countpairs(int[] nums, int k) {

        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = i * j;
                if ((nums[i] == nums[j]) && sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long m = countFitPaits(nums, upper);
        long n = countFitPaits(nums, lower - 1);
        return m - n;
    }

    public long countFitPaits(int[] nums, int upper) {
        int n = nums.length - 1;
        long count = 0;
        for (int i = 0; i < n; i++) {
            while (i < n && nums[i] + nums[n] > upper) {
                n--;
            }
            count += n - i;
        }
        return count;
    }

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(); // 回答
            int cnt = entry.getValue(); // 这种回答有多少只兔子

            int groupSize = x + 1;
            int groupCount = (cnt + groupSize - 1) / groupSize; // 向上取整
            total += groupCount * groupSize;
        }

        return total;
    }

    public int countLargestGroup(int n) {
        int[] count = new int[37]; // 用于存储每个数字的位数
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i); // 计算数字的位数
            count[sum]++; // 对应位数的计数器加一
        }
        int maxCount = 0; // 最大的计数器值
        int maxCountCount = 0; // 最大计数器值的个数
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }
        for (int c : count) {
            if (c == maxCount) {
                maxCountCount++; // 找到最大计数器值的个数
            }
        }
        return maxCountCount; // 返回最大计数器值的个数
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; // 取个位数
            num /= 10; // 去掉个位数
        }
        return sum;
    }

    public int numrabbits(int[] answers) {
        Arrays.sort(answers);
        int total = 0;
        int i = 0;

        while (i < answers.length) {
            int x = answers[i]; // 当前回答
            int groupSize = x + 1;

            total += groupSize; // 默认新开一组
            int count = 1; // 当前组已有 1 只兔子（就是 answers[i] 本身）

            // 看后面是否还能归到这一组里
            while (i + 1 < answers.length && answers[i + 1] == x && count < groupSize) {
                i++;
                count++;
            }

            i++; // 移动到下一个未处理的位置
        }

        return total;
    }

    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[101];
        Arrays.sort(nums);
        if (nums[0] < k) {
            return -1;
        }
        for (int num : nums) {
            count[num]++;
        }
        int res = 0;
        for (int i = k + 1; i <= 100; i++) {
            if (count[i] != 0) {
                res++;
            }
        }
        return res;
    }

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int total = set.size(); // 不同元素的个数
        int count = 0; // 满足条件的子数组个数
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0; // 左指针
        for (int right = 0; right < n; right++) { // 右指针
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1); // 加入当前元素到窗口
            while (map.size() == total) { // 窗口内元素种类等于总种类数
                count += n - right; // 以当前左指针为起点的子数组个数
                map.put(nums[left], map.get(nums[left]) - 1); // 移除左指针元素
                if (map.get(nums[left]) == 0) { // 如果左指针元素的计数为0，移除该元素
                    map.remove(nums[left]);
                }
                left++; // 左指针右移
            }
        }
        return count;
    }

    public int countCompleteSubarrays1(int[] nums) {
        int n = nums.length;
        Set<Integer> totalkindSet = new HashSet<>();
        for (int num : nums) {
            totalkindSet.add(num);
        }
        int totalkind = totalkindSet.size();
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() == totalkind) {
                count += n - right;
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return count;
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int minPrefix = 0, maxPrefix = 0;
        int sum = 0;
        for (int diff : differences) {
            sum += diff;
            minPrefix = Math.min(minPrefix, sum);
            maxPrefix = Math.max(maxPrefix, sum);
        }
        int gap = upper - lower;
        return gap - (maxPrefix - minPrefix) + 1;
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < n; right++) {
            if (!set.add(nums[right])) {
                count++;
                set.clear();
                left += 3;
                right = left - 1;

            }
        }
        return count;

    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        return 0;
    }

    public int findNumers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digit = 0;
            while (nums[i] > 0) {
                digit++;
                nums[i] /= 10;
            }
            if (digit % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            int key = a * 10 + b;
            res += count.getOrDefault(key, 0);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        return res;
    }

    public int numTilings(int n) {
        final int MOD = 1_000_000_007;
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
        }

        return (int) dp[n];

    }

    public int percentageLetter(String s, char letter) {
        int count = 0;
        int n = s.length();
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count * 100 / n;
    }

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int m = w.length();
            for (int j = 0; j < m; j++) {
                if (w.charAt(j) != s.charAt(j)) {
                    break;
                } else {
                    count++;
                }
            }

        }
        return count;
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                max = Math.max(max, nums[i][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][n - i - 1])) {
                max = Math.max(max, nums[i][n - i - 1]);
            }
        }
        return max;
    }

    public boolean isPrime(int num) { // 判断是否是质数
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced(String num) {
        int n = num.length();
        int i = 0;
        int jsum = 0;
        int osum = 0;
        for (char s : num.toCharArray()) {
            int k = s - '0';
            if (i % 2 == 0) {
                osum += k;
            } else {
                jsum += k;
            }
            i++;
        }
        if (jsum == osum) {
            return true;
        }
        return false;
    }

    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int n = s.length();
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            String str = s.substring(i, i + k);
            int change = Integer.parseInt(str);
            if (change != 0 && num % change == 0) {
                count++;
            }
        }
        return count;
    }

    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> countmap = new HashMap<>();
        int max = 0;
        int flag = 0;
        for (int a : arr) {
            int c = countmap.getOrDefault(a, 0) + 1;
            countmap.put(a, c);
            if (c > max) {
                max = c;
                flag = a;
            }
        }
        return flag;
    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[37];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = localsum(i);
            count[sum]++;
        }
        int max = 0;
        for (int i = 0; i < 37; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }

    public int localsum(int n) {
        int sum = 0;
        while (n > 0) {
            int k = n % 10;
            sum += k;
            n /= 10;
        }
        return sum;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countmap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums1) {
            countmap.put(n, countmap.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            if (countmap.getOrDefault(n, 0) > 0) {
                list.add(n);
                countmap.put(n, countmap.get(n) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i < 999; i += 2) {
            int g = i % 10;
            int s = i / 10 % 10;
            int b = i / 100;
            int[] temp = new int[10];
            temp[g]++;
            temp[s]++;
            temp[b]++;
            boolean flag = true;
            for (int j = 0; j < 10; j++) {
                if (temp[j] > count[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, n - 1);
            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }

    public int maxCount(int m, int n, int[][] ops) {
        /**
         * int k = ops.length;
         * if (k == 0) {
         * return m * n;
         * }
         * int a = ops[0][0];
         * int b = ops[0][1];
         * for (int i = 1; i < k; i++) {
         * a = Math.min(a, ops[i][0]);
         * b = Math.min(b, ops[i][1]);
         * }
         */
        int a = m;
        int b = n;
        for (int[] op : ops) {
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }
        return a * b;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] num = new int[n];
        int o = 0;
        int j = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                num[o] = nums[i];
                o += 2;
            } else {
                num[j] = nums[i];
                j += 2;
            }
        }
        return num;
    }

    // 922. 按奇偶排序数组 II
    // 不使用额外空间版本（双指针）
    public int[] sortArrayByParityIII(int[] nums) {
        int n = nums.length;
        int o = 0;
        int j = 1;
        while (o < n && j < n) {
            if (nums[o] % 2 == 0) {
                o += 2;
            } else if (nums[j] % 2 == 1) {
                j += 2;
            } else {
                int temp = nums[o];
                nums[o] = nums[j];
                nums[j] = temp;
                o += 2;
                j += 2;
            }
        }
        return nums;
    }

    public int lengthAfterTransformations(String s, int t) {
        long[] cnt = new long[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        while (t-- > 0) {
            long[] next = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    next[0] = (next[0] + cnt[i]) % MOD;
                    next[1] = (next[1] + cnt[i]) % MOD;
                } else {
                    next[i + 1] = (next[i + 1] + cnt[i]) % MOD;
                }
            }
            cnt = next;
        }
        long sum = 0;
        for (long val : cnt) {
            sum = (sum + val) % MOD;
        }
        return (int) sum;
    }

    public int lengthAfterTransformations1(String s, int t, List<Integer> nums) {
        int n = s.length();
        long[] cnt = new long[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        while (t-- > 0) {
            long[] next = new long[26];
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == 0)
                    continue;
                int len = nums.get(i);
                for (int j = 0; j < len; j++) {
                    int k = (i + j) % 26;
                    next[k] = (cnt[i] + next[k]) % MOD;
                }
            }
            cnt = next;
        }
        long total = 0;
        for (long val : cnt) {
            total = (total + val) % MOD;
        }
        return (int) total;
    }

    public String largestGoodInteger(String num) {
        int n = num.length();
        for (int i = 9; i >= 0; i--) {
            String target = String.valueOf(i).repeat(3);
            if (num.contains(target)) {
                return target;
            }
        }
        return "";
    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> stable = new ArrayList<>();
        int n = height.length;
        for (int i = 1; i < n; i++) {
            if (height[i - 1] > threshold) {
                stable.add(i);
            }
        }
        return stable;
    }

    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int a = num1 % 10;
            int b = num2 % 10;
            int c = num3 % 10;
            ans += Math.min(a, Math.min(b, c)) * Math.pow(10, i);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return ans;
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = groups.length;
        int target = groups[0];
        result.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (target == groups[i])
                continue;
            target = groups[i];
            result.add(words[i]);
        }
        return result;
    }

    public long minSum0(int[] nums1, int[] nums2) {
        int zero1 = 0, zero2 = 0;
        long cout1 = 0, cout2 = 0;
        for (int n1 : nums1) {
            if (n1 == 0) {
                zero1++;
            } else {
                cout1 += n1;
            }
        }
        for (int n2 : nums2) {
            if (n2 == 0) {
                zero2++;
            } else {
                cout2 += n2;
            }
        }
        long sum1 = zero1 + cout1;
        long sum2 = zero2 + cout2;
        if ((zero1 == 0 && sum1 < sum2) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long zero1 = 0, zero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            zero1 += num == 0 ? 1 : 0;
        }

        for (int num : nums2) {
            sum2 += num;
            zero2 += num == 0 ? 1 : 0;
        }

        // 非0数字之和 + 0 的个数
        long accSum1 = sum1 + zero1;
        long accSum2 = sum2 + zero2;
        if ((zero1 == 0 && accSum2 > accSum1) || (zero2 == 0 && accSum1 > accSum2)) {
            return -1;
        }
        return Math.max(accSum1, accSum2);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int twonumber = 0;
        for (int s : nums) {
            if (s == 2) {
                twonumber++;
            }
            sum += s;
        }
        int onenumber = sum - 2 * twonumber;
        int zeronumber = n - twonumber - onenumber;
        for (int i = 0; i < zeronumber; i++) {
            nums[i] = 0;
        }
        for (int i = zeronumber; i < zeronumber + onenumber; i++) {
            nums[i] = 1;
        }
        for (int i = zeronumber + onenumber; i < n; i++) {
            nums[i] = 2;
        }
    }
    public static void main(String[] args) throws Exception {
        int lower = 1;
        int upper = 6;
        int[] nums = { 4, 2, 5, 7 };
        String[] words = { "a", "b", "c", "d" };
        int[] groups = { 1, 0, 1, 1 };
        String s = "24123";
        int low = 5;
        int hight = 100;
        int m = 3;
        int n = 3;
        int[][] ops = { { 2, 2 }, { 3, 3 } };
        List<Integer> list = new ArrayList<>();

        App app = new App();
        // long result = app.numRabbits(nums);
        List<String> result1 = app.getLongestSubsequence(words, groups);
        System.out.println("隐藏数组的数目有：" + result1);
    }
}
