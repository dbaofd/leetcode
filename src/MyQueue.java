import java.util.Stack;

/**
 * Created by dbaofd on 2020/12/25.
 */
public class MyQueue {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
//    Memory Usage: 36.5 MB, less than 94.34% of Java online submissions for Implement Queue using Stacks.
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private boolean isLastOperationPeekPop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        isLastOperationPeekPop = false;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (isLastOperationPeekPop) {
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                s1.push(x);
            } else if (!s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s2.push(x);
            }
        } else {
            if (s1.isEmpty() && s2.empty()) {
                s1.push(x);
            } else if (!s1.isEmpty()) {
                s1.push(x);
            } else if (!s2.isEmpty()) {
                s2.push(x);
            }
        }
        isLastOperationPeekPop = false;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int ele = 0;
        if (isLastOperationPeekPop) {
            if (!s1.isEmpty()) {
                ele = s1.pop();
            } else if (!s2.isEmpty()) {
                ele = s2.pop();
            }
        } else {
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                ele = s1.pop();
            } else if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                ele = s2.pop();
            }
        }
        isLastOperationPeekPop = true;
        return ele;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int ele = 0;
        if (isLastOperationPeekPop) {
            if (!s1.isEmpty()) {
                ele = s1.peek();
            } else if (!s2.isEmpty()) {
                ele = s2.peek();
            }
        } else {
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                ele = s1.peek();
            } else if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                ele = s2.peek();
            }
        }
        isLastOperationPeekPop = true;
        return ele;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }
}
