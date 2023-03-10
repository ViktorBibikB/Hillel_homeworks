package tests.mathactions;

import math.mathactions.ArrayActions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ArrayActionsTest {
    ArrayActions arrayActions;

    @BeforeEach
    void setUp() {
        arrayActions = new ArrayActions();
    }


    @Test
    void isArrayConsistsOf4And1_positiveTest() {
        int[] arr = {1, 4, 1, 4};
        assertTrue(arrayActions.isArrayConsistsOf4And1(arr));
    }

    @Test
    void isArrayConsistsOf4And1_negativeOnlyOneValues() {
        int[] arr = {1, 1, 1, 1};
        assertFalse(arrayActions.isArrayConsistsOf4And1(arr));
    }

    @Test
    void isArrayConsistsOf4And1_negativeOnlyFourValues() {
        int[] arr = {4, 4, 4, 4};
        assertFalse(arrayActions.isArrayConsistsOf4And1(arr));
    }

    @Test
    void isArrayConsistsOf4And1_negativeOneValueDifferFromOneOrFour() {
        int[] arr = {1, 1, 1, 1, 4, 3};
        assertFalse(arrayActions.isArrayConsistsOf4And1(arr));
    }

    @Test
    void getAllValesAfterLast4_positiveTest() {
        int[] arr = {4, 5, 7, 3, 4, 3, 21, 5};
        int[] actual = arrayActions.getAllValesAfterLast4(arr);
        int[] expected = {3, 21, 5};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getAllValesAfterLast4_fourDoesntExistExceptionTest() {
        int[] arr = {3, 5, 7, 2};
        assertThrows(RuntimeException.class, () -> arrayActions.getAllValesAfterLast4(arr));
    }

    @Test
    void getAllValesAfterLast4_emptyArrExceptionTest() {
        int[] arr = {};
        assertThrows(RuntimeException.class, () -> arrayActions.getAllValesAfterLast4(arr));
    }

    @Test
    void getAllValesAfterLast4_negativeEmptyArrTest() {
        int[] arr = {3, 5, 7, 2, 5, 3, 21, 4};
        int[] actual = arrayActions.getAllValesAfterLast4(arr);
        int[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
