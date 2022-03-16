import java.util.ArrayList;

public class Account 
{
    private String username;
    private String password;
    private ArrayList<Passwords> passArr;
    
    public Account(String user, String pass)
    {
        username=user;
        password=pass;
    }

    public void addPassword(Passwords pass)
    {
        passArr.add(pass);
    }

    public Passwords getPassAtIndex(int i)
    {
        return passArr.get(i);
    }

    // public ArrayList<Passwords> sortBySite()  do another day lmao
    // {
    //     for (Passwords p:passArr)
    //     {
            
    //     }
    // }
}
