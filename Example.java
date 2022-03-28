import java.util.ArrayList;

public class Example extends Account
{
    private ArrayList<Passwords> passArr=new ArrayList<>();
    private ArrayList<Passwords> passArr2=new ArrayList<>(); //to consistently store chronilogical order.

    public Example(String user, String pass)
    {
        super(user, pass);
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
    }
}
