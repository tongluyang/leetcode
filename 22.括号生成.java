/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (70.47%)
 * Likes:    406
 * Dislikes: 0
 * Total Accepted:    26K
 * Total Submissions: 36.9K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<Integer>> integers = new ArrayList<>();
        split(integers, new ArrayList<>(), n);
        return integers.stream().map(this::list2Str).collect(Collectors.toList());
    }

    public void split(List<List<Integer>> lists, List<Integer> initList, int n) {
        for (int a = 0; a < n; a++) {
            List<Integer> list = new ArrayList<>(initList);
            int b = n - a;

            if (a > 1) {
                List<Integer> newList = new ArrayList<>(initList);
                newList.add(b);

                for (int i = 1; i <= newList.stream().reduce(0, Math::addExact); i++) {
                    newList.add(-i);
                    split(lists, newList, a);
                    newList.remove(newList.size() - 1);
                }

            } else {
                if (b > 0) {
                    list.add(b);

                    if (a > 0) {
                        for (int i = 1; i <= (list.stream().reduce(0, Math::addExact)); i++) {
                            ArrayList<Integer> tmpList = new ArrayList<>(list);
                            tmpList.add(-i);
                            tmpList.add(a);
                            tmpList.add(-(tmpList.stream().reduce(0, Math::addExact)));
                            lists.add(tmpList);
                        }
                    } else {
                        list.add(-(list.stream().reduce(0, Math::addExact)));
                        lists.add(list);
                    }

                }

            }
        }
    }

    public String list2Str(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            if (integer > 0) {
                for (Integer i = 0; i < integer; i++) {
                    sb.append("(");
                }
            } else {
                for (int i = 0; i < Math.abs(integer); i++) {
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }
}

