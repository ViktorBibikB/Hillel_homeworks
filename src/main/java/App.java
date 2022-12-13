public class App {
    public static void main(String[] args) throws InterruptedException {
        int size = 1_000_000;

        ValueCalculator valueCalculator = new ValueCalculator(size);
        valueCalculator.doCalc();
    }
}
