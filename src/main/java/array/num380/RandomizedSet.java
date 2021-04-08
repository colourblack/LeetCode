package array.num380;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 *     insert(val)：当元素 val 不存在时，向集合中插入该项。
 *     remove(val)：元素 val 存在时，从集合中移除该项。
 *     getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/8/21 9:01 AM
 */
public class RandomizedSet {
    /**
     * 由于insert 和 remove 方法要在O(1)时间复杂度下完成， 因此需要一个哈希表
     * 但因为getRandom()方法也要在O(1)时间复杂度下完成， 而一个HashMap并不能够满足需要
     * 所以还需要维护一个动态数组list用于完成getRandom()的需求
     */
    Map<Integer, Integer> map ;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/*
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
