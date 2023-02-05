

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;
import myexception.IncorrectNumberOfSuitesException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
    private static int counterBeforeSuit;
    private static int counterAfterSuit;
    private static final int MAX_COUNT = 1;
    private static Queue<Method> methodNames = new LinkedList<>();
    private static Object object;
    private static Method[] allMethods;

    public static void start(Class<?> type) {
        try{
            object = type.getDeclaredConstructor().newInstance();
            allMethods = type.getDeclaredMethods();

            for (Method method : allMethods) {
                Annotation[] annotations = method.getDeclaredAnnotations();

                if (countBeforeSuiteAnnotations(annotations) > MAX_COUNT)
                    throw new IncorrectNumberOfSuitesException("\"Before suite\" annotated methods count should be equal to 1.");
                else if (countAfterSuiteAnnotations(annotations) > MAX_COUNT)
                    throw new IncorrectNumberOfSuitesException("\"Before suite\" annotated methods count should be equal to 1.");
            }

            runMethodByAnnotation(type, BeforeSuite.class);
            runMethodByAnnotation(type, Test.class);
            runMethodByAnnotation(type, AfterSuite.class);

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();;
        } catch (IncorrectNumberOfSuitesException e) {
            e.getMessage();
            e.printStackTrace();
        }

    }

    private static int countBeforeSuiteAnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof BeforeSuite)
                ++counterBeforeSuit;
        }
        return counterBeforeSuit;
    }

    private static int countAfterSuiteAnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof AfterSuite)
                ++counterAfterSuit;
        }
        return counterAfterSuit;
    }

    private static void runMethodByAnnotation(Class<?> type, Class<? extends Annotation> annotation) {
        try{
            object = type.getDeclaredConstructor().newInstance();
            for(Method method: allMethods){
                if(method.isAnnotationPresent(annotation))
                    method.invoke(object);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
