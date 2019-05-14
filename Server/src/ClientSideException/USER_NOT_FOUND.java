package ClientSideException;

import java.io.Serializable;

public class USER_NOT_FOUND extends Exception implements Serializable   {
    private int type = 1;
    public int getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return "USER NOT FOUND, PLEASE ENTER VALID DATAILS";
    }
}
