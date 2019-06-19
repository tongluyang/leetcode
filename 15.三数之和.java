/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (22.65%)
 * Likes:    1060
 * Dislikes: 0
 * Total Accepted:    61.6K
 * Total Submissions: 271.1K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        // long count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int maxIndex = nums.length - 1;
            for (int j = i + 1; j < maxIndex; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = maxIndex; k > j; k--) {
                    // count++;

                    final int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        final ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);

//                        if (!lists.contains(integers)) {
                            lists.add(integers);
//                        }
                        maxIndex = k;
                        break;
                    } else if (sum < 0) {
                        break;
                    }
                }
            }
        }

        // System.out.println("count:" + count);

        return lists;
    }
}

