public class MoodAnalyzer {
    //DECLARE VARIABLE
    String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer(){
    }

    //PARAMETERISED CONSTRUCTOR
    MoodAnalyzer(String message){
        this.message=message;
    }

    //DECLARE MAIN METHOD
    public static void main(String[] args) throws MoodAnalysisException {
        System.out.println("Welcome to Mood Analyzer");
    }

    //METHOD TO CHECK MOOD
    public String moodAnalyzer() throws MoodAnalysisException {
        try {
            if (message.length()==0)
            {
                throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.EMPTY,"You entered empty, please enter valid mood");
            }
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            return "Happy";
        }
    }
}