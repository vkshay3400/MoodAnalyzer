import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenValid_ThenReturnSad() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in sad mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Sad", e.getMessage());
        }
    }

    @Test
    public void givenMessage_WhenInvalid_ThenReturnHappy() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in happy mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Happy", e.getMessage());
        }
    }

    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalyzer mood = new MoodAnalyzer(null);
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMood_ShouldReturnHappy() {
        MoodAnalyzer mood = new MoodAnalyzer("");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_ClassName_DefaultConstructor_ShouldReturnObject() {
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
    public void givenClassName_WhenImproper_ShouldThrow_MoodAnalysisException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnzer", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrow_MoodAnalysisException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer", Boolean.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WithParameterConstructor_ShouldReturnObject() {
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
    public void givenClassName_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("ModAnazer", String.class, "I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer", Integer.class, "I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessage_UsingReflection_WhenProper_ShouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object instance = constructor.newInstance("I am in happy mood");
            String analyser = MoodAnalyserFactory.invokeMoodAnalyser((MoodAnalyzer) instance, "moodAnalyzer");
            Assert.assertEquals("Happy", analyser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WhenImproperMethod_ShouldThrowException() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object instance = constructor.newInstance("I am in happy mood");
            String analyser = MoodAnalyserFactory.invokeMoodAnalyser((MoodAnalyzer)instance,"wrongMoodAnalyzer");
            Assert.assertEquals("Happy",analyser);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setHappyMessage_WithReflector_ShouldReturnHappy() {
        try {
            MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyser,"message","I am in happy mood");
            String moodResult = MoodAnalyserFactory.invokeMoodAnalyser( moodAnalyser, "moodAnalyzer");
            Assert.assertEquals("Happy",moodResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setField_WhenImproper_ShouldThrowException_WithNoSuchField() {
        try {
            MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyser,"wrongMessage","I am in happy mood");
            String moodResult = MoodAnalyserFactory.invokeMoodAnalyser( moodAnalyser, "moodAnalyzer");
            Assert.assertEquals("Happy",moodResult);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_FIELD, e.type);
        }
    }
}