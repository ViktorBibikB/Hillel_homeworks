package tests.mathactions;

import math.mathactions.SimpleMathLibrary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {
    SimpleMathLibrary simpleMathLibrary;

    @BeforeEach
    public void setUp(){
        simpleMathLibrary = new SimpleMathLibrary();
    }

    @Test
    public void add_success(){
        double actual = simpleMathLibrary.add(3, 7);
        double expected = 10;

        if(actual == expected)
            System.out.println("OK.");
        else
            System.out.println("Not OK.");

    }

    @Test
    public void minus_success(){
        double actual = simpleMathLibrary.minus(3, 7);
        double expected = -4;

        if(actual == expected)
            System.out.println("OK.");
        else
            System.out.println("Not OK.");

    }
}
