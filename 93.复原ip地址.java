/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (45.34%)
 * Likes:    124
 * Dislikes: 0
 * Total Accepted:    12.8K
 * Total Submissions: 28.4K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(result, "", s, 1);
        return result;
    }

    private void restoreIpAddresses(List<String> result, String pre, String s, int which) {
        if (s.length() > (4 - which + 1) * 3) {
            return;
        }

        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            String ipStr;
            if (which == 4) {
                ipStr = s;
                i = s.length();//不循环了，只执行一次逻辑
            } else {
                ipStr = s.substring(0, i);
            }

            if (ipStr.startsWith("0") && ipStr.length() > 1) {
                continue;
            }
            if (i == 3 && Integer.parseInt(ipStr) > 255) {
                continue;
            }
            if (s.length() - i < (4 - which)) {
                continue;
            }
            if (which == 4) {
                result.add(pre + "." + ipStr);
                continue;
            }
            restoreIpAddresses(result, which == 1 ? ipStr : pre + "." + ipStr, s.substring(i), which + 1);
        }
    }
}

