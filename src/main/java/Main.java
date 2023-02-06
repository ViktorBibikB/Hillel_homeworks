import testclasses.FirstTestClass;
import testclasses.SecondTestClass;
import testclasses.ThirdTestClass;


public class Main {
    public static void main(String[] args) {
        Class<FirstTestClass> getFirstClass = FirstTestClass.class;
        Class<SecondTestClass> getSecondClass = SecondTestClass.class;
        Class<ThirdTestClass> getThirdClass = ThirdTestClass.class;

        TestRunner.start(getFirstClass);
//        TestRunner.start(getSecondClass);
//        TestRunner.start(getThirdClass);

    }
}
