import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {
    @Test
    public void shouldBeCorrect() throws InvalidInputForAnagram {
        Anagram anagramTest = new Anagram();
        Assert.assertEquals(6, anagramTest.getAnagram("omg"));
    }

    @Test
    public void testMinInput() {
        Anagram anagramTest = new Anagram();
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram("nb"));
    }

    @Test
    public void testMaxInput() {
        Anagram anagramTest = new Anagram();
        //create string with 100+ size
        String valueForTesting = "qwertyuioppoiuytrewqqwertyuioppoiuytrewqqwertyuioppoiuytrewqqwertyui" +
                "oppoiuytrewqqwertyuioppoiuytreycbcgvcb";
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram(valueForTesting));
    }

    @Test
    public void testNumbersInInput() {
        Anagram anagramTest = new Anagram();
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram("9675"));
    }

    @Test
    public void testUpperCaseInInput() {
        Anagram anagramTest = new Anagram();
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram("English"));
    }
}
