import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Window implements ActionListener{
    JFrame frame=new JFrame("Byte Locker");
    CardLayout cardSwitch=new CardLayout();
    JPanel panel=new JPanel(null);
    JButton searchButt=new JButton();
    JButton addButt=new JButton();
    JButton sortButt=new JButton();
    JButton deleteButt=new JButton();
    JButton passGen=new JButton();
    JButton logout1=new JButton();
    JComboBox drop=new JComboBox<>();
    JTable table=new JTable();
    JPanel tablePanel=new JPanel(new BorderLayout());
    JScrollPane scrollPane=new JScrollPane();
    Account passArr;


    public Window(Account passArr)
    {
        this.passArr=passArr;
        //imageicons
        ImageIcon backBG=new ImageIcon(".//assets//Frame 3.png");
        ImageIcon logIcon1=new ImageIcon(".//assets//Logout.png");
        ImageIcon add=new ImageIcon(".//assets//Add.png");
        ImageIcon search=new ImageIcon(".//assets//Search Button.png");
        ImageIcon delet=new ImageIcon(".//assets//Delete Button.png");
        ImageIcon sort=new ImageIcon(".//assets//Sort Button.png");
        ImageIcon passwordGen=new ImageIcon(".//assets/Password Generator.png");
        //background
        JLabel bgImg=new JLabel(backBG);
        bgImg.setBounds(-7,0,1280,720);
        bgImg.setVisible(true);
        //buttons
        appendButton(sortButt);
        sortButt.setIcon(sort);
        sortButt.setBounds(1000,226,204,56);
        deleteButt.setIcon(delet);
        appendButton(deleteButt);
        deleteButt.setBounds(1000,505,204,56);
        searchButt.setIcon(search);
        appendButton(searchButt);
        searchButt.setBounds(1000,319,204,54);
        passGen.setIcon(passwordGen);
        appendButton(passGen);
        passGen.setBounds(1000,598,204,54);
        appendButton(addButt);
        addButt.setIcon(add);
        addButt.setBounds(1000,409,204,56);
        appendButton(logout1);
        logout1.setIcon(logIcon1);
        logout1.setBounds(1030,30,204,56);
        //table
        tablePanel.setBounds(43,195,933,473);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        panel.add(tablePanel);


        panel.add(table);
        panel.add(addButt);
        panel.add(passGen);
        panel.add(deleteButt);
        panel.add(searchButt);
        panel.add(sortButt);
        panel.add(logout1);
        panel.add(bgImg);


        frame.add(panel);
        frame.setBounds(0,0,1280,757);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==logout1)
        {
            new LoginPage();
            frame.dispose();
        }
        if (e.getSource()==sortButt)
        {

        }
    }
    public void appendButton(JButton a)
    {
        a.setFocusable(false);
        a.setContentAreaFilled(false);
        a.setFocusPainted(false);
        a.setBorderPainted(false);
        a.addActionListener(this);
        a.setVisible(true);
    }
}
