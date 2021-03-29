package fr.istic.vv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class BalancedStringTest {

    @Test
    void testEmptyStr() {
        Boolean result = BalancedString.isBalanced("");
        assertTrue(result);
    }

    @Test
    void testSimpleTrue() {
        Boolean result = BalancedString.isBalanced("{}");
        assertTrue(result);
    }

    @Test
    void testSimpleNull() {
        Boolean result = BalancedString.isBalanced("( ");
        assertNull(result);
    }

    @Test
    void testTrue() {
        Boolean result = BalancedString.isBalanced("{lavieestbelle}");
        assertTrue(result);
    }

    @Test
    void testNull() {
        Boolean result = BalancedString.isBalanced("{[())]}");
        assertNull(result);
    }

    @Test
    void testHook() {
        Boolean result = BalancedString.isBalanced("[[[[]]]]");
        assertTrue(result);
    }
}
