import java.util.ArrayList;

public class Main
{
    private static ArrayList<Account> accArr= new ArrayList<>();
    public static void main(String[] args)
    {
        Example examp=new Example("example", "password");
        accArr.add(examp);
        examp.resetExample();

        Account test=new Account("name", "pass");
        test.addPassword(new Passwords("pupilpath", "name", "pass"));
        test.addPassword(new Passwords("a", "a", "a"));
        test.addPassword(new Passwords("thing", "nam", "na"));
        test.addPassword(new Passwords("aasdf", "asdf", "a"));
        test.addPassword(new Passwords("asf", "sdf", "sdf"));
        accArr.add(test);
        // System.out.println(test.sortBySiteDescending());
        System.out.println(test.generatePassword());
        new Window(test);
    }
    public static void addAccount(Account p)
    {
        accArr.add(p);
    }
    public static ArrayList<Account> getAccounts()
    {
        return accArr;
    }
    public static Account getAccount(int i)
    {
        return accArr.get(i);
    }
}