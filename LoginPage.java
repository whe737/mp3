import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener
{
    private ArrayList<Account> accArr= new ArrayList<>();
    //Main array=new Main();
    JFrame frame=new JFrame("Byte Locker Login");
    CardLayout cardSwitch=new CardLayout();
    JPanel superPanel=new JPanel(cardSwitch);
    JPanel main=new JPanel(null);
    JPanel log=new JPanel(null);
    JPanel register=new JPanel(null);
    JTextField userField=new JTextField();
    JPasswordField passField=new JPasswordField();
    JTextField userField2=new JTextField();
    JPasswordField passField2=new JPasswordField();
    JPasswordField confirmPass=new JPasswordField();
    JTextField captcha=new JTextField();
    JButton loginButton=new JButton();
    JButton registerButton=new JButton();
    JButton registerButton2=new JButton();
    JButton backButton=new JButton();
    JLabel captchaLabel;
    JLabel warningLabel=new JLabel();
    int generatedCode=genCaptcha();
    JLabel loginFail=new JLabel();

    public LoginPage()
    {
        accArr=Main.getAccounts();
        //System.out.println(accArr);
        //main page
        ImageIcon bg=new ImageIcon(".//assets//Frame 1.png");
        ImageIcon lg=new ImageIcon(".//assets//LoginButton.png");
        ImageIcon reg=new ImageIcon(".//assets//RegisterButton.png");
        JLabel bgImage=new JLabel(bg);
        bgImage.setBounds(0,0,900,720);
        bgImage.setVisible(true);
        loginFail.setForeground(Color.red);
        userField.setBounds(510,229,300,52);
        userField.setBorder(javax.swing.BorderFactory.createEmptyBorder());  //removes border from textfields
        passField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passField.setBounds(510,344,300,52);
        loginButton.setVisible(true);
        loginButton.setIcon(lg);
        loginButton.setFocusable(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setBounds(580,453,154,44);
        loginButton.addActionListener(this);
        registerButton.setIcon(reg);
        registerButton.setVisible(true);
        registerButton.setFocusable(false);
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setBounds(580,541,154,44);
        registerButton.addActionListener(this);
        main.add(registerButton);
        main.add(loginButton);
        main.add(loginFail);
        main.add(bgImage);
        main.add(userField);
        main.add(passField);
        superPanel.add(main, "main");

        //register page
        ImageIcon regBg=new ImageIcon(".//assets//Frame 2.png");
        ImageIcon reg2=new ImageIcon(".//assets//RegisterButton.png");
        ImageIcon backBut=new ImageIcon(".//assets//Back.png");
        captchaLabel=new JLabel(""+generatedCode);
        JLabel regBackImage=new JLabel(regBg);
        regBackImage.setBounds(0,0,900,720);
        regBackImage.setVisible(true);
        registerButton2.setVisible(true);
        registerButton2.setIcon(reg2);
        registerButton2.setFocusable(false);
        registerButton2.setFocusPainted(false);
        registerButton2.setBorderPainted(false);
        registerButton2.setContentAreaFilled(false);
        registerButton2.setBounds(573,588,154,44);
        registerButton2.addActionListener(this);
        backButton.setVisible(true);
        backButton.setIcon(backBut);
        backButton.setFocusable(false);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setBounds(573,648,154,44);
        backButton.addActionListener(this);
        userField2.setBounds(500,170,300,52);
        userField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());  //removes border from textfields
        passField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passField2.setBounds(500,280,300,52);
        confirmPass.setBounds(500,390,300,52);
        confirmPass.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        captcha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        captcha.setBounds(604,491,95,31);
        captchaLabel.setBounds(720,455,95,31);
        captchaLabel.setVisible(true);
        warningLabel.setBounds(602,500,300,100);
        warningLabel.setVisible(false);
        warningLabel.setForeground(Color.red);
        register.add(captchaLabel);
        register.add(registerButton2);
        register.add(backButton);
        register.add(userField2);
        register.add(passField2);
        register.add(warningLabel);
        register.add(captcha);
        register.add(confirmPass);
        register.add(regBackImage);
        superPanel.add(register,"register");

        //login page
        frame.add(superPanel);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,757);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
        cardSwitch.show(superPanel, "main");
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==registerButton)
        {
            cardSwitch.show(superPanel, "register");
        }
        if (e.getSource()==loginButton)
        {
            Boolean loginFound=false;
            Account temp=new Account(userField.getText(),String.valueOf(passField.getPassword()));
            for (Account i:accArr)
            {
                if (i.equals(temp))
                {
                    //System.out.println("Logged to "+userField.getText());
                    new Window(i);
                    loginFound=true;
                    frame.dispose();
                }
            }
            if (loginFound==false)
            {
                loginFail.setText("Please try again.");
                loginFail.setBounds(615,400,300,54);
            }
            temp=new Account();
        }
        if (e.getSource()==registerButton2)
        {
            //System.out.println("Account creation requested with username of "+userField2.getText()+" and password of "+String.valueOf(passField2.getPassword()));
            boolean dupeName=false;
            for (Account i:accArr)
            {
                if (i.getUsername().equals(userField2.getText()))
                {
                    dupeName=true;
                }
            }
            if (dupeName)
            {
                warningLabel.setBounds(565,500,300,100);
                warningLabel.setText("Please change your username.");
                warningLabel.setVisible(true);
            }
            else if (captcha.getText().equals("")||Integer.parseInt(captcha.getText())!=generatedCode)
            {
                warningLabel.setBounds(602,500,300,100);
                warningLabel.setText("Redo Captcha.");
                warningLabel.setVisible(true);
                generatedCode=genCaptcha();
                captchaLabel.setText(""+generatedCode);
            }
            else if (userField2.getText().equals(""))
            {
                warningLabel.setBounds(602,500,300,100);
                warningLabel.setText("Username cannot be blank.");
                warningLabel.setVisible(true);
                generatedCode=genCaptcha();
                captchaLabel.setText(""+generatedCode);
            }
            else
            {
                if (!String.valueOf(passField2.getPassword()).equals("")||!String.valueOf(confirmPass.getPassword()).equals(""))
                {
                    if (!String.valueOf(passField2.getPassword()).equals(String.valueOf(confirmPass.getPassword())))
                    {
                        warningLabel.setText("Passwords do not match up.");
                        warningLabel.setVisible(true);
                        generatedCode=genCaptcha();
                        captchaLabel.setText(""+generatedCode);
                    }
                    else 
                    {
                        if (Account.passwordIsStrongEnough(String.valueOf(passField2.getPassword())).equals("Strong"))
                        {
                            //System.out.print("Account made with username "+userField2.getText()+" and password "+String.valueOf(passField2.getPassword()));
                            Main.addAccount(new Account(userField2.getText(),String.valueOf(passField2.getPassword())));
                            accArr=Main.getAccounts();
                            cardSwitch.show(superPanel, "main");
                        }
                        else 
                        {
                            warningLabel.setText(Account.passwordIsStrongEnough(String.valueOf(passField2.getPassword())));
                            warningLabel.setBounds(500,500,300,100);
                            warningLabel.setVisible(true);
                        }
                    }
                }
                else
                {
                    warningLabel.setText("Please type a password.");
                    warningLabel.setVisible(true);
                    generatedCode=genCaptcha();
                    captchaLabel.setText(""+generatedCode);
                }
            }
        }
        if (e.getSource()==backButton)
        {
            cardSwitch.show(superPanel, "main");
        }
    }
    public int genCaptcha()
    {
        return (int) (Math.random()*899999+100000);
    }
}
