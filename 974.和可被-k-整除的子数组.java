/*
 * @lc app=leetcode.cn id=974 lang=java
 *
 * [974] 和可被 K 整除的子数组
 *
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/description/
 *
 * algorithms
 * Medium (38.40%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    10.5K
 * Total Submissions: 24.8K
 * Testcase Example:  '[4,5,0,-2,-3,1]\n5'
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2,
 * -3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //(sums[i] - sums[j]) % K == 0
        //sums[i] % K == sums[j] % K
        //i j满足要求
        
        
        //[-1,2,9]\n2
        //-1 % 2 -> -1
        //9 % 2 -> 1
        //所以不能直接用 %，需要使用Math.floorMod
        
        map.put(0, 1);//自身可以满足要求
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int mod = Math.floorMod(sum, K);
            int c = map.getOrDefault(mod, 0);
            count += c;
            map.put(mod, c + 1);
        }
        return count;
    }
}
// @lc code=end

