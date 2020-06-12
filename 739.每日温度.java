/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 *
 * https://leetcode-cn.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (61.37%)
 * Likes:    363
 * Dislikes: 0
 * Total Accepted:    60.1K
 * Total Submissions: 96.5K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4,
 * 2, 1, 1, 0, 0]。
 * 
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * 
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] first = new int[71];//每个温度第一次出现的位置
        for (int i = T.length - 1; i >= 0; i--) {
            int min = 0;
            for (int t = T[i] + 1; t <= 100; t++) {
                if (min == 0 || (first[t - 30] != 0 && first[t - 30] < min)) {
                    min = first[t - 30];
                }
            }
            
            first[T[i] - 30] = i;
            T[i] = min == 0 ? 0 : min - i;
        }
        return T;
    }
}
// @lc code=end

