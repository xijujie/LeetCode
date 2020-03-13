/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.63%)
 * Likes:    180
 * Dislikes: 0
 * Total Accepted:    73.9K
 * Total Submissions: 226.3K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int cnt = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--) cnt++;
        return cnt;
    }
}
// @lc code=end

