package chapter1.page3;

import java.util.Stack;

public class Mystack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("satck is empty!");
        }
        return this.stackMin.peek();
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()) {
            this.stackMin.pop();
        }
        int i = 1 / 0;
        return value;
    }
}
