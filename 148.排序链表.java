/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (61.48%)
 * Likes:    305
 * Dislikes: 0
 * Total Accepted:    27.3K
 * Total Submissions: 43.8K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode end) {
        if (head == end) {
            return head;
        }
        if (head.next == end) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = sortList(head, slow);
        ListNode right = sortList(slow, end);

        ListNode p1 = left;
        ListNode p2 = right;
        ListNode tmpHead = new ListNode(1);
        ListNode p = tmpHead;

        while ((p1 != slow && p1 != null) || (p2 != end && p2 != null)) {
            if (p1 == slow || p1 == null || (p2 != end && p2 != null && p1.val > p2.val)) {
                ListNode p2Next = p2.next;
                p2.next = null;
                p.next = p2;
                p2 = p2Next;
            } else {
                ListNode p1Next = p1.next;
                p1.next = null;
                p.next = p1;
                p1 = p1Next;
            }
            p = p.next;
        }

        return tmpHead.next;
    }
}
// @lc code=end

