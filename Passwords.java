public class Passwords 
{
    private String loginPlace;
    private String username;
    private String password;

    public Passwords(String log, String user, String pass)
    {
        loginPlace=log;
        username=user;
        password=pass;
    }

    public void setLogin(String log)
    {
        loginPlace=log;
    }
    public void setUsername(String use)
    {
        username=use;
    }
    public void setPassword(String pass)
    {
        password=pass;
    }
    public String getLogin()
    {
        return loginPlace;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
}