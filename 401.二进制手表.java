/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (51.86%)
 * Likes:    138
 * Dislikes: 0
 * Total Accepted:    14.7K
 * Total Submissions: 28.3K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        bt(num, res, 0, 0, 0, 0);
        return res;
    }

    Set<String> mem = new HashSet<>();
    private void bt(int num, List<String> res, int h, int m, int minH, int minM) {
        if (h > 11) {
            return;
        }
        if (m > 59) {
            return;
        }
        if (num == 0) {
            String time = String.format("%1$d:%2$02d", h, m);
            if (mem.contains(time)) {
                return;
            }
            mem.add(time);
            res.add(time);
            return;
        }
        for (int i = minM; i < 8; i++) {
            if ((m & (1 << i)) == 0) {
                bt(num - 1, res, h, m | (1 << i), minH, i + 1);
            }
        }
        for (int i = minH; i < 4; i++) {
            if ((h & (1 << i)) == 0) {
                bt(num - 1, res, h | (1 << i), m, i + 1, minM);
            }
        }
    }
}
// @lc code=end

