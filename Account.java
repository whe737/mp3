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

    public Account() {
        username="";
        password="";
    }

    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }

    public void addPassword(Passwords pass)
    {
        passArr.add(pass);
        passArr2.add(pass);
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

    public boolean equals(Object object)
    {
        if (((Account)object).username.equals(username)&&((Account)object).password.equals(password))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    private static boolean checkSpecialChars(String password)
    {
        String specialChars="!@#$%^&*";
        for (int i=0;i<specialChars.length(); i++)
        {
            if (password.indexOf(specialChars.substring(i,i+1))!=-1)
            {
                return true;
            }
        }
        return false;
    }
    private static boolean checkUppercase(String password)
    {
        String upperChars="QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i=0;i<upperChars.length(); i++)
        {
            if (password.indexOf(upperChars.substring(i,i+1))!=-1)
            {
                return true;
            }
        }
        return false;
    }
    private static boolean checkLowercase(String password) 
    {
        String lowerChars="qwertyuiopasdfghjklzxcvbnm";
        for (int i=0;i<lowerChars.length(); i++)
        {
            if (password.indexOf(lowerChars.substring(i,i+1))!=-1)
            {
                return true;
            }
        }
        return false;
    }
    public static String passwordIsStrongEnough(String pass) //checks to see if password is strong enough
    {
        if (checkSpecialChars(pass)==false)
        {
            return "Password does not contain a special character.";
        }
        if (pass.length()<8)
        {
            return "Password is too short. ";
        }
        if (checkUppercase(pass)==false)
        {
            return "Password does not contain an uppercase. ";
        }
        if (checkLowercase(pass)==false)
        {
            return "Password does not contain a lowercase. ";
        }
        return "Strong";
    }
}
