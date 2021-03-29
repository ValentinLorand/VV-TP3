package binaryHeap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
class BinaryHeapTest {

    static BinaryHeap<Integer> bh;

    @BeforeEach
    public void init() {
        bh = new BinaryHeap<>(new IntComparator());
    }
    @Test
    void testPushAndCount() {
        assertEquals(bh.count(), 0);
        bh.push(1);
        assertEquals(bh.count(), 1);
        bh.push(1);
        assertEquals(bh.count(), 2);
        bh.push(4);
        assertEquals(bh.count(), 3);
    }

    @Test
    void testPeek() {
        bh.push(1);
        int result = bh.peek();
        assertEquals(result, 1);
        assertEquals(bh.count(), 1);
    }

    @Test
    void testPeek2() {
        bh.push(1);
        bh.push(3);
        bh.push(5);
        bh.push(7);
        int result = bh.peek();
        assertEquals(result, 1);
        assertEquals(bh.count(), 4);
    }

    @Test
    void testPop() {
        bh.push(1);
        int result = bh.pop();
        assertEquals(result, 1);
        assertEquals(bh.count(), 0);
    }

    @Test
    void testPop2() {
        bh.push(7);
        bh.push(5);
        bh.push(3);
        bh.push(2);
        int result = bh.pop();
        assertEquals(result, 2);
        assertEquals(bh.count(), 3);
    }

}
