/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 *
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (63.76%)
 * Likes:    64
 * Dislikes: 0
 * Total Accepted:    37.2K
 * Total Submissions: 58.3K
 * Testcase Example:  '1'
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 
 * 示例：
 * 
 * n = 15,
 * 
 * 返回:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
// @lc code=end

