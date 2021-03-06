/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (35.43%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    21.1K
 * Total Submissions: 59.3K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        final ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        // long count = 0;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int maxIndex = nums.length - 1;
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    for (int l = maxIndex; l > k; l--) {

                        // count++;

                        final int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            final ArrayList<Integer> integers = new ArrayList<>();
                            integers.add(nums[i]);
                            integers.add(nums[j]);
                            integers.add(nums[k]);
                            integers.add(nums[l]);

//                        if (!lists.contains(integers)) {
                            lists.add(integers);
//                        }
                            maxIndex = l;
                            break;
                        } else if (sum < target) {
                            break;
                        }
                    }
                }
            }
        }

        // System.out.println("count:" + count);

        return lists;
    }
}

