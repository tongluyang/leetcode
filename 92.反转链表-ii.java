/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (45.90%)
 * Likes:    188
 * Dislikes: 0
 * Total Accepted:    17.7K
 * Total Submissions: 38.3K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = head;
        ListNode headEnd = null;
        ListNode midEnd = null;
        ListNode midNext = null;
        ListNode next = null;
        int i = 1;
        while (h != null) {
            next = h.next;
            if (i == m - 1) {
                headEnd = h;
            }
            if (i == m) {
                midEnd = h;
                midEnd.next = null;
            }
            if (i >= m && i <= n) {
                h.next = midNext;
                midNext = h;
            }
            if (i == n) {
                if (headEnd != null) {
                    headEnd.next = midNext;
                } else {
                    head = h;
                }
                midEnd.next = next;
            }
            i++;
            h = next;
        }
        return head;
    }
}

