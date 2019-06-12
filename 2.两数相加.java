/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (34.34%)
 * Likes:    2496
 * Dislikes: 0
 * Total Accepted:    138.1K
 * Total Submissions: 402.2K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
import java.math.BigDecimal;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return buildListNode(parseListNode(l1).add(parseListNode(l2)));
    }

    public BigDecimal parseListNode(ListNode listNode) {
        BigDecimal num = new BigDecimal(0);
        int i = 0;
        do {
            num = num.add(new BigDecimal(listNode.val).movePointRight(i++));
            listNode = listNode.next;
        } while (listNode != null);
        return num;
    }

    public ListNode buildListNode(BigDecimal num) {
        return buildSingleListNode(num, (num + "").length() - 1);
    }

    public ListNode buildSingleListNode(BigDecimal num, int at) {
        if (at <= -1) {
            return null;
        }
        int val = (num + "").charAt(at) - 48;
        ListNode listNode = new ListNode(val);
        listNode.next = buildSingleListNode(num, at - 1);
        return listNode;
    }

}

