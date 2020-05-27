/*
 * @lc app=leetcode.cn id=381 lang=java
 *
 * [381] O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 *
 * algorithms
 * Hard (37.12%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    2.7K
 * Total Submissions: 7.3K
 * Testcase Example:  '["RandomizedCollection","insert","insert","insert","getRandom","remove","getRandom"]\n[[],[1],[1],[2],[],[1],[]]'
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * 
 * 注意: 允许出现重复元素。
 * 
 * 
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 
 * 
 * 示例:
 * 
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * 
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * 
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * 
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * 
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * 
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * 
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 * 
 * 
 */

// @lc code=start
class RandomizedCollection {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean notExists = true;
        if (map.containsKey(val)) {
            notExists = false;
        } else {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return notExists;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val) && map.get(val).size() > 0) {
            Set<Integer> indexes = map.get(val);//待删除数据的索引集合
            int removeIdx = indexes.iterator().next();//拿一个准备删除
            Integer last = list.get(list.size() - 1);//列表最后一个元素
            list.set(removeIdx, last);//列表最后一个元素放到被删除的位置
            list.remove(list.size() - 1);//删除最后一个元素
            indexes.remove(removeIdx);//删除被删除元素的索引
            map.get(last).add(removeIdx);//原来最后的元素被移动，新位置加入索引
            map.get(last).remove(list.size());//原来在最后一个位置的元素被移动，索引删除
            return true;
        }
        return false;
    }
    
    Random random = new Random();
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

