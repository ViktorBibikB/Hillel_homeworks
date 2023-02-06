

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;
import myexception.IncorrectNumberOfSuitesException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TestRunner {
    private static int counterBeforeSuit;
    private static int counterAfterSuit;
    private static final int MAX_COUNT = 1;
    private static Queue<Method> methodNames = new LinkedList<>();
    private static Object object;
    private static Method[] allMethods;

    public static void start(Class<?> type) {
        try {
            object = type.getDeclaredConstructor().newInstance();
            allMethods = type.getDeclaredMethods();

            for (Method method : allMethods) {
                Annotation[] annotations = method.getDeclaredAnnotations();

                if (countBeforeSuiteAnnotations(annotations) > MAX_COUNT)
                    throw new IncorrectNumberOfSuitesException("\"Before suite\" annotated methods count should be equal to 1.");
                else if (countAfterSuiteAnnotations(annotations) > MAX_COUNT)
                    throw new IncorrectNumberOfSuitesException("\"Before suite\" annotated methods count should be equal to 1.");
            }

            runMethodByAnnotation(object, BeforeSuite.class);
            runMethodByAnnotation(object, Test.class);
            runMethodByAnnotation(object, AfterSuite.class);

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
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

    private static void runMethodByAnnotation(Object type, Class<? extends Annotation> annotation) {
        try {
//            sortMethods(allMethods);
            for (Method method : allMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    if (method.isAnnotationPresent(Test.class)) {
                        runMethods(sortMethods(allMethods));

                    } else
                    method.invoke(type);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static List<Method> sortMethods(Method[] methods) {
        return Arrays.stream(methods)
                .filter(e -> e.getAnnotation(Test.class) != null)
                .sorted((o1, o2) -> o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority())
                .collect(Collectors.toList());
    }

    private static void runMethods(List<Method> methods) {
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class))
                    method.invoke(object);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
