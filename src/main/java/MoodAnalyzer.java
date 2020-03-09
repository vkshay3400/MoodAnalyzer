public class MoodAnalyzer {
    //DECLARE VARIABLE
    String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer(){ }

    //PARAMETERISED CONSTRUCTOR
    MoodAnalyzer(String message){
        this.message=message;
    }

    //DECLARE MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyzer");
    }

    //METHOD TO CHECK MOOD
    public String moodAnalyzer() {
        try {
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            return "Happy";
        }
    }
}