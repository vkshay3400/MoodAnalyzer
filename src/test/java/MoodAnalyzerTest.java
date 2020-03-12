import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    //CREATE OBJECT OF MOOD ANALYZER CLASS
    MoodAnalyzer mood = new MoodAnalyzer();

    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void givenMessage_whenValid_thenReturn() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in sad mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Sad", e.getMessage());
        }
    }

    //TEST CASE TO CHECK HAPPY MOOD
    @Test
    public void givenMessage_whenInvalid_thenReturn() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in happy mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Happy", e.getMessage());
        }
    }

    //TEST CASE FOR EXCEPTION HANDLING NULL MOOD
    @Test
    public void givenNullMoodShouldThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer(null);
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL,e.type);
        }
    }
}