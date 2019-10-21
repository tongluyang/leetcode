/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (42.39%)
 * Likes:    270
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 46.7K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 ); // 缓存容量 
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start
public class LRUCache {
    int capacity;
    DLink dLink = new DLink();
    Map<Integer, Node> map = new HashMap<>();

    public static class DLink {
        Node head;
        Node tail;

        public void moveToHead(Node node) {
            if (head == node) {
                return;
            }
            Node newTail;
            if (tail == node) {
                newTail = tail.prev;
            } else {
                newTail = tail;
            }
            Node before = node.prev;
            Node after = node.next;

            Node newHead = node;
            Node oldHead = head;

            before.next = after;
            if (after != null) {
                after.prev = before;
            }

            head = newHead;
            head.prev = null;
            head.next = oldHead;
            oldHead.prev = newHead;

            tail = newTail;
            tail.next = null;
        }

        public void insertToHead(Node node) {
            if (head != null) {
                head.prev = node;
                node.next = head;
            } else {
                tail = node;
            }
            head = node;
        }

        public Node removeTail() {
            if (tail == null) {
                return null;
            }
            Node deleted = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            return deleted;
        }
    }

    public static class Node {
        Node prev;
        Node next;
        int k;
        int v;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        dLink.moveToHead(node);
        return node.v;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.v = value;
            dLink.moveToHead(node);
            return;
        }
        node = new Node();
        node.k = key;
        node.v = value;
        map.put(key, node);
        dLink.insertToHead(node);

        if (map.size() > capacity) {
            Node deleted = dLink.removeTail();
            if (deleted != null) {
                map.remove(deleted.k);
            }
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

