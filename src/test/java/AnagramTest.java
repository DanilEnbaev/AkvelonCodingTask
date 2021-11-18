import com.akvelon.Anagram;
import com.akvelon.InvalidInputForAnagram;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
    Anagram anagramTest;

    @Before
    public void prepareData() {
        anagramTest = new Anagram();
    }

    @Test
    public void shouldBeCorrect() throws InvalidInputForAnagram {
        Assert.assertEquals(6, anagramTest.getAnagram("omg"));
    }

    @Test
    public void testMinInput() {
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram("nb"));
    }

    @Test
    public void testMaxInput() {
        //create string with 100+ size
        String valueForTesting = "qwertyuioppoiuytrewqqwertyuioppoiuytrewqqwertyuioppoiuytrewqqwertyui" +
                "oppoiuytrewqqwertyuioppoiuytreycbcgvcb";
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram(valueForTesting));
    }

    @Test
    public void testNumbersInInput() {
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram("9675"));
    }

    @Test
    public void testUpperCaseInInput() {
        Assert.assertThrows(InvalidInputForAnagram.class, () -> anagramTest.getAnagram("English"));
    }
}
