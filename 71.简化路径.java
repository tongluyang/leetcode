/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 *
 * https://leetcode-cn.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (36.80%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 32.7K
 * Testcase Example:  '"/home/"'
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）
 * 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 /
 * 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 
 * 
 * 示例 2：
 * 
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 
 * 
 * 示例 3：
 * 
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 
 * 
 * 示例 4：
 * 
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 
 * 
 * 示例 5：
 * 
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 
 * 
 * 示例 6：
 * 
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    static Pattern compile;
    static {
        compile = Pattern.compile("(/[^/]+?)(?=/|$)");
    }
    public String simplifyPath(String path) {
        Matcher matcher = compile.matcher(path);
        Stack<String> dirs = new Stack<>();
        while (matcher.find()) {
            String dir = matcher.group(1);
//            System.out.println(dir);
            if (dir.equals("/.")) {
                continue;
            }

            if (dir.equals("/..")) {
                if (!dirs.empty()) {
                    dirs.pop();
                }
                continue;
            }
            dirs.push(dir);
        }

        if (dirs.empty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            String dir = dirs.pop();
            sb.insert(0, dir);

            if (dirs.empty()) {
                break;
            }
        }

        return sb.toString();
    }
}

