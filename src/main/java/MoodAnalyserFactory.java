import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Constructor<?> getConstructor(String className,Class param) throws MoodAnalysisException {
        try {
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
            //returns class object
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            // returns the constructor object
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            //Constructor class is used to create a new instance of the class.
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