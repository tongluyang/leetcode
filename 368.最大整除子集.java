/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 *
 * https://leetcode-cn.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (37.69%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    6.8K
 * Total Submissions: 18K
 * Testcase Example:  '[1,2,3]'
 *
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si =
 * 0。
 * 
 * 如果有多个目标子集，返回其中任何一个均可。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            List<Integer> list = new ArrayList<>();
            for (int k : map.keySet()) {
                if (num % k == 0 && map.get(k).size() > list.size() - 1) {
                    list = new ArrayList<>(map.get(k));
                    list.add(k);
                }
            }
            map.put(num, list);
            if (list.size() > res.size() - 1) {
                res = new ArrayList<>(list);
                res.add(num);
            }
        }
        return res;
    }
}
// @lc code=end

