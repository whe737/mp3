import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener
{
    private ArrayList<Account> accArr;

    JFrame frame=new JFrame("Byte Locker Login");
    JPanel main=new JPanel();
    JPanel log=new JPanel();
    JPanel register=new JPanel();
    CardLayout cardSwitch=new CardLayout();
    public LoginPage()
    {
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720,720);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
