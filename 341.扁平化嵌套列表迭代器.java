/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 *
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/description/
 *
 * algorithms
 * Medium (63.30%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    8K
 * Total Submissions: 12.6K
 * Testcase Example:  '[[1,1],2,[1,1]]'
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 
 * 示例 2:
 * 
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * 
 * 
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    Integer next = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
        this.next = getNext();
    }

    private Integer getNext() {
        clearStack();
        if (stack.isEmpty()) {
            return null;
        }
        NestedInteger ni = stack.peek().next();
        while (!ni.isInteger()) {//如果是个列表，继续往下找
            Iterator<NestedInteger> it = ni.getList().iterator();
            stack.push(it);
            clearStack();
            if (stack.isEmpty()) {
                return null;
            }
            ni = stack.peek().next();
        }
        return ni.getInteger();
    }

    private void clearStack() {
        while (!stack.isEmpty() && !stack.peek().hasNext()) {
            stack.pop();
        }
    }

    @Override
    public Integer next() {
        Integer n = this.next;
        this.next = getNext();
        return n;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

