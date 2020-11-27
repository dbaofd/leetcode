import java.util.Stack;

/**
 * Created by dbaofd on 2020/11/27.
 */
public class MinStack {
//    Runtime: 4 ms, faster than 93.45% of Java online submissions for Min Stack.
//    Memory Usage: 40.8 MB, less than 37.38% of Java online submissions for Min Stack.
    private Stack<Integer> minItemStack;//min item state, the state will be updated after push and pop operations.
    private Stack<Integer> myStack;

    public MinStack() {
        minItemStack = new Stack<>();
        myStack = new Stack<>();
    }

    public void push(int x) {
        if (myStack.isEmpty()) {
            minItemStack.push(x);
            myStack.push(x);
        } else {
            if (x < minItemStack.peek()) {
                minItemStack.push(x);
            } else {
                minItemStack.push(minItemStack.peek());
            }
            myStack.push(x);
        }
    }

    public void pop() {
        myStack.pop();
        minItemStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minItemStack.peek();
    }
}
