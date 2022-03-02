package exceptionstudy;

public class MyException extends Exception {
    private final int ERR_CODE;

    public MyException(String message) {
        this(message, 100);
    }

    public MyException(String message, int ERR_CODE) {
        super(message);
        this.ERR_CODE = ERR_CODE;
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}
