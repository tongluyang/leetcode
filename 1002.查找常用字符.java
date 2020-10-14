/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 *
 * https://leetcode-cn.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (68.84%)
 * Likes:    141
 * Dislikes: 0
 * Total Accepted:    27.6K
 * Total Submissions: 37.8K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3
 * 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 
 * 你可以按任意顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, 100);
        for (String s : A) {
            int[] tmp = new int[26];
            for (char c : s.toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < count[i]) {
                    count[i] = tmp[i];
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int x = 0; x < count[i]; x++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
// @lc code=end

