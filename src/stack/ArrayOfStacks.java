package stack;

import java.util.ArrayList;

public class ArrayOfStacks {
    ArrayList<Stack> stacks;

    public ArrayOfStacks() {
        stacks = new ArrayList<>();
    }

    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(value);
        } else {
            Stack newStack = new Stack();
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if(last != null) {
            int value = (int) last.pop();
            if (last.isEmpty()) {
                stacks.remove(last);
            }
            return value;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int popAt(int stackPointer) {

    }

    private Stack getLastStack() {
        if(stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }
}
