import java.io.*;
import java.util.*;
/**
 * Handin done by:
 *   Freja Østerbøg, 201809189
 *   Carl Ulsøe, 201906950
 * 
 * Contributions:
 *   This exersice was discussed together and written by Carl
 */
public class ReversePolishCalculator {
    // Add any private fields you might need here
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    public void push(int n) {
        stack.push(n);
    }

    public void plus() {
        if (!stack.isEmpty()) {
            stack.push(stack.pop() + stack.pop());
        }
    }

    public void minus() {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            stack.push(stack.pop() - top);
        }
    }

    public void times() {
        stack.push(stack.pop() * stack.pop());
    }

    public int read() {
        return stack.peek();
    }
}