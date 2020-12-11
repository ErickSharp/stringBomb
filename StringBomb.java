
/**
 * Takes input from user as sentence and returns it in altered form.
 *
 * Erick Torres December 4, 2020
 */
import java.util.Scanner;

public class StringBomb {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("---String Bomb---");
        System.out.print("\nEnter in a sentence: ");
        String Sentence = keyboard.nextLine();
        keyboard.close();
        System.out.print("\n\n" + convertSentence(Sentence));

    }

    public static String convertSentence(String Sentence) {
        String currentWord = "";
        String returnSentence = "";
        for (int i = 0; i < Sentence.length(); i++) {
            if (Character.isLetter(Sentence.charAt(i)) == true) {
                currentWord += Sentence.charAt(i);
            }
            if (Character.isLetter(Sentence.charAt(i)) == false || i == Sentence.length() - 1) {
                if (currentWord.length() > 0) {
                    if (currentWord.length() % 2 == 0) {
                        returnSentence += convertEvenWord(currentWord);
                    } else {
                        returnSentence += convertOddWord(currentWord);
                    }
                }
                currentWord = "";
                if (Character.isLetter(Sentence.charAt(i)) == false) {
                    returnSentence += Sentence.charAt(i);
                }
            }
        }
        return returnSentence;
    }

    public static String convertEvenWord(String word) {
        String returnWord = "";
        if (word.length() == 2) {
            for (int i = 0; i < word.length(); i++) {
                returnWord += Character.toUpperCase(word.charAt(i));
            }
        } else if (word.length() == 4) {
            for (int i = 0; i < word.length(); i++) {
                returnWord += "*";
            }
        } else if (word.length() == 6) {
            returnWord += word.charAt(5);
            returnWord += word.charAt(1);
            returnWord += word.charAt(3);
            returnWord += word.charAt(2);
            returnWord += word.charAt(4);
            returnWord += word.charAt(0);
        } else {
            returnWord = word.substring(0, word.length() / 2) + " " + word.substring(word.length() / 2);
        }

        return returnWord;
    }

    public static String convertOddWord(String word) {
        String returnWord = "";
        if (word.length() == 1) {
            if (word.length() == 1) {
                returnWord += "%";
            }
        } else if (word.length() == 3) {
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    returnWord += "<";
                } else if (i == word.length() - 1) {
                    returnWord += ">";
                } else {
                    returnWord += word.charAt(i);
                }
            }
        } else if (word.length() == 5) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    returnWord += Character.toLowerCase(word.charAt(i));
                } else {
                    returnWord += Character.toUpperCase(word.charAt(i));
                }
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    returnWord += word.charAt(i);
                }
            }
        }

        return returnWord;
    }
}
