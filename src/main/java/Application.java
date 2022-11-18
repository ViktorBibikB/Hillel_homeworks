import game.GuessTheWordGame;

import java.util.Scanner;

import static strings.StringMethods.*;

public class Application {
    public static void main(String[] args) {
        findSymbolOccurance("AppOlloojo", 'o');
        System.out.println("Identity appears at position: " + findWordPosition("Appolo", "olo"));
        System.out.println(stringReverse("Hello "));
        System.out.println(isPalindrome("eRkRE"));

        GuessTheWordGame guessTheWord = new GuessTheWordGame();
        Scanner scanner = new Scanner(System.in);

        guessTheWord.printWordsList();

        while (true) {
            String playerWord = scanner.next();

            if (guessTheWord.isGuessed(playerWord)) {
                System.out.println("Congratulations! You win!");
                return;
            }
            System.out.println("Wrong!");
            System.out.println("Guessed symbols: " + guessTheWord.computeGuessedSymbols(playerWord));
        }
    }
}
