package chapter1.page3;

import java.util.Stack;

public class Mystack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack2() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        return stackMin.peek();
    }

    public void push(int num){
        if (stackMin.isEmpty()){
            stackMin.push(num);
        }
        if(stackMin.peek() > num){
            stackMin.push(num);
        } else {
            stackMin.push(stackMin.peek());
        }
        stackData.push(num);
    }

    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }
}
