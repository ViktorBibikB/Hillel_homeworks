import java.util.Arrays;

public class ValueCalculator {
    private final int firstHalfSize;
    private final int secondHalfSize;
    private final float[] firstHalfArray;
    private final float[] secondHalfArray;
    private final float[] floats;
    private long startTime;

    public ValueCalculator(int valuesSize) {
        floats = new float[valuesSize];
        firstHalfSize = valuesSize / 2;
        firstHalfArray = new float[firstHalfSize];
        secondHalfSize = (valuesSize % 2 == 0 ? firstHalfSize : firstHalfSize + 1);
        secondHalfArray = new float[secondHalfSize];
    }

    public void doCalc() throws InterruptedException {
        startTime = System.currentTimeMillis();
        Arrays.fill(floats, 1);

        System.arraycopy(floats, 0, firstHalfArray, 0, firstHalfSize);
        System.arraycopy(floats, firstHalfSize, secondHalfArray, 0, secondHalfSize);

        Thread firstThread = new Thread(new ValueCalculatorFlow(firstHalfArray));
        Thread secondThread = new Thread(new ValueCalculatorFlow(secondHalfArray));

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.arraycopy(firstHalfArray, 0, floats, 0, firstHalfSize);
        System.arraycopy(secondHalfArray, 0, floats, firstHalfSize, secondHalfSize);

        System.out.println(System.currentTimeMillis() - startTime);
    }

    private static class ValueCalculatorFlow implements Runnable {
        private final float[] values;

        public ValueCalculatorFlow(float[] values) {
            this.values = values;
        }

        @Override
        public void run() {
            for (int i = 0; i < values.length; i++) {
                values[i] = (float) (values[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        }
    }
}
