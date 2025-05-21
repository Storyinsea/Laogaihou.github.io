package string;

public class Stringoperation {

    // 28.找出字符串中第一个匹配项的下标
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0
     * 开始）。如果 needle 不是 haystack 的一部分，则返回 -1 。
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    // 58.最后一个单词的长度
    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
