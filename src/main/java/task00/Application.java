package task00;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        calculateShapesAreaSum(6);
    }

    private static void calculateShapesAreaSum(int arraySize) {
        double areaSum = 0.0;

        for (Shape shape : createShapesArray(arraySize)) {
            areaSum += shape.area();
        }

        System.out.println(areaSum);
    }

    private static Shape[] createShapesArray(int arraySize) {
        Shape[] shapesArray = new Shape[arraySize];

        for (int i = 0; i < shapesArray.length; i++) {
            if (i == 0 || i == 1)
                shapesArray[i] = new Triangle((Math.random() * 5) + 1, (Math.random() * 10) + 1);
            else if (i % 2 == 0)
                shapesArray[i] = new Square((Math.random() * 8) + 1);
            else
                shapesArray[i] = new Circle((Math.random() * 9) + 1);
        }

        System.out.println(Arrays.toString(shapesArray));
        return shapesArray;
    }
}
