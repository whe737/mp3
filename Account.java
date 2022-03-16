import java.util.ArrayList;

public class Account 
{
    private String username;
    private String password;
    private ArrayList<Passwords> passArr=new ArrayList<>();
    
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

    public ArrayList<Passwords> sortBySite(ArrayList<Passwords> passArr)  //uses selection sort to sort by websites
    {
        for (int i=0;i<passArr.size()-1;i++)
        {
            int minimum=i;
            for (int k=i+1;k<passArr.size()-1;k++)
            {
                if (getPassAtIndex(k).compareTo(getPassAtIndex(minimum),true)<0)
                {
                    minimum=k;
                }
            }
            if (i!=minimum)
            {
                Passwords temp=passArr.get(minimum);
                passArr.set(minimum, passArr.get(i));
                passArr.set(i, temp);
            }
        }
        return passArr;
    }

    public void printAllPasswords()
    {
        for (Passwords i:passArr)
        {
            System.out.println(i);
        }
    }
}
