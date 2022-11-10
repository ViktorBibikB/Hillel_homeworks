package datatypes;

public class HomeWorkApp {
    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

    public static void checkSumSign(int a, int b) {
        System.out.println(a + b >= 0 ? "Sum is positive" : "Sum is negative");
    }

    public static void printColor(int value) {
        if (value > 100) {
            System.out.println("Green");
        } else if (value > 0) {
            System.out.println("Yellow");
        } else {
            System.out.println("Red");
        }
    }

    public static void compareNumbers(int a, int b){
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static boolean sumIsWithin(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void checkSign(int number){
        System.out.println(number >= 0 ? "Positive" : "Negative");
    }

    public static boolean isNegative(int value) {
        return value < 0;
    }

    public static void printStrings(int value, String text){
        while(value > 0){
            System.out.println(text);
            value--;
        }
    }

    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
