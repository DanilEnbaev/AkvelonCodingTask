public class InvalidInputForAnagram extends Exception {
    String messageOfException;

    InvalidInputForAnagram(String messageOfException) {
        this.messageOfException = messageOfException;
    }
}
