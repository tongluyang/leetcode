/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (54.82%)
 * Likes:    490
 * Dislikes: 0
 * Total Accepted:    76.9K
 * Total Submissions: 139.6K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode l = null;
        ListNode end = null;
        do {
            int val;

            if (l1 == null) {
                end.next = l2;
                break;
            } else if (l2 == null) {
                end.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }

            if (l == null) {
                l = new ListNode(val);
                end = l;
            } else {
                end.next = new ListNode(val);
                end = end.next;
            }

        } while (true);
        return l;
    }
}

