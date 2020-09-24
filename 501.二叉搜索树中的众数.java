/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (45.64%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    28.4K
 * Total Submissions: 58.7K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
    int count = 0;
    int[] ans = new int[]{};
    int temp = 0;
    int tempCount = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int[] left = findMode(root.left);
        helper(root.val);
        int[] right = findMode(root.right);
        return ans;
    }

    private void helper(int val) {
        if (count == 0) {
            temp = val;
            count = 1;
            tempCount = 1;
            ans = new int[]{val};
            return;
        }
        if (val == temp) {
            tempCount++;
        } else if (val > temp) {
            temp = val;
            tempCount = 1;
        }
        if (tempCount < count) {
            //do nothing
        } else if (tempCount == count) {
            int[] arr = new int[ans.length + 1];
            System.arraycopy(ans, 0, arr, 0, ans.length);
            arr[ans.length] = temp;
            ans = arr;
        } else {
            ans = new int[]{temp};
            count = tempCount;
        }
    }
}
// @lc code=end

