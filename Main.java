import java.util.ArrayList;

public class Main
{
    private static ArrayList<Account> accArr= new ArrayList<>();
    public static void main(String[] args)
    {
        Example examp=new Example("example", "password");
        accArr.add(examp);
        examp.resetExample();
        new LoginPage();
        Account yes=new Account();  //Calls a superclass’s no-argument constructor
        Account no=new Example("man", "person");    //Facilitates polymorphism, i.e. assigns an object of a subclass to a reference of a superclass.
        new Object();   //Calls the Object constructor.
        System.out.println(examp.generatePassword());
        examp.printBadPasswords(3);
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