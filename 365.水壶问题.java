/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 *
 * https://leetcode-cn.com/problems/water-and-jug-problem/description/
 *
 * algorithms
 * Medium (29.65%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    15.1K
 * Total Submissions: 45.4K
 * Testcase Example:  '3\n5\n4'
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 
 * 你允许：
 * 
 * 
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 
 * 
 * 示例 1: (From the famous "Die Hard" example)
 * 
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        int X = x;
        int Y = y;
        Set<String> mem = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        stack.add(x);
        stack.add(y);
        while (!stack.isEmpty()) {
            y = stack.pop();
            x = stack.pop();
            if (x + y == z) {
                return true;
            }
            String key = x + "," + y;
            if (mem.contains(key)) {
                continue;
            }
            mem.add(key);
            //x倒掉
            stack.add(0);
            stack.add(y);
            //y倒掉
            stack.add(x);
            stack.add(0);
            //y倒入x
            int tmpx = x;
            int tmpy = y;
            if (X - x >= y) {//剩余容量比y多
                x = x + y;
                y = 0;
            } else {//比y少，x倒满
                x = X;
                y = y - (X - tmpx);
            }
            stack.add(x);
            stack.add(y);
            //x倒入y
            if (Y - y >= x) {//剩余容量比x多
                y = x + y;
                x = 0;
            } else {//y倒满
                y = Y;
                x = x - (Y - tmpy);
            }
            stack.add(x);
            stack.add(y);
            //x倒满
            stack.add(X);
            stack.add(y);
            //y倒满
            stack.add(x);
            stack.add(Y);
        }
        return false;
    }
}
// @lc code=end

