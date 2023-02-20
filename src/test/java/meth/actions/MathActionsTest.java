package meth.actions;

import math.actions.MathActions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathActionsTest {
    static MathActions mathActions;

    @BeforeAll
    public static void setUp(){
        mathActions = new MathActions();
    }

    @Test
    public void multiply_success(){
        int a = 10;
        int b = 2;

        int actual = mathActions.multiply(a, b);
        int expected = 20;

        assertEquals(expected, actual);
    }

    @Test
    public void divide_success(){
        double a = 10;
        double b = 2;

        double actual = mathActions.divide(a, b);
        double expected = 5;

        assertEquals(expected, actual);
    }
}
