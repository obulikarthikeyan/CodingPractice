package stack;

public class StackUsingArrays {

    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackTopPointer = {-1, -1, -1};

    void push(int stackNum, int item) throws Exception {
        if(stackTopPointer[stackNum] + 1 >= stackSize) {
            throw new Exception("Out of space");
        }

        stackTopPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = item;
    }

    int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception("Stack is empty");
        }
        int item = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackTopPointer[stackNum]--;
        return item;
    }

    int peek(int stackNum) {
        return buffer[absTopOfStack(stackNum)];
    }

    boolean isEmpty(int stackNum) {
        return stackTopPointer[stackNum] == -1;
    }

    private int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackTopPointer[stackNum];
    }
}
