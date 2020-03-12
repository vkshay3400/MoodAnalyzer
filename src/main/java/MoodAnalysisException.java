public class MoodAnalysisException extends Exception {
    //USING ENUM
    enum MyException_Type{
        EMPTY,NULL,NO_SUCH_CLASS,NO_SUCH_METHOD;
    }
    MyException_Type type;
    MoodAnalysisException(MyException_Type type, String message) {
        super(message);
        this.type=type;
    }
}