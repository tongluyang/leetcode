/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (46.33%)
 * Likes:    257
 * Dislikes: 0
 * Total Accepted:    27.3K
 * Total Submissions: 58.6K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        for (ListNode list : lists) {
            if (node == null) {
                node = list;
                continue;
            }

            ListNode next = node;
            while (list != null) {
                while (true) {
                    if (next.val > list.val) {
                        ListNode listNode = new ListNode(list.val);
                        listNode.next = node;
                        node = listNode;
                        list = list.next;
                        next = node;
                        break;
                    } else if (next.val <= list.val && (next.next == null || next.next.val > list.val)) {
                        ListNode tmp = next.next;
                        next.next = new ListNode(list.val);
                        next.next.next = tmp;
                        list = list.next;
                        break;
                    } else {
                        next = next.next;
                    }
                }

            }
        }
        return node;
    }
}

