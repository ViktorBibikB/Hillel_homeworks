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
        double a = 10;
        double b = 2;

        double actual = mathActions.multiply(a, b);
        double expected = 20;

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

    @Test
    public void subtract_success(){
        double a = 10;
        double b = 2;

        double actual = mathActions.subtract(a, b);
        double expected = 8;

        assertEquals(expected, actual);
    }

    @Test
    public void sum_success(){
        double a = 10;
        double b = 2;

        double actual = mathActions.sum(a, b);
        double expected = 12;

        assertEquals(expected, actual);
    }

    @Test
    public void max_success(){
        Double[] arr = {1.0, 5.5, 45.8, 32.5, 5.4, 76.1, 4.8, -154.8};

        double actual = mathActions.max(arr);
        double expected = 76.1;

        assertEquals(expected, actual);
    }

    @Test
    public void min_success(){
        Double[] arr = {17.8, 5.5, 45.8, 32.5, 5.4, 76.1, 4.8, -154.8};

        double actual = mathActions.min(arr);
        double expected = -154.8;

        assertEquals(expected, actual);
    }
}
