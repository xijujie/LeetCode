/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (44.23%)
 * Likes:    462
 * Dislikes: 0
 * Total Accepted:    57.7K
 * Total Submissions: 130.4K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 *
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */

// @lc code=start
// dp[i] 表示前i个元素以第 i个数字nums[i]结尾的最长上升子序列的长度
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i){
            dp[i] = 1;
            for (int j = 0; j < i; ++j){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end

