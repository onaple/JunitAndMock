package chapter1.page7;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    public void add(int num) {
        stackPush.push(num);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is impty!");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.isEmpty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

}
