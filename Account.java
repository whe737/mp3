import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

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
        this.passArr.remove(i);
        this.passArr2.remove(i);
    }

    public ArrayList<Passwords> sortByChronologicalAscending()
    {
        return passArr;
    }

    public ArrayList<Passwords> search(String n, boolean b) //true is for website only, false is username only
    {
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int j=0;j<this.getAmountOfPasswords();j++)
        {
            passArray.add(this.getPassAtIndex(j));
        }
        if (b==true)
        {
            for (int i=0;i<passArray.size();i++)
            {
                if (!passArray.get(i).getLogin().equals(n))
                {
                    passArray.remove(i);
                    i--;
                }
            }
            return passArray;
        }
        else 
        {
            for (int i=0;i<passArray.size();i++)
            {
                if (!passArray.get(i).getUsername().equals(n))
                {
                    passArray.remove(i);
                    i--;
                }
            }
            return passArray;
        }
    }

    public ArrayList<Passwords> search(String website, String username)
    {
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int j=0;j<this.getAmountOfPasswords();j++)
        {
            passArray.add(this.getPassAtIndex(j));
        }
        for (int i=0;i<passArray.size();i++)
        {
            if (!passArray.get(i).getLogin().equals(website)&&!passArray.get(i).getUsername().equals(username))
            {
                passArray.remove(i);
                i--;
            }
        }
        return passArray;
    }

    public ArrayList<Passwords> sortBySiteDescending()  //uses selection sort to sort by websites
    {
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int j=0;j<this.getAmountOfPasswords();j++)
        {
            passArray.add(this.getPassAtIndex(j));
        }
        int counter=0;
        for (int i=0;i<passArray.size()-1;i++)
        {
            int minimum=i;
            for (int k=i+1;k<passArray.size();k++)
            {
                if (passArray.get(k).compareTo(passArray.get(minimum),true)<0)
                {
                    minimum=k;
                }
            }
            if (i!=minimum)
            {
                Passwords temp=passArray.get(minimum);
                passArray.set(minimum, passArray.get(i));
                passArray.set(i, temp);
                counter++;
            }
        }
        System.out.println("Selection sort sorted "+counter+" times.");
        return passArray;  
    }

    public ArrayList<Passwords> sortBySiteAscending()
    {
        ArrayList<Passwords> temp=sortBySiteDescending();
        ArrayList<Passwords> passArray=new ArrayList<>();
        for (int i=temp.size()-1;i>=0;i--)
        {
            passArray.add(temp.get(i));
        }
        return passArray;
    }

    public ArrayList<Passwords> sortByUsernameAscending()
    {
        int counter=0;
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
                    counter++;
                }
            }
        }
        System.out.println("Insertion sort sorted "+counter+" times.");
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

    public String generatePassword()
    {
        String characters="abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ012345678^$?!@#%&";
        String randpassword="";
        for (int i=0;i<16;i++)
        {
            int random=(int) (Math.random()*64)+1;
            randpassword+=characters.substring(random-1,random);
        }
        return randpassword;
    }

    public String toString()
    {
        return "User: "+username+" Password: "+password;
    }
}
