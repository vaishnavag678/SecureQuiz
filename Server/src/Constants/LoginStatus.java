package Constants;

public enum  LoginStatus {

    SUCCESS("0"),
    WRONG_CREDENTIALS("1"),
    NO_SUCH_USER("2");

    LoginStatus(String atr)
    {
        atr.toString();
    }
}
