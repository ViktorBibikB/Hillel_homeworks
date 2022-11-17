package game;

public class GuessTheWordGame {
    private static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leek", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private final String computerWord;

    private String guessedSymbols = "###############";

    public GuessTheWordGame() {
        computerWord = WORDS[(int) (Math.random() * WORDS.length)];
    }

    public boolean isGuessed(String playerWord) {
        return playerWord.equals(computerWord);
    }

    public String computeGuessedSymbols(String playerWord) {
        char[] temp = guessedSymbols.toCharArray();

        for (int i = 0; i < computerWord.length() && i < playerWord.length(); i++) {
            if (playerWord.charAt(i) == computerWord.charAt(i)) {
                temp[i] = computerWord.charAt(i);
            }
        }

        guessedSymbols = String.valueOf(temp);
        return guessedSymbols;
    }
}
