/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (38.18%)
 * Likes:    338
 * Dislikes: 0
 * Total Accepted:    51.7K
 * Total Submissions: 131.1K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        ListNode pre = head;
        boolean odd;
        while (true) {
            if (f == null) {
                odd = false;
                break;
            } else if (f.next == null) {
                odd = true;
                break;
            }
            f = f.next.next;
            ListNode cur = s;
            s = s.next;
            if (cur != head) {
                pre.next = s;
                cur.next = head;
                head = cur;
            }
        }
        if (odd) {
            s = s.next;
        }
        while (true) {
            if (s == null) {
                return true;
            }
            if (head.val != s.val) {
                return false;
            }
            head = head.next;
            s = s.next;
        }
    }
}
// @lc code=end

