package tests.gitlab.ckpt1;

import cse332.interfaces.worklists.FixedSizeFIFOWorkList;
import cse332.interfaces.worklists.WorkList;
import datastructures.worklists.CircularArrayFIFOQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularArrayFIFOQueueTests extends WorklistGradingTests {
    public static final int DEFAULT_CAPACITY = 1000;

    @Before
    public void init() {
        STUDENT_STR = new CircularArrayFIFOQueue<>(DEFAULT_CAPACITY);
        STUDENT_DOUBLE = new CircularArrayFIFOQueue<>(DEFAULT_CAPACITY);
        STUDENT_INT = new CircularArrayFIFOQueue<>(100000);
    }

    @Test(timeout = 3000)
    public void testClear() {
        FixedSizeFIFOWorkList<String> queue = new CircularArrayFIFOQueue<>(5);
        addAll(queue, new String[] {"Beware", "the", "Jabberwock", "my", "son!"});
        assertTrue(queue.hasWork());
        assertTrue(queue.size() == 5);
        assertTrue(queue.isFull());
        assertTrue(queue.capacity() == 5);

        queue.clear();

        assertFalse(queue.hasWork());
        assertTrue(queue.size() == 0);
        assertFalse(queue.isFull());
        assertTrue(queue.capacity() == 5);
        assertTrue(doesPeekThrowException(queue));
        assertTrue(doesNextThrowException(queue));
    }

    @Test(timeout = 3000)
    public void testUpdate() {
        FixedSizeFIFOWorkList<Integer> queue = new CircularArrayFIFOQueue<>(10);

        for (int i = 0; i < 8; i++) {
            queue.add(i);
            assertTrue(queue.size() == i + 1);
        }

        for (int i = 0; i < 8; i++) {
            assertTrue(queue.peek(i) == i);
        }

        assertTrue(queue.size() == 8);
        assertFalse(queue.size() != 8 && !queue.isFull());

        for (int i = 0; i < 8; i += 2) {
            queue.update(i, -i);
        }

        for (int i = 0; i < 8; i++) {
            int expected = i * ((i % 2 == 0) ? -1 : 1);
            assertTrue(queue.peek(i) == expected);

        }

        assertTrue(queue.size() == 8);

        for (int i = 0; i < 8; i++) {
            int expected = i * ((i % 2 == 0) ? -1 : 1);
            assertTrue(queue.peek() == expected);
            assertTrue(queue.next() == expected);

        }
        assertTrue(queue.size() == 0);
    }

    @Test(timeout = 3000)
    public void testCycle() {
        testCycle(1);
        testCycle(2);
        testCycle(9);
        testCycle(10);
    }


    private void testCycle(int capacity) {
        FixedSizeFIFOWorkList<Integer> queue = new CircularArrayFIFOQueue<>(capacity);

        for (int i = 0; i < capacity; i++) {
            queue.add(i);
            assertTrue(queue.size() == i + 1);
        }

        assertTrue(queue.hasWork());
        assertTrue(queue.isFull());

        for (int i = capacity; i < 100000; i++) {
            assertTrue(queue.peek() == (i - capacity));
            assertTrue(queue.next() == (i - capacity));
            assertTrue(!queue.isFull());
            queue.add(i);
            assertTrue(queue.size() == capacity);
            assertTrue(queue.isFull());
        }
    }

    @Test(timeout = 3000)
    public void checkStructure() {
        FixedSizeFIFOWorkList<Integer> queue = new CircularArrayFIFOQueue<>(1000);

        // Fill
        for (int i = 0; i < 1000; i++) {
            assertTrue(!queue.isFull());
            queue.add(i);
            assertTrue(queue.peek() == 0 && queue.peek(0) == 0);
            assertTrue(queue.peek(i) == i);
            assertTrue(queue.hasWork());
            assertTrue(queue.size() == (i + 1));
        }
        assertTrue(queue.size() == 1000);
        assertTrue(queue.isFull());

        try {
            queue.add(2000);
            assertTrue(false);
        } catch (IllegalStateException ex) {
            // Queue throws correct exception when full; move on
        }

        // Check peek
        for (int i = 0; i < 1000; i++) {
            assertTrue(queue.peek(i) == i);
        }

        // Empty
        for (int i = 0; i < 999; i++) {
            assertTrue(queue.hasWork());
            assertTrue(queue.peek() == i && queue.peek(0) == i);
            assertTrue(queue.next() == i);
            assertTrue(queue.size() == 999 - i);
            assertTrue(!queue.isFull());
        }
    }
}
