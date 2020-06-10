/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 *
 * https://leetcode-cn.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (53.93%)
 * Likes:    152
 * Dislikes: 0
 * Total Accepted:    8.4K
 * Total Submissions: 15.5K
 * Testcase Example:  '[["a","b"],["b","c"]]\n[2.0,3.0]\n[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * 给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k
 * 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * 
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题:  a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 
 * 输入为:  vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size()
 * == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。
 * 返回vector<double>类型。
 * 
 * 基于上述例子，输入如下：
 * 
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x",
 * "x"] ]. 
 * 
 * 
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 * 
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String left = equation.get(0);
            String right = equation.get(1);
            Map<String, Double> leftValues = map.get(left);
            if (leftValues == null) {
                leftValues = new HashMap<>();
                leftValues.put(left, 1.0);
                map.put(left, leftValues);
            }

            Map<String, Double> rightValues = map.get(right);
            if (rightValues == null) {
                rightValues = new HashMap<>();
                rightValues.put(right, 1.0);
            }

            for (String s : rightValues.keySet()) {
                Double v = rightValues.get(s);
                leftValues.put(s, leftValues.get(left) / rightValues.get(right) / values[i] * v);
                map.put(s, leftValues);
            }
        }


        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> q = queries.get(i);
            String left = q.get(0);
            String right = q.get(1);
            if (map.get(left) == null || map.get(left) != map.get(right)) {
                res[i] = -1.0;
            } else {
                res[i] = map.get(left).get(left) / map.get(right).get(right);
            }
        }
        return res;
    }
}
// @lc code=end

