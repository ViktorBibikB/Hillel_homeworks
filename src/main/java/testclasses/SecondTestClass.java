package testclasses;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class SecondTestClass {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("Method with annotation @BeforeSuit was ran.");
    }

    @BeforeSuite
    public void beforeMethod_1(){
        System.out.println("Method with annotation @BeforeSuit was ran.");
    }

    @Test(priority = 1)
    public void test_1(){
        System.out.println("Method with annotation @Test and priority 1 was ran. " + (int) (Math.random() * 10));
    }

    @Test(priority = 3)
    public void test_2(){
        System.out.println("Method with annotation @Test and priority 3 was ran. " + (int) (Math.random() * 10));
    }

    @Test(priority = 2)
    public void test_3(){
        System.out.println("Method with annotation @Test and priority 2 was ran. " + (int) (Math.random() * 10));
    }

    @AfterSuite
    public void afterMethod(){
        System.out.println("Method with annotation @AfterSuite was ran.");
    }
}
