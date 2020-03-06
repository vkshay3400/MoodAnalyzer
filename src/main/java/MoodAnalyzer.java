public class MoodAnalyzer {
    //DECLARE VARIABLE
    String mood;
    String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer(){
        message="";
    }

    //PARAMETERISED CONSTRUCTOR
    MoodAnalyzer(String message){
        this.message=message;
    }

    //DECLARE MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyzer");
    }

    //METHOD TO CHECK MOOD
    public String moodAnalyzer(){
        if (message.contains("sad")){
            mood="Sad";
        }
        else if (message.contains("happy")){
            mood="Happy";
        }
        return mood;
    }
}