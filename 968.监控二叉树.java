/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
 *
 * https://leetcode-cn.com/problems/binary-tree-cameras/description/
 *
 * algorithms
 * Hard (39.67%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    16.9K
 * Total Submissions: 34.5K
 * Testcase Example:  '[0,0,null,0,0]'
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 
 * 计算监控树的所有节点所需的最小摄像头数量。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * 
 * 
 */

// @lc code=start
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
    Map<Integer, Map<TreeNode, Integer>> mem = new HashMap<>();
    public int minCameraCover(TreeNode root) {
        mem.put(1, new HashMap<>());
        mem.put(2, new HashMap<>());
        mem.put(3, new HashMap<>());
        return helper(root, 2);
    }

    private int helper(TreeNode root, int offset) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {//下面没了
            if (offset == 1) {//parent装了，可以不用装
                return 0;
            }
            return 1;//一定要装
        }
        if (mem.get(offset).get(root) != null) {
            return mem.get(offset).get(root);
        }
        int min;
        //offset=1 parent装了
        //offset=2 parent的parent装了
        if (offset <= 2) {//parent装了或parent被监视到了，这里可以装可以不装
            min = Math.min(
                helper(root.left, 1) + helper(root.right, 1) + 1,//装了
                Math.min(//没装，那需要左边装或右边装
                    root.left == null ? Integer.MAX_VALUE : (helper(root.left, offset + 1) + helper(root.right, 2)),//装左边
                    root.right == null ? Integer.MAX_VALUE : (helper(root.left, 2) + helper(root.right, offset + 1))//装右边
                )
            );
        } else {//offset=3，一定要装了
            min = helper(root.left, 1) + helper(root.right, 1) + 1;
        }
        mem.get(offset).put(root, min);
        return min;
    }
}
// @lc code=end

