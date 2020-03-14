import java.util.Objects;

public class MoodAnalyzer {
    //DECLARE VARIABLE
    String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer() {
    }

    //PARAMETERISED CONSTRUCTOR
    MoodAnalyzer(String message) {
        this.message = message;
    }

    //DECLARE MAIN METHOD
    public static void main(String[] args) throws MoodAnalysisException {
        System.out.println("Welcome to Mood Analyzer");
    }

    //METHOD TO CHECK MOOD
    public String moodAnalyzer() throws MoodAnalysisException {
        try {
            if (message.length() == 0) {
                throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.EMPTY, "You entered empty, please enter valid mood");
            }
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NULL, "You entered null, please enter valid mood");
        }
    }

    //CHECK BOTH OBJECTS ARE EQUALS
    @Override
    public boolean equals(Object secondObject) {
        if (this == secondObject) return true;
        if (secondObject == null || getClass() != secondObject.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) secondObject;
        return Objects.equals(message, that.message);
    }
}