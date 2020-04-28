/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 *
 * https://leetcode-cn.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (36.29%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 18.3K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * 给定一个机票的字符串二维数组 [from,
 * to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从
 * JFK 出发。
 * 
 * 说明:
 * 
 * 
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"]
 * 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 
 * 
 * 示例 1:
 * 
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * 
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> out = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String target = ticket.get(1);
            List<String> list = out.computeIfAbsent(from, k -> new LinkedList<>());
            list.add(target);
        }
        out.values().forEach(x -> x.sort(String::compareTo));
        String start = "JFK";
        List<String> res = new LinkedList();
        dfs(out, start, res);
        return res;
    }

    private void dfs(Map<String, List<String>> out, String from, List<String> res) {
        List<String> targets = out.get(from);
        while (targets != null && !targets.isEmpty()) {
            String target = targets.remove(0);
            dfs(out, target, res);
        }
        res.add(0, from);
    }

}
// @lc code=end

