/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 *
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (44.05%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    5.7K
 * Total Submissions: 12.8K
 * Testcase Example:  '"9,3,4,#,#,1,#,#,2,#,6,#,#"'
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 
 * ⁠    _9_
 * ⁠   /   \
 * ⁠  3     2
 * ⁠ / \   / \
 * ⁠4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 
 * 
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 
 * 示例 1:
 * 
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: "1,#"
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入: "9,#,#,1"
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<Character> stack = new Stack<>();
        //预期有一个root节点
        stack.push('0');
        final String[] nodes = preorder.split(",");
        for (String node : nodes) {
            if (stack.isEmpty()) {
                return false;
            }
            if (node.startsWith("#")) {//null
                char c;
                do {
                    c = stack.pop();//本级结束，如果本级是右侧，继续结束
                } while (c == 'r');
            } else {//非空，则预期有左右节点
                stack.push('r');
                stack.push('l');
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

