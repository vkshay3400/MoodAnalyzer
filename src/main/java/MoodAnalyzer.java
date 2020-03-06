public class MoodAnalyzer {
    String mood;

    //DECLARE MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyzer");
    }

    //METHOD TO VALIDATE MOOD
    public String moodAnalyzer(String recentMood){
        if (recentMood.equals("I am in sad mood")){
            mood="Sad";
        }
        else if (recentMood.equals("I am in any mood")){
            mood="Happy";
        }
        return mood;
    }
}