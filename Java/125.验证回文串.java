/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (42.77%)
 * Likes:    164
 * Dislikes: 0
 * Total Accepted:    85.5K
 * Total Submissions: 199.9K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j){
            while (i < j && !Character.isLetterOrDigit(c[i])) ++i;
            while (i < j && !Character.isLetterOrDigit(c[j])) --j;
            if (c[i] != c[j]) return false;
        }
        return true;
    }
}
// @lc code=end

