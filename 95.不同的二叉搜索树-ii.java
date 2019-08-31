/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (58.18%)
 * Likes:    181
 * Dislikes: 0
 * Total Accepted:    9.8K
 * Total Submissions: 16.6K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        return generateTrees(1, n, new HashMap<>());
    }


    public List<TreeNode> generateTrees(int start, int end, Map<String, List<TreeNode>> mem) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        String key = start + "," + end;
        if (mem.get(key) != null) {
            return mem.get(key);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1, mem);
            List<TreeNode> rights = generateTrees(i + 1, end, mem);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;

                    result.add(treeNode);
                }
            }
        }
        mem.put(key, result);

        return result;
    }
}

