/*
 * @lc app=leetcode.cn id=420 lang=java
 *
 * [420] 强密码检验器
 *
 * https://leetcode-cn.com/problems/strong-password-checker/description/
 *
 * algorithms
 * Hard (16.03%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    1.4K
 * Total Submissions: 8.4K
 * Testcase Example:  '""'
 *
 * 一个强密码应满足以下所有条件：
 * 
 * 
 * 由至少6个，至多20个字符组成。
 * 至少包含一个小写字母，一个大写字母，和一个数字。
 * 同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
 * 
 * 
 * 编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s
 * 修改为满足强密码条件的字符串所需要进行修改的最小步数。
 * 
 * 插入、删除、替换任一字符都算作一次修改。
 * 
 */

// @lc code=start
class Solution {
    public int strongPasswordChecker(String s) {
        int len = s.length();
        if (len <= 3) {//直接插入，补足位数
            return 6 - len;
        }
        int delete = 0;
        if (len > 20) {
            delete = len - 20;//至少要删除的字符数
        }
        boolean is1 = false;
        boolean isa = false;
        boolean isA = false;
        char pre = 0;
        int seq = 1;
        int seqStepDel = 0;
        int seqStepRep = 0;
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                is1 = true;
            } else if (c >= 'a' && c <= 'z') {
                isa = true;
            } else if (c >= 'A' && c <= 'Z') {
                isA = true;
            }
            if (c == pre) {
                seq++;
            } else {
                if (delete > 0) {//有需要删除的
                    if (seq % 3 == 0) {//删除优于替换，先删掉一个
                        delete--;
                        seqStepDel++;
                        seq--;
                    }
                }
                if (seq > 3 && seq % 3 == 1) {// aaaa aaaaaaa这种形式，删除两个，就会减少一次替换的次数
                    count1++;
                }
                seqStepRep += seq / 3;//replace
                seq = 1;
            }
            pre = c;
        }
        if (delete > 0) {//有需要删除的
            if (seq % 3 == 0) {//删除优于替换，先删掉一个
                delete--;
                seqStepDel++;
                seq--;
            }
        }
        if (seq > 3 && seq % 3 == 1) {// aaaa aaaaaaa这种形式，删除两个，就会减少一次替换的次数
            count1++;
        }
        seqStepRep += seq / 3;//replace
        //每删除2个，就可以减少一次替换
        while (count1 > 0 && delete >= 2) {
            seqStepRep--;
            seqStepDel += 2;
            delete -= 2;
            count1--;
        }
        //每删除3个，就可以减少一次替换
        while (delete >= 3) {
            seqStepRep--;
            seqStepDel += 3;
            delete -= 3;
        }
        int rep = 0;
        if (!is1) {//insert or replace
            rep++;
        }
        if (!isa) {
            rep++;
        }
        if (!isA) {
            rep++;
        }
        rep = Math.max(rep, seqStepRep);//替换序列的字符可以和替换数字字母的步骤复用
        int insert = 0;
        if (rep + len < 6) {//替换或插入后，还不够长度，需要补足6位
            insert = 6 - len - rep;
        }
        return rep + seqStepDel + delete + insert;
    }
}
// @lc code=end

