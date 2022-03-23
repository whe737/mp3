import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener
{
    private ArrayList<Account> accArr;

    JFrame frame=new JFrame("Byte Locker Login");
    CardLayout cardSwitch=new CardLayout();
    JPanel superPanel=new JPanel(cardSwitch);
    JPanel main=new JPanel(null);
    JPanel log=new JPanel(null);
    JPanel register=new JPanel(null);
    JTextField userField=new JTextField();
    JPasswordField passField=new JPasswordField();
    JButton loginButton=new JButton();
    JButton registerButton=new JButton();

    public LoginPage()
    {
        //main page
        ImageIcon bg=new ImageIcon(".//assets//Frame 1.png");
        ImageIcon lg=new ImageIcon(".//assets//LoginButton.png");
        ImageIcon reg=new ImageIcon(".//assets//RegisterButton.png");
        JLabel bgImage=new JLabel(bg);
        bgImage.setBounds(0,0,900,720);
        bgImage.setVisible(true);
        userField.setBounds(510,266,300,52);
        userField.setBorder(javax.swing.BorderFactory.createEmptyBorder());  //removes border from textfields
        passField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passField.setBounds(510,384,300,52);
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
        main.add(bgImage);
        main.add(userField);
        main.add(passField);
        superPanel.add(main, "main");

        //register page


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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==registerButton)
        {
            cardSwitch.show(superPanel, "register");
        }
        if (e.getSource()==loginButton)
        {
            Account temp=new Account(userField.getText(),passField.getPassword());
            for (Account i:accArr)
            {
                if (i.equals())
            }
        }
    }
}
