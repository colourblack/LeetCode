package another.num146;

public class LRUCache {

    private int capacity;
    private int count;
    private Item[] items;
    private int[] ages;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        ages = new int[this.capacity];
        items = new Item[this.capacity];
    }

    public int get(int key) {
        int i = 0;
        for (; i < count; i++) {
            if (items[i].getKey() == key) {
                refreshAge();
                ages[i] = 0;
                return items[i].getValue();
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        Item item = new Item();
        item.setKey(key);
        item.setValue(value);
        int i = 0;
        // 判断Cache是否已经存在数据
        for (; i < count; i++) {
            if (items[i].getKey() == key) {
                items[i] = item;
                this.refreshAge();
                ages[i] = 0;
                return ;
            }
        }

        // 若Cache没有填满
        if (count < capacity) {
            items[count] = item;
            count++;
        } else { // 若Cache已经填满
            int longer = this.getMaxAge(ages);
            items[longer] = item;
            this.refreshAge();
            ages[longer] = 0;
        }
    }

    private int getMaxAge(int[] arrays) {
        int Max = -1;
        int index = -1;
        for (int i = 0; i < this.capacity; i++) {
            if (arrays[i] > Max) {
                Max = arrays[i];
                index = i;
            }
        }
        return index;
    }

    private void refreshAge() {
        for (int i = 0; i < count; i++) {
            ages[i]++;
        }
    }
}
