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

    public ArrayList<Passwords> getPasswords()
    {
        return this.passArr;
    }

    public Passwords getPassAtIndex(int i)
    {
        return this.passArr.get(i);
    }

    public int getAmountOfPasswords()
    {
        return this.passArr.size();
    }

    public void removePassword(int i)
    {
        this.passArr.remove(i-1);
        this.passArr2.remove(i-1);
    }

    public ArrayList<Passwords> sortByChronological()
    {
        return passArr;
    }

    public ArrayList<Passwords> sortBySiteAscending()  //uses selection sort to sort by websites
    {
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int j=0;j<this.getAmountOfPasswords();j++)
        {
            passArray.add(this.getPassAtIndex(j));
        }
        for (int i=0;i<passArray.size()-1;i++)
        {
            int minimum=i;
            for (int k=i+1;k<passArray.size()-1;k++)
            {
                if (getPassAtIndex(k).compareTo(getPassAtIndex(minimum),true)<0)
                {
                    minimum=k;
                }
            }
            if (i!=minimum)
            {
                Passwords temp=passArray.get(minimum);
                passArray.set(minimum, passArr.get(i));
                passArray.set(i, temp);
            }
        }
        return passArray;  
    }

    public ArrayList<Passwords> sortBySiteDescending()
    {
        ArrayList<Passwords> temp=sortBySiteAscending();
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int i=temp.size()-1;i>=0;i--)
        {
            passArray.add(temp.get(i));
        }
        return passArray;
    }

    public ArrayList<Passwords> sortByUsernameAscending()
    {
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int j=0;j<this.getAmountOfPasswords();j++)
        {
            passArray.add(this.getPassAtIndex(j));
        }
        for (int i=0;i<passArray.size();i++)
        {
            for (int k=i;k>0;k--)
            {
                if (i!=0&&passArray.get(k).getUsername().compareTo(passArray.get(k-1).getUsername())<0)
                {
                    Passwords temp=passArray.get(k);
                    passArray.set(k, passArray.get(k-1));
                    passArray.set(k-1, temp);
                }
            }
        }
        return passArray;
    }

    public ArrayList<Passwords> sortByUsernameDescending()
    {
        ArrayList<Passwords> temp=sortByUsernameAscending();
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int i=temp.size()-1;i>=0;i--)
        {
            passArray.add(temp.get(i));
        }
        return passArray;
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
    public String toString()
    {
        return "User: "+username+" Password: "+password;
    }
}
