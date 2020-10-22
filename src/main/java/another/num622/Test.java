package another.num622;

public class Test {
    public static void main(String[] args) {
        // 设置长度为 3
        MyCircularQueue circularQueue = new MyCircularQueue(2);

        System.out.println(circularQueue.enQueue(4));

        System.out.println(circularQueue.Rear());

        System.out.println(circularQueue.enQueue(9));

        System.out.println(circularQueue.deQueue());

        System.out.println(circularQueue.Front());

        System.out.println(circularQueue.deQueue());

        System.out.println(circularQueue.deQueue());

        System.out.println(circularQueue.isEmpty());

        System.out.println(circularQueue.deQueue());

        System.out.println(circularQueue.enQueue(6));

        System.out.println(circularQueue.enQueue(4));

        System.out.println(circularQueue.Front());

        System.out.println(circularQueue.Rear());

    }
}
