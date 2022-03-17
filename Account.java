import java.util.ArrayList;

public class Account 
{
    private String username;
    private String password;
    private ArrayList<Passwords> passArr=new ArrayList<>();
    private ArrayList<Passwords> passArr2=new ArrayList<>(); //to store in chronilogical order no matter what
    
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

    public int getAmountOfPasswords()
    {
        return passArr.size();
    }

    public ArrayList<Passwords> sortBySite()  //uses selection sort to sort by websites
    {
        ArrayList<Passwords> passArr=new ArrayList<>();
        for (int j=0;j<this.getAmountOfPasswords();j++)
        {
            passArr.add(this.getPassAtIndex(j));
        }
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
