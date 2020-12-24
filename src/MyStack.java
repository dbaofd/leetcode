import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dbaofd on 2020/12/24.
 */
public class MyStack {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
//    Memory Usage: 36.7 MB, less than 65.97% of Java online submissions for Implement Stack using Queues.
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q1.size() == 0 && q2.size() == 0) {
            q1.add(x);
        } else if (q1.size() == 0) {
            q2.add(x);
        } else {
            q1.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int ele = 0;
        if (q1.size() != 0) {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            ele = q1.poll();
        } else if (q2.size() != 0) {
            while (q2.size() != 1) {
                q1.add(q2.poll());
            }
            ele = q2.poll();
        }
        return ele;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int top = 0;
        if (q1.size() != 0) {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            top = q1.peek();
            q2.add(q1.poll());
        } else if (q2.size() != 0) {
            while (q2.size() != 1) {
                q1.add(q2.poll());
            }
            top = q2.peek();
            q1.add(q2.poll());
        }
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if (q1.size() == 0 && q2.size() == 0)
            return true;
        return false;
    }
}
