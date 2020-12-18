package com.payment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/18 15:19
 */
@RunWith(SpringRunner.class)
public class QueueTest {

    @Test
    public void testMyQueue() {
        MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.pop());
    }

}

class MyQueue {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void push(int node) {
        pushStack.push(node);
    }

    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.isEmpty()) {
            return -1;
        } else {
            return popStack.pop();
        }
    }

}
