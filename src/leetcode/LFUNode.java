package leetcode;

import java.util.LinkedHashSet;

public class LFUNode {

    int count;
    LinkedHashSet<Integer> keys;
    LFUNode prev, next;

    public LFUNode(int count) {
        this.count = count;
        this.keys = new LinkedHashSet<>();
        this.prev = this.next = null;
    }

}
