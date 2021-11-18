/**
 * <h1>Class Anagram</h1>
 * This class has methods for generating anagrams: method for printing anagrams
 * to the console -printNewAnagram; the method for changing letters
 * in a word- ChangeOfElement; method for checking valid data- checkValidInput;
 * method of creating anagrams - makeAnagram; anagram counting method getAnagram
 *
 * @author danilenbaev
 * @version 1.0
 * @since 15.11.21
 */
public class Anagram {
    private static final int MAX_SIZE_ANAGRAM = 100;
    private static int sizeInput;
    private static int countOfAnagrams;
    private static final char[] ARRAY_OF_LETTERS = new char[MAX_SIZE_ANAGRAM];

    /**
     * This his is the main method that uses other helper methods.
     * First, we check the data using the validation method, then
     * enter letters into the array, call the method to create anagrams
     * and return the number of found anagrams
     *
     * @param inputWord search word anagram
     * @return number of anagrams found
     * @throws InvalidInputForAnagram if input invalid
     */
    int getAnagram(String inputWord) throws InvalidInputForAnagram {
        checkValidInput(inputWord);
        sizeInput = inputWord.length();
        countOfAnagrams = 0;
        for (int i = 0; i < sizeInput; i++) {
            ARRAY_OF_LETTERS[i] = inputWord.charAt(i);
        }
        makeAnagram(sizeInput);
        return countOfAnagrams;
    }

    /**
     * This method creates anagrams and prints them. Reflection and method
     * printNewAnagram ChangeOfElement are used, as input we take the size
     * of the line
     *
     * @param newSize size new input made by recursive
     */
    private static void makeAnagram(int newSize) {
        int invalidNumberForChanging = 1;
        int numberWhenPrint = 2;
        if (newSize == invalidNumberForChanging) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            makeAnagram(newSize - 1);
            if (newSize == numberWhenPrint) {
                printNewAnagram();
            }
            ChangeOfElement(newSize);
        }
    }

    /**
     * This method swaps the letters in the array, thereby creating new anagrams.
     *
     * @param newSize size new input made by recursive
     */
    private static void ChangeOfElement(int newSize) {
        int counterForChanging;
        int positionInArray = sizeInput - newSize;
        char changingLetter = ARRAY_OF_LETTERS[positionInArray];

        for (counterForChanging = positionInArray + 1;
             counterForChanging < sizeInput; counterForChanging++) {
            ARRAY_OF_LETTERS[counterForChanging - 1] = ARRAY_OF_LETTERS[counterForChanging];
        }
        ARRAY_OF_LETTERS[counterForChanging - 1] = changingLetter;
    }

    /**
     * This method print word from letter of arrayOfLetters to console
     */
    private static void printNewAnagram() {
        countOfAnagrams++;
        System.out.print(countOfAnagrams + " - ");
        for (int i = 0; i < sizeInput; i++) {
            System.out.print(ARRAY_OF_LETTERS[i]);
        }
        System.out.println();
    }

    /**
     * This method verifies that the entered data is correct.
     * Data must not have digits, must be in lower case, maximum
     * length 99 minimum 3 otherwise throws an exception
     *
     * @param inputForCheck input data for checking
     * @throws InvalidInputForAnagram throw exception if
     *                                data invalid
     */
    private static void checkValidInput(String inputForCheck)
            throws InvalidInputForAnagram {
        int minSizeOfInput = 3;
        int maxSizeOfInput = 100;
        assert inputForCheck != null;
        if (inputForCheck.length() < minSizeOfInput || inputForCheck.length() > maxSizeOfInput) {
            throw new InvalidInputForAnagram
                    ("Size of input data should be more than 3 and less than 99");
        }
        for (int i = 0; i < inputForCheck.length(); i++) {
            if (Character.isUpperCase(inputForCheck.charAt(i)) ||
                    !Character.isLetter(inputForCheck.charAt(i))) {
                throw new InvalidInputForAnagram
                        ("Input data can not be in upper case and contains number");
            }
        }
    }
}