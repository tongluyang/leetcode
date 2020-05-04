/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (30.64%)
 * Likes:    217
 * Dislikes: 0
 * Total Accepted:    11.9K
 * Total Submissions: 38.8K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */
class Solution {
    public int jump(int[] nums) {
        //当前这一步的下一步可达到的最远位置
        int f = 0;
        //当前这一步的最远位置
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //下一步就到结尾了，加一后可以结束了
            if (nums[i] + i >= nums.length - 1) {
                step++;
                break;
            }
            f = Math.max(f, nums[i] + i);
            //这一步最远就到这里了，还没结束，再往后就要多走一步了，这一步能到的最远位置就是上一步中每个位置多走一步能到达的最远位置
            if (i == end) {
                step++;
                end = f;
            }
        }
        return step;
    }
}

