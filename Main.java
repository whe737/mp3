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
        accArr.add(test);
        //test.printAllPasswords();
        // System.out.println(test.sortByUsernameAscending());
        // System.out.println();
        // System.out.println(test.sortByUsernameDescending());
        // test.printAllPasswords();
        //new LoginPage();
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