package another.num622;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FANG
 * 循环队列的设计与实现
 */
public class MyCircularQueue {

    private List<Integer> list;
    private int head;
    private int tail;
    private int length;

    public MyCircularQueue (int len) {
        if (len <= 0) {
            System.out.println("非法长度");
        }
        length = len;
        head = -1;
        tail = -1;
        list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(-1);
        }
    }

    /**
     * 获取队首元素 head
     * 如果队列为空，则返回-1
     * @return
     */
    public int Front () {
        if (isEmpty()) {
            return -1;
        }
        return list.get(head);
    }

    /**
     * 获取队尾元素 tail
     * 如果队列为空，则返回-1
     * @return
     */
    public int Rear () {
        if (isEmpty()) {
            return -1;
        }
        return list.get(tail);
    }

    /**
     * 向队列添加元素
     * 如果队列已满，则添加失败
     * @param value
     * @return
     */
    public boolean enQueue (int value) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("The queue is full");
            return false;
        }

        if (tail == length-1) {
            tail = 0;
        } else {
            tail++;
        }

        if (head == -1) {
            head = 0;
        }

        list.set(tail, value);
        System.out.println(list);
        return true;
    }

    /**
     * 删除队列元素
     * 使用采用先进先出策略
     * @return
     */
    public boolean deQueue () {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return false;
    }

        list.set(head, -1);

        if (head == length - 1) {
            head = 0;
        } else {
            head++;
        }

        System.out.println(list);
        return true;
    }

    public boolean isEmpty () {
        boolean flag = true;
        for (Integer integer : list) {
            if (integer != -1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isFull () {
        int index = -1;
        for (Integer integer : list) {
            if (integer != -1) {
                index++;
            }
        }
        if (index == length -1) {
            return true;
        } else {
            return false;
        }
    }
}
