package tests.gitlab.ckpt1;

import cse332.interfaces.worklists.WorkList;
import datastructures.worklists.ListFIFOQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListFIFOQueueTests extends WorklistGradingTests {

    @Before
    public void init() {
        STUDENT_STR = new ListFIFOQueue<>();
        STUDENT_DOUBLE = new ListFIFOQueue<>();
        STUDENT_INT = new ListFIFOQueue<>();
    }

    @Test
    public void checkStructure() {
        WorkList<Integer> queue = new ListFIFOQueue<>();

        // Fill
        for (int i = 0; i < 1000; i++) {
            queue.add(i);
            assertTrue(queue.peek() == 0);
            assertTrue(queue.hasWork());
            assertTrue(queue.size() == (i + 1));
        }

        // Empty
        for (int i = 0; i < 999; i++) {
            assertTrue(queue.hasWork());
            assertTrue(queue.peek() == i);
            assertTrue(queue.next() == i);
            assertTrue(queue.size() == 999 - i);
        }
    }
}
