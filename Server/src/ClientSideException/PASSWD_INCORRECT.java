package ClientSideException;

public class PASSWD_INCORRECT {
    int type =2;
    public  int getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return "Password is Incorrect , Please Enter correct Password";
    }

}
