

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
    private static List<Method> methodList = new ArrayList<>();
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

            runMethodByAnnotation(BeforeSuite.class);
            runMethodByAnnotation(Test.class);
            runMethodByAnnotation(AfterSuite.class);

//            runAllMethods();

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

    private static void runMethodByAnnotation(Class<? extends Annotation> annotation) {
        try {
            if (annotation.equals(Test.class)) {
                int length = sortMethodList(allMethods).size();
                Method[] methods = new Method[length];

                for (int i = 0; i < length; i++) {
                    methods[i] = sortMethodList(allMethods).get(i);
                }

                for (Method method1 : methods) {
                    method1.invoke(object);
                }
            } else {
                for (Method method : allMethods) {
                    if (method.isAnnotationPresent(annotation)) {
                        method.invoke(object);
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void runAllMethods() {
        try {
            methodList = Arrays.stream(allMethods)
                    .filter(e -> e.getAnnotation(Test.class) != null)
                    .sorted(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()))
                    .collect(Collectors.toList());

            for (Method method : allMethods) {
                if (method.getAnnotation(BeforeSuite.class) != null)
                    methodList.add(0, method);
                if (method.getAnnotation(AfterSuite.class) != null)
                    methodList.add(method);
            }

            for (Method finalMethod : methodList)
                finalMethod.invoke(object);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static List<Method> sortMethodList(Method[] methods) {
        return Arrays.stream(methods)
                .filter(e -> e.getAnnotation(Test.class) != null)
                .sorted(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()))
                .collect(Collectors.toList());
    }
}
