package stack;

public class StackMin extends Stack {

    Stack stackMin;

    public StackMin() {
        stackMin = new Stack();
    }

    void push(int value) {
        if(value <= min()) {
            stackMin.push(value);
        }
        super.push(value);
    }

    int min() {
        if (stackMin.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return (int) stackMin.peek();
    }

    Object pop() {
        int value = (int) super.pop();
        if(value <= min()) {
            stackMin.pop();
        }
        return value;
    }

    private static StackMin setUp() {
        StackMin myStack = new StackMin();
        myStack.push(10);
        myStack.push(40);
        myStack.push(20);
        myStack.push(70);
        myStack.push(0);
        return myStack;
    }

    public static void main(String ...args) {
        StackMin stackMin = setUp();
        System.out.println("Initial Stack");
        Stack.printStack(stackMin);
        System.out.println("\nMin = " + stackMin.min());

        System.out.println("\nPushing 5");
        stackMin.push(5);
        System.out.println("Min = " + stackMin.min());

        System.out.println("\nPushing -5");
        stackMin.push(-5);
        System.out.println("Min = " + stackMin.min());

        System.out.println("\nPopping " + stackMin.pop());
        System.out.println("Min = " + stackMin.min());

        System.out.println("\nPopping " + stackMin.pop());
        System.out.println("Min = " + stackMin.min());

        System.out.println("\nPopping " + stackMin.pop());
        System.out.println("Min = " + stackMin.min());

    }
}
