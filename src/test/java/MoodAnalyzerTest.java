import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer mood=new MoodAnalyzer();

    //TEST CASE TO CHECK VALID MOOD
    @Test
    public void givenMessage_whenValid_thenReturn() {
        String recentmood="I am in sad mood";
        String reaction=mood.moodAnalyzer(recentmood);
        Assert.assertEquals("Sad", reaction);
    }

    //TEST CASE TO CHECK INVALID MOOD
    @Test
    public void givenMessage_whenInvalid_thenReturn() {
        String recentmood="I am in any mood";
        String reaction=mood.moodAnalyzer(recentmood);
        Assert.assertEquals("Happy", reaction);
    }
}