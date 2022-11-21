import exceptions.ArrayDataException;
import exceptions.ArraySizeException;

public class ArrayValueCalculator {
    private static final int ARRAY_SIZE = 4;

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        validateArraySize(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Incorrect data " + "\"" + array[i][j]+ "\"" + " at the string - "
                            + (i + 1) + " and column - " + (j + 1));
                }
            }
        }
        return sum;
    }

    private static void validateArraySize(String[][] array) throws ArraySizeException {
        if (array.length != ARRAY_SIZE)
            throw new ArraySizeException("Incorrect array size, " + "[" + array.length + "]" + " - must be "
                    + "[" + ARRAY_SIZE + "]");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != ARRAY_SIZE)
                throw new ArraySizeException("Incorrect array length - " + "[" + array[i].length + "]"
                        + ", at the string [" + i + "], must be " + "[" + ARRAY_SIZE + "]");
        }
    }
}
