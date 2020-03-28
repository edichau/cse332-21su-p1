package tests.gitlab.ckpt1;

import cse332.interfaces.worklists.WorkList;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public abstract class WorklistGradingTests {
    protected static WorkList<String> STUDENT_STR;
    protected static WorkList<Double> STUDENT_DOUBLE;
    protected static WorkList<Integer> STUDENT_INT;

    @Test
    public void testHasWork() {
        assertFalse(STUDENT_INT.hasWork());
    }

    @Test
    public void testHasWorkAfterAdd() {
        STUDENT_INT.add(1);
        assertTrue(STUDENT_INT.hasWork());
    }

    @Test
    public void testHasWorkAfterAddRemove() {
        for (int i = 0; i < 1000; i++) {
            STUDENT_DOUBLE.add(Math.random());
        }
        for (int i = 0; i < 1000; i++) {
            STUDENT_DOUBLE.next();
        }
        assertFalse(STUDENT_DOUBLE.hasWork());
    }
    @Test
    public void testPeekHasException() {
        assertTrue(doesPeekThrowException(STUDENT_INT));

        addAndRemove(STUDENT_INT, 42, 10);
        assertTrue(doesPeekThrowException(STUDENT_INT));
    }

    @Test
    public void testNextHasException() {
        assertTrue(doesNextThrowException(STUDENT_INT));

        addAndRemove(STUDENT_INT, 42, 10);
        assertTrue(doesNextThrowException(STUDENT_INT));
    }
    @Test
    public void testClear() {
        addAll(STUDENT_STR, new String[]{"Beware", "the", "Jabberwock", "my", "son!"});

        assertTrue(STUDENT_STR.hasWork());
        assertTrue(STUDENT_STR.size() == 5);

        STUDENT_STR.clear();
        assertFalse(STUDENT_STR.hasWork());
        assertTrue(STUDENT_STR.size() == 0);
        assertTrue(doesPeekThrowException(STUDENT_STR));
        assertTrue(doesNextThrowException(STUDENT_STR));
    }

    // UTILITY METHODS

    protected static <E> void addAll(WorkList<E> worklist, E[] values) {
        for (E value : values) {
            worklist.add(value);
        }
    }

    protected static <E> void addAndRemove(WorkList<E> worklist, E value, int amount) {
        for (int i = 0; i < amount; i++) {
            worklist.add(value);
        }
        for (int i = 0; i < amount; i++) {
            worklist.next();
        }
    }

    protected static <E> boolean doesPeekThrowException(WorkList<E> worklist) {
        try {
            worklist.peek();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    protected static <E> boolean doesNextThrowException(WorkList<E> worklist) {
        try {
            worklist.next();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }
}
