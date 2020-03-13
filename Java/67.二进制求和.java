/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.21%)
 * Likes:    320
 * Dislikes: 0
 * Total Accepted:    68.1K
 * Total Submissions: 130.5K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int c = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || c > 0; --i, --j ){
            int tmp = (i >= 0 ? a.charAt(i) - '0':0) + (j >= 0 ? b.charAt(j) - '0':0) + c;
            c = tmp / 2;
            s.append((char) (tmp % 2 + '0'));
        }
        return s.reverse().toString();
    }
}
// @lc code=end

