public class Main
{
    public static void main(String[] args)
    {
        Account test=new Account("name", "pass");
        test.addPassword(new Passwords("pupilpath", "name", "pass"));
        test.addPassword(new Passwords("a", "a", "a"));
        test.addPassword(new Passwords("thing", "name", "na"));
        test.printAllPasswords();
        System.out.println("sort separator: --------------------------");
        System.out.println(test.sortBySite());
        LoginPage log=new LoginPage();
    }
}