/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU缓存
 *
 * https://leetcode-cn.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (33.75%)
 * Likes:    157
 * Dislikes: 0
 * Total Accepted:    8.2K
 * Total Submissions: 21.3K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * 
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) -
 * 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * 
 * 一个项目的使用次数就是该项目被插入后对其调用 get 和 put 函数的次数之和。使用次数会在对应项目被移除后置为 0。
 * 
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * 
 * 示例：
 * 
 * LFUCache cache = new LFUCache( 2 ); // capacity (缓存容量)
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回 1
 * cache.put(3, 3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4, 4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 * 
 */

// @lc code=start
class LFUCache {
    int capacity;
    Map<Integer, Node> keyMap = new HashMap<>();
    Map<Integer, DLink> countMap = new HashMap<>();
    DLink leastAccess;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        int accessCount = node.dlink.accessCount;
        node.remove();
        DLink dlink = countMap.computeIfAbsent(accessCount + 1, DLink::new);
        if (node.pre == null && node.next == null && leastAccess.accessCount == accessCount) {
            leastAccess = dlink;
        }
        dlink.insertHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyMap.get(key) != null) {//存在已有的
            get(key);
            keyMap.get(key).val = value;
            return;
        }
        if (keyMap.size() >= capacity) {
            keyMap.remove(leastAccess.tail.key);
            leastAccess.tail.remove();
        }
        Node node = new Node();
        node.key = key;
        node.val = value;

        DLink dlink = countMap.computeIfAbsent(1, DLink::new);
        dlink.insertHead(node);
        leastAccess = dlink;
        keyMap.put(key, node);
    }

    private static class DLink {
        Node head;
        Node tail;
        int accessCount;

        DLink(int accessCount) {
            this.accessCount = accessCount;
        }

        void insertHead(Node node) {
            node.dlink = this;
            node.pre = null;
            node.next = node.dlink.head;
            if (node.dlink.head != null) {
                node.dlink.head.pre = node;
            } else {//head null，表示原来dlink是空的，新插入的也是tail
                node.dlink.tail = node;
            }
            node.dlink.head = node;
        }
    }

    private static class Node {
        int key;
        int val;
        DLink dlink;
        Node pre;
        Node next;

        void remove() {
            if (pre == null) {//head
                dlink.head = next;
                if (next != null) {
                    next.pre = null;
                } else {//next null，只剩一个，head也就是tail
                    dlink.tail = null;
                }
            } else {
                pre.next = next;
                if (next == null) {
                    dlink.tail = pre;
                } else {
                    next.pre = pre;
                }
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

