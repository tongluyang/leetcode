/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (43.82%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 30K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 示例: 
 * 
 * 你可以将以下二叉树：
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
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
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);

            list.add(node.val);
        }
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
        }
        while (it.hasPrevious()) {
            if (it.previous() == null) {
                it.remove();
            } else {
                break;
            }
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data) || "null".equals(data)) {
            return null;
        }
        String[] dataArray = data.substring(1, data.length() - 1).split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < dataArray.length; i += 2) {
            TreeNode left = parse(dataArray[i]);
            queue.peek().left = left;
            if (left != null) {
                queue.add(left);
            }

            if (i + 1 == dataArray.length) { //最后一个了
                break;
            }
            TreeNode right = parse(dataArray[i + 1]);
            queue.peek().left = left;
            queue.poll().right = right;
            if (right != null) {
                queue.add(right);
            }
        }
        return root;
    }

    private TreeNode parse(String data) {
        data = data.trim();
        if (data.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(data));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

