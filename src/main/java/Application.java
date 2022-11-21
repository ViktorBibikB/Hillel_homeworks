import exceptions.ArrayDataException;
import exceptions.ArraySizeException;

public class Application {
    public static void main(String[] args) throws ArraySizeException, ArrayDataException {
        String[][] array = new String[][]{
                {"4", "5", "1", "5"},
                {"5", "1", "5", "4"},
                {"1", "4", "5", "5"},
                {"5", "5", "1", "4"}};

        String[][] array_1 = new String[][]{
                {"4", "5", "1", "5"},
                {"5", "1", "5", "4"},
                {"1", "4", "5", "5"},
                {"5", "5", "1", "4"},
                {"5", "5", "1", "4"}};

        String[][] array_2 = new String[][]{
                {"4", "5", "1", "5"},
                {"5", "1", "5", "4", "4"},
                {"1", "4", "5", "5"},
                {"5", "5", "1", "4"}};

        String[][] array_3 = new String[][]{
                {"4", "5", "1", "5"},
                {"5", "1", "5", "4"},
                {"1", "4", "5", "5"},
                {"5", "5", "----", "4"}};

        try {
            System.out.println(ArrayValueCalculator.doCalc(array));
        } catch (ArraySizeException | ArrayDataException ex) {
            ex.printStackTrace();
        }

        try {
            System.out.println(ArrayValueCalculator.doCalc(array_1));
        } catch (ArraySizeException | ArrayDataException ex) {
            ex.printStackTrace();
        }

        try {
            System.out.println(ArrayValueCalculator.doCalc(array_2));
        } catch (ArraySizeException | ArrayDataException ex) {
            ex.printStackTrace();
        }

        try {
            System.out.println(ArrayValueCalculator.doCalc(array_3));
        } catch (ArraySizeException | ArrayDataException ex) {
            ex.printStackTrace();
        }
    }
}
