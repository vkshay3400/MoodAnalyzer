import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_whenValid_thenReturnSad() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in sad mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Sad", e.getMessage());
        }
    }

    @Test
    public void givenMessage_whenInvalid_thenReturnHappy() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in happy mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Happy", e.getMessage());
        }
    }

    @Test
    public void givenNullMoodShouldThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer(null);
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL,e.type);
        }
    }

    @Test
    public void givenEmptyMoodShouldThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer("");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassNameDefaultConstructor_Proper_ShouldReturnObject() {
        MoodAnalyzer mood = new MoodAnalyzer();
        try {
            MoodAnalyzer analyseMood = MoodAnalyserFactory.createMoodAnalyser();
            boolean reaction = analyseMood.equals(mood);
            Assert.assertEquals(true, reaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClassName_WhenNotProper_ShouldThrowException_InMoodAnalyser() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnzer",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassName_WhenConstructorNotProper_ShouldThrowException_InMoodAnalyser() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Boolean.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassNameParameterConstructor_Proper_ShouldReturnObject() {
        try {
            MoodAnalyzer mood = new MoodAnalyzer("I am in happy mood");
            MoodAnalyzer analyseMood = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
            boolean reaction = analyseMood.equals(mood);
            Assert.assertEquals(true, reaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClassName_WhenImProperSuchClass_ShouldThrowException_InMoodAnalyser() {
        try {
            MoodAnalyserFactory.getConstructor("ModAnazer",String.class,"I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassName_WhenImProperSuchMethod_ShouldThrowException_InMoodAnalyser() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class,"I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.type);
        }
    }
}