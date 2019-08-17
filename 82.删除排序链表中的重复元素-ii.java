/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (42.69%)
 * Likes:    130
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 36K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        ListNode pre = h;
        ListNode deleted = null;
        while (h != null) {
            if (deleted != null && h.val == deleted.val) {
                if (pre.val == deleted.val) {
                    head = h.next;
                    pre = head;
                } else {
                    pre.next = h.next;
                }
                h = h.next;
                continue;
            }
            if (h.next != null && h.val == h.next.val) {
                deleted = h;
            } else {
                deleted = null;
                pre = h;
            }

            h = h.next;
        }
        return head;
    }
}

