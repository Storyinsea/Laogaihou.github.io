package math;

import java.util.HashMap;
import java.util.Map;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class TwoSum {
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // 哈希表
    // HashMap{key, value}
    public int[] twoSumI(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        for (int i = 0; i < n; i++) { // map.containsKey(i)判断i是否存在于map中
            int res = target - numbers[i];
            if (map.containsKey(res)) {
                return new int[] { map.get(res), i };
            }
            map.put(numbers[i], i);
        }
        return new int[0];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.使用一个dummyhead节点作为结果链表的起点
        //2.使用指针p和q遍历l1和l2
        ListNode dummyHead = new ListNode(0);
        return dummyHead;
    }
}
