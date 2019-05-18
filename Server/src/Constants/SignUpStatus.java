package Constants;
public enum SignUpStatus {
    SUCCESS("1"),
    EMAIL_ALREADY_EXISTS("2"),
    FAILURE("0");
    SignUpStatus(String s)
    {
        s.toString();
    }
}
