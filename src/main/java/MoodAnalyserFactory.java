import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

    public class MoodAnalyserFactory {
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