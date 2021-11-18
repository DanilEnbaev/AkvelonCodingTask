/**
 * <h1>Class InvalidInputForAnagram </h1>
 * This class extends Exception and make a new exception for invalid input
 *
 * @author Danil Enbaev
 * @version 1.0
 * @since 18.11.21
 */
public class InvalidInputForAnagram extends Exception {
    String messageOfException;

    InvalidInputForAnagram(String messageOfException) {
        this.messageOfException = messageOfException;
    }
}
