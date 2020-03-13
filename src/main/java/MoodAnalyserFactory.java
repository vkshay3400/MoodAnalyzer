import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Constructor<?> getConstructor(String className,Class param) throws MoodAnalysisException {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static MoodAnalyzer createMoodAnalyser() {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            // RETURN THE CONSTRUCTOR OBJECT
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            //CONSTRUCTOR CLASS IS USED TO CREATE A NEW INSTANCE OF THE CLASS
            Object instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
            return null;
    }
}