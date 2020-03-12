public class MoodAnalysisException extends Exception {
    //USING ENUM
    enum MyException_Type{
        EMPTY,NULL;
    }
    MyException_Type type;
    MoodAnalysisException(MyException_Type type, String message) {
        super(message);
        this.type=type;
    }
}