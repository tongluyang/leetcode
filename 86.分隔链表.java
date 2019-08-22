/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (51.46%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 24.4K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {

        ListNode result = head;

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p2Pre = null;

        while (p2 != null) {
            if (p2.val < x) {
                if (p1 == null) {
                    p1 = p2;
                    if (p2Pre != null) {
                        p2Pre.next = p2.next;
                        p1.next = head;
                        p2 = p2Pre;
                    }
                    result = p1;
                } else {
                    if (p1 != p2Pre) {
                        ListNode tmp = p1.next;
                        p2Pre.next = p2.next;
                        p1.next = p2;

                        p2 = p2Pre;

                        p1 = p1.next;
                        p1.next = tmp;
                    } else {
                        p1 = p1.next;
                    }
                }
            }
            p2Pre = p2;
            p2 = p2.next;
        }
        return result;
    }
}

