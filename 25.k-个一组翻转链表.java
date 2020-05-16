/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (52.22%)
 * Likes:    215
 * Dislikes: 0
 * Total Accepted:    13K
 * Total Submissions: 24.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode res = null;
        ListNode last = null;
        boolean end = false;
        while (!end) {
            int i = 0;
            ListNode tmpHead = head;
            while (i < k) {
                stack.push(head);
                if (head == null) {
                    end = true;
                    break;
                }
                head = head.next;
                i++;
            }
            if (end) {
                if (res == null) {
                    res = tmpHead;
                } else {
                    last.next = tmpHead;
                }
            } else {
                if (res == null) {
                    res = stack.pop();
                    last = res;
                }
                while (!stack.isEmpty()) {
                    last.next = stack.pop();
                    last = last.next;
                }
            }
        }
        return res;
    }

}

