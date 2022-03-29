import java.util.ArrayList;
    //Uses a subclass that extends a superclass.
public class Example extends Account
{
    private ArrayList<Passwords> passArr=new ArrayList<>();
    private ArrayList<Passwords> passArr2=new ArrayList<>(); //to consistently store chronilogical order.
    private int timesReset; //Includes subclasses with instance variables.

    public Example(String user, String pass)
    {
        super(user, pass);  //Calls a superclass constructor with the super keyword and passes actual parameters.
    }
    
    public String generatePassword()
    {
        return "Use Strong Passwords kids"; 
    }

    public void resetExample()
    {
        passArr=new ArrayList<>();
        passArr2=new ArrayList<>();
        addPassword(new Passwords("Pupilpath", "Wilson He", "totally secure password"));
        addPassword(new Passwords("Collegeboard", "wilson@nycstudents.net", "Please give me a 1500"));
        addPassword(new Passwords("Github", "WHE", "git was hard to learn"));
        addPassword(new Passwords("Google Classroom", "wilson@nycstudents.net", "Too many assignments"));
        addPassword(new Passwords("Figma", "wilsonh", "Use this website if you want to create a GUI, makes things easier"));
        timesReset++;
    }

    public void printBadPasswords(int i) //Calls a superclass method with the super keyword and passes actual parameters.
    {
        System.out.println(super.passwordIsStrongEnough(super.getPassAtIndex(i).getPassword()));  //Calls an inherited method.
    }
}
