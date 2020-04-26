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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode res = null;
        ListNode last = null;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            if (res == null) {
                res = min;
            } else {
                last.next = min;
            }
            last = min;
            if (min.next != null) {
                queue.add(min.next);
            }
        }
        return res;
    }
}

