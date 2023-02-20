package math.actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class MathActions {
    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        return a / b;
    }

    public double subtract(double a, double b){
        return a - b;
    }

    public double sum(double a, double b){
        return a + b;
    }

    public <T extends Double> double max(T[] arr){
        List<T> listOfDoubles = Arrays.asList(arr);

        return listOfDoubles.stream()
                .mapToDouble(d -> d)
                .max().orElseThrow(NoSuchElementException::new);
    }


    public <T extends Double> double min(T[] arr){
        List<T> listOfDoubles = Arrays.asList(arr);

        return listOfDoubles.stream()
                .mapToDouble(d -> d)
                .min().orElseThrow(NoSuchElementException::new);
    }
}
