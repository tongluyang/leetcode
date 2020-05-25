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
class LRUCache {

    DLink dlink;
    public LRUCache(int capacity) {
        dlink = new DLink(capacity);
    }
    
    public int get(int key) {
        return dlink.get(key);
    }
    
    public void put(int key, int value) {
        dlink.put(key, value);
    }
    
    private static class DLink {
        int size;
        Node head = null;
        Node last = null;
        Map<Integer, Node> map = new HashMap<>();
        public DLink(int size) {
            this.size = size;
        }
        
        private int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            int res = node.val;
            moveNodeToHead(node);
            return res;
        }
        
        private void moveNodeToHead(Node node) {
            if (head == node) {
                return;
            }
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            if (next == null) {
                last = pre;
            } else {
                next.pre = pre;
            }
            insertHead(node);
        }
        
        private void put(int key, int value) {
            //有则更新
            Node node = map.get(key);
            if (node != null) {
                node.val = value;
                moveNodeToHead(node);
                return;
            }
            //无则插入
            if (map.size() >= size) {//插入前先删掉最老的
                removeLast();
            }
            node = new Node(key, value);
            insertHead(node);
        }
        
        private void insertHead(Node node) {
            node.next = head;
            node.pre = null;
            if (head != null) {
                head.pre = node;
            } else {//head == null，说明是第一个，同时也是最后一个
                last = node;
            }
            head = node;
            map.put(node.key, node);
        }
        
        private void removeLast() {
            map.remove(last.key);
            Node newLast = last.pre;
            if (newLast == null) {//最后一个被干掉，head也没了
                head = null;
            } else {
                newLast.next = null;
            }
            last = newLast;
        }
    }
    
    private static class Node {
        Node pre = null;
        Node next = null;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
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

