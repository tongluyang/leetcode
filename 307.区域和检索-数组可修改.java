/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 *
 * https://leetcode-cn.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (53.32%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    6.8K
 * Total Submissions: 12.8K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * 
 * 示例:
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * 
 * 说明:
 * 
 * 
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 * 
 * 
 */

// @lc code=start
class NumArray {

    int[] tree;
    int length;
    public NumArray(int[] nums) {
        //tree长度为原数组的两倍，0位置空着
        tree = new int[nums.length * 2];
        length = nums.length;
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        //tree后半部分为原始数据
        for (int i = 0; i < length; i++) {
            tree[i + length] = nums[i];
        }
        //tree前半部分为后面一对数的和，从最后一对开始，向前计算
        //如果数据量为奇数个，第一个数将和最后一对数的和组成一个新的和，但他们的索引是相邻的
        for (int i = length - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
    
    public void update(int i, int val) {
        //原始数据的索引
        i += length;
        //原始数据更新为新值
        tree[i] = val;
        //更新影响到的和
        while (i > 0) {
            //这个值可能是左边的数，也可能是右边的数
            int left = i;
            int right = i;
            //tree数组总长度为length * 2，偶数，最后一个索引是奇数
            //而最后一个索引是右边的数，所以，奇数索引是右边的数，偶数索引是左边的数
            if (i % 2 == 0) {
                right++;
            } else {
                left--;
            }
            //更新左右两数的和
            tree[left / 2] = tree[left] + tree[right];
            i = left / 2;
        };
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        //定位到原始数据的位置，也是tree的最底一层
        i += length;
        j += length;
        while (i <= j) {
            //如果左边界是奇数，那这个数是二叉树右边那个数，那不能使用它和另外一个数的和，只能使用它自己
            if (i % 2 == 1) {
                sum += tree[i];
                i++;//此时左边界的数已经加到sum里，新左边界向右移动一个，求他和另外一个数的和
            }
            //如果右边界是偶数，那这个数是二叉树左边的那个数，和它成对的那个数也不再范围内，不能使用两个数的和，只能使用它自己
            if (j % 2 == 0) {
                sum += tree[j];
                j--;//此时右边界的数已经加到sum里，新右边界向左移动一个，求他和另外一个数的和
            }
            //其他情况，另外一个数也在求和的范围内，直接使用它们的和就可以了
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

