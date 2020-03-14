import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Constructor<?> getConstructor(String className,Class param) throws MoodAnalysisException {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, "No such a class found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, "No such a method found");
        }
    }

    // DEFAULT CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyser() {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            // RETURN THE CONSTRUCTOR OBJECT
            Constructor<?> moodConstructor = moodAnalyzerClass.getDeclaredConstructor();
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

    // PARAMTERISED CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyser(String reaction) {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            // RETURN THE CONSTRUCTOR OBJECT
            Constructor<?> moodConstructor = moodAnalyzerClass.getDeclaredConstructor(String.class);
            //CONSTRUCTOR CLASS IS USED TO CREATE A NEW INSTANCE OF THE CLASS
            Object instance = moodConstructor.newInstance(reaction);
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

    //TO CHECK NO CLASS, NO METHOD
    public static Object getConstructor(String className,Class param,String reaction) throws MoodAnalysisException {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(param);
            //CONSTRUCTOR CLASS IS USED TO CREATE A NEW INSTANCE OF THE CLASS
            return moodConstructor.newInstance(reaction);
        }catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //INVOKE METHOD AND RETURN OUTPUT
    public static String invokeMoodAnalyser(MoodAnalyzer mood,String methodName) throws MoodAnalysisException {
        try {
            return (String) mood.getClass().getMethod(methodName).invoke(mood);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD, "No such method found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //SET FIELD MOOD ANALYSER
    public static String setFieldMoodAnalyser(MoodAnalyzer mood,String fieldName,String fieldValue) throws MoodAnalysisException {
        try {
            Field field = mood.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(mood,fieldValue);
        }catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_FIELD, "No such field found");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}