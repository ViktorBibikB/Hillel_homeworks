package strings;

public class StringMethods {

    public static int findSymbolOccurance(String text, char symbol) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char[] array = text.toLowerCase().toCharArray();
            if (array[i] == symbol)
                count++;
        }
        System.out.println("Current symbol " + symbol + " occurred " + count + " times.");
        return count;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String text) {
        char[] array = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            array[i] = text.charAt(text.length() - i - 1);
        }
        return String.valueOf(array);
    }

    public static boolean isPalindrome(String text) {
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.toLowerCase().charAt(i) != text.toLowerCase().charAt(text.length() - i - 1))
                return false;
        }
        return true;
    }
}
