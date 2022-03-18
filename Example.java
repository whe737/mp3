import java.util.ArrayList;

public class Example extends Account
{
    private ArrayList<Passwords> passArr=new ArrayList<>();
    private ArrayList<Passwords> passArr2=new ArrayList<>(); //to consistently store chronilogical order.

    public Example(String user, String pass)
    {
        super(user, pass);
    }
    
}
