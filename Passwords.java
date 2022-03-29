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
    public int compareTo(Passwords pass, boolean n)  //true if the comparison is for sites, false for usernames
    {
        if (n==true)
        {
            return this.loginPlace.toLowerCase().compareTo(pass.getLogin().toLowerCase());
        }
        else
        {
            return this.username.toLowerCase().compareTo(pass.getUsername().toLowerCase());
        }
    }   
    public String toString()
    {
        return "Login location: "+loginPlace+"\nUsername: "+username+"\nPassword: "+password+"\n";
    }
    public boolean equals(Object object)
    {
        if (((Passwords)object).getLogin().equals(this.loginPlace)&&((Passwords)object).getPassword().equals(this.password)&&((Passwords)object).getUsername().equals(this.username))
        {
            return true;
        }
        return false;
    }
}