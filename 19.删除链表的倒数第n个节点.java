/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (33.81%)
 * Likes:    416
 * Dislikes: 0
 * Total Accepted:    49.4K
 * Total Submissions: 145.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;

        while (true) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.next;
            } else {
                break;
            }
        }

        ListNode deleted = null;
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                return null;
            }
            deleted = stack.pop();
        }
        if (deleted != null) {
            if (stack.empty()) {//head deleted, new head
                return deleted.next;
            }
            stack.pop().next = deleted.next;
        }

        return head;
    }
}

