/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (65.93%)
 * Likes:    262
 * Dislikes: 0
 * Total Accepted:    64.3K
 * Total Submissions: 97.4K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 *
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        ans.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; ++i){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for(int j = 1; j < ans.get(i - 1).size(); ++j){
                l.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
            }
            l.add(1);
            ans.add(l);
        }
        return ans;
    }
}
// @lc code=end

