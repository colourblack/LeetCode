package another.num752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        queue.add(null);

        Set<String> seen = new HashSet<>();
        seen.add("0000");

        int depth = 0;

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                depth++;
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)){
                for (int i = 0; i < 4; i++) {
                    for (int x = -1; x < 2; x += 2) {
                        //char转int可以直接使用 (char - '0')
                        int index = ((node.charAt(i) - '0') + x + 10) % 10;
                        //int转String可以直接加 ""
                        String string = node.substring(0, i) + (index + "") + node.substring(i + 1);
                        if (!seen.contains(string)) {
                            seen.add(string);
                            queue.offer(string);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
