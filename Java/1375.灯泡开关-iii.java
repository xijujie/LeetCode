/*
 * @lc app=leetcode.cn id=1375 lang=java
 *
 * [1375] 灯泡开关 III
 *
 * https://leetcode-cn.com/problems/bulb-switcher-iii/description/
 *
 * algorithms
 * Medium (46.19%)
 * Likes:    4
 * Dislikes: 0
 * Total Accepted:    3.4K
 * Total Submissions: 7.3K
 * Testcase Example:  '[2,1,3,5,4]'
 *
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
 *
 * 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
 *
 * 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
 *
 *
 * 灯处于打开状态。
 * 排在它之前（左侧）的所有灯也都处于打开状态。
 *
 *
 * 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：light = [2,1,3,5,4]
 * 输出：3
 * 解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
 *
 *
 * 示例 2：
 *
 * 输入：light = [3,2,4,1,5]
 * 输出：2
 * 解释：所有开着的灯都变蓝的时刻分别是 3 和 4（index-0）。
 *
 *
 * 示例 3：
 *
 * 输入：light = [4,1,2,3]
 * 输出：1
 * 解释：所有开着的灯都变蓝的时刻是 3（index-0）。
 * 第 4 个灯在时刻 3 变蓝。
 *
 *
 * 示例 4：
 *
 * 输入：light = [2,1,4,3,6,5]
 * 输出：3
 *
 *
 * 示例 5：
 *
 * 输入：light = [1,2,3,4,5,6]
 * 输出：6
 *
 *
 *
 *
 * 提示：
 *
 *
 * n == light.length
 * 1 <= n <= 5 * 10^4
 * light 是 [1, 2, ..., n] 的一个排列。
 *
 *
 */

// @lc code=start
// 让所有开着的灯都变成蓝色的时刻的性质是：此时点亮最远的灯的位置恰巧等于点亮灯的个数。
// 若点亮最远的灯的位置大于此时点亮灯的个数，则意味着在点亮最远的灯的位置之前存在着未点亮的灯。
class Solution {
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int maxLight = 0; //点亮最远的灯
        for (int i = 0; i < light.length; i++) {
           maxLight = Math.max(maxLight, light[i]);
           if (maxLight == i + 1) ans++;
        }
        return ans;
    }
}
// @lc code=end

