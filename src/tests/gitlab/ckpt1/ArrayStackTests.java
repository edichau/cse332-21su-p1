package tests.gitlab.ckpt1;

import cse332.interfaces.worklists.WorkList;
import datastructures.worklists.ArrayStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTests extends WorklistGradingTests {

    @Before
    public void init() {
        STUDENT_STR = new ArrayStack<>();
        STUDENT_DOUBLE = new ArrayStack<>();
        STUDENT_INT = new ArrayStack<>();
    }

    @Test
    public void checkStructure() {
        WorkList<Integer> stack = new ArrayStack<>();

        // Fill
        for (int i = 0; i < 1000; i++) {
            stack.add(i);
            assertTrue(stack.peek() == i);
            assertTrue(stack.hasWork());
            assertTrue(stack.size() == (i + 1));
        }

        // Empty
        for (int i = 999; i >= 0; i--) {
            assertTrue(stack.hasWork());
            assertTrue (stack.peek() == i);
            assertTrue (stack.next() == i);
            assertTrue (stack.size() == i);
        }
    }
}
