/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (50.87%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    10.1K
 * Total Submissions: 19.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
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
    Stack<ListNode> stack = new Stack<>();
    public void reorderList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = stack.pop();
        stack.peek().next = null;
        ListNode nextHead = head.next;
        head.next = next;
        next.next = helper(nextHead);
        return head;
    }
}
// @lc code=end

