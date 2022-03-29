import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class Window implements ActionListener {
    JFrame frame=new JFrame("Byte Locker");
    CardLayout cardSwitch=new CardLayout();
    JPanel panel=new JPanel(null);
    JButton searchButt=new JButton();
    JButton addButt=new JButton();
    JButton sortButt=new JButton();
    JButton deleteButt=new JButton();
    JButton passGen=new JButton();
    JButton logout1=new JButton();
    JComboBox dropMenu;
    JTable table=new JTable();
    JPanel tablePanel=new JPanel(new BorderLayout());
    JScrollPane scrollPane=new JScrollPane();
    Account passArr;
    ArrayList<Passwords> tableData=new ArrayList<>();
    JFrame popUp=new JFrame();
    JButton backButton2=new JButton();  //back button for popUp
    ImageIcon back2=new ImageIcon(".//assets//Back.png");
    ImageIcon addBut=new ImageIcon(".//assets//addS.png");
    JButton addLogin=new JButton();
    JTextField website=new JTextField();
    JTextField username=new JTextField();
    JPasswordField password=new JPasswordField();
    ImageIcon addLog=new ImageIcon(".//assets//addLogin.png");
    JLabel logBG=new JLabel(addLog);
    ImageIcon deleteBGImg=new ImageIcon(".//assets//DeleteFrame.png");
    JLabel deleteBG=new JLabel(deleteBGImg);
    JButton deleteButton=new JButton();
    ImageIcon deleteIcon=new ImageIcon(".//assets//DeleteS.png");
    JLabel warn=new JLabel();
    JFrame popUp2=new JFrame();
    ImageIcon back3Icon=new ImageIcon(".//assets//Back.png");
    JButton backButton3=new JButton();  //back button for popUp2
    JLabel warn2=new JLabel();
    String[][] tableDisplayData;
    JTableHeader header;
    

    public Window(Account passArray)
    {
        this.passArr=passArray;
        tableData=passArr.getPasswords();
        System.out.println(tableData);
        // convertData();
        // System.out.println(Arrays.deepToString(tableDisplayData));
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
        tablePanel.setBounds(43,195,900,473);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        table.setDragEnabled(false);
        panel.add(tablePanel);

        //combobox
        String[] options={"Date Added","Website Ascending","Website Descending","Username Ascending","Username Descending"};
        dropMenu=new JComboBox<String>(options);
        dropMenu.setBounds(1000,150,204,50);

        panel.add(dropMenu);
        panel.add(table);
        panel.add(addButt);
        panel.add(passGen);
        panel.add(deleteButt);
        panel.add(searchButt);
        panel.add(sortButt);
        panel.add(logout1);
        panel.add(bgImg);
        
        popUp.setSize(500,537);
        popUp.setLocationRelativeTo(null);
        popUp.setResizable(false);
        popUp.setLayout(null);
        backButton2.setIcon(back2);
        appendButton(backButton2);
        backButton2.setBounds(50,400,154,44);
        popUp.add(warn);
        popUp.add(backButton2);
        warn.setBounds(175,340,300,52);
        warn.setForeground(Color.red);
        warn.setVisible(false);
        
        popUp2.setSize(500,537);
        popUp2.setLocationRelativeTo(null);
        popUp2.setResizable(false);
        popUp2.setLayout(null);
        backButton3.setIcon(back3Icon);
        appendButton(backButton3);
        backButton3.setBounds(50,400,154,44);
        popUp2.add(backButton3);
        popUp2.add(warn2);
        popUp2.add(deleteBG);
        warn2.setBounds(175,340,300,52);
        warn2.setForeground(Color.red);
        warn2.setVisible(false);


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
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Date Added"))
            {
                tableData=passArr.sortByChronologicalAscending();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Website Ascending"))
            {
                tableData=passArr.sortBySiteAscending();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Website Descending"))
            {
                tableData=passArr.sortBySiteDescending();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Username Ascending"))
            {
                tableData=passArr.sortByUsernameAscending();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Username Descending"))
            {
                tableData=passArr.sortByUsernameDescending();
            }
            System.out.println();
            System.out.println(tableData);
        }
        if (e.getSource()==addButt)
        {
            //ADD BUTTON 
            popUp.setVisible(true);
            popUp.setTitle("Add Password");
            logBG.setBounds(-8,0,500,500);
            logBG.setVisible(true);
            appendButton(addLogin);
            addLogin.setIcon(addBut);
            addLogin.setBounds(275,400,154,44);
            website.setBounds(159,98,300,52);
            appendTextFields(website);
            username.setBounds(159,194,300,52);
            appendTextFields(username);
            password.setBounds(159,280,300,52);
            appendTextFields(password);
            
            popUp.add(addLogin);
            popUp.add(website);
            popUp.add(username);
            popUp.add(password);
            popUp.add(logBG);
        }
        if (e.getSource()==backButton2)
        {
            website.setText("");
            username.setText("");
            password.setText("");
            popUp.setVisible(false);
        }
        if (e.getSource()==addLogin)
        {
            System.out.println("addlogin pressed");
            if (website.getText().equals(""))
            {
                warn.setText("Please enter a website.");
                warn.setVisible(true);
            }  
            else
            {
                if (username.getText().equals(""))
                {
                    warn.setText("Please enter a username.");
                    warn.setVisible(true);
                }
                else
                {
                    if (String.valueOf(password.getPassword()).equals(""))
                    {
                        warn.setText("Please enter a password.");
                        warn.setVisible(true);
                    }
                    else
                    {
                        warn.setVisible(false);
                        passArr.addPassword(new Passwords(website.getText(), username.getText(), String.valueOf(password.getPassword())));
                        website.setText("");
                        username.setText("");
                        password.setText("");
                        popUp.setVisible(false);
                    }
                }
            }
        }
        if (e.getSource()==deleteButt)
        {
            //DELETE BUTTON
            popUp2.setVisible(true);
            popUp2.setTitle("Delete Login");
            deleteBG.setBounds(-8,0,500,500);
            deleteBG.setVisible(true);
            appendButton(deleteButton);
            deleteButton.setIcon(deleteIcon);
            deleteButton.setBounds(275,400,154,44);
            website.setBounds(159,98,300,52);
            appendTextFields(website);
            username.setBounds(159,189,300,52);
            appendTextFields(username);
            password.setBounds(159,280,300,52);
            appendTextFields(password);
                        
            popUp2.add(backButton3);
            popUp2.add(deleteButton);
            popUp2.add(website);
            popUp2.add(username);
            popUp2.add(password);
            popUp2.add(deleteBG);
        }
        if (e.getSource()==backButton3)
        {
            website.setText("");
            username.setText("");
            password.setText("");
            popUp2.setVisible(false);
        }
        if (e.getSource()==deleteButton)
        {
            System.out.println("deleteButton pressed");
            if (website.getText().equals(""))
            {
                warn2.setText("Please enter a website.");
                warn2.setVisible(true);
            }  
            else
            {
                if (username.getText().equals(""))
                {
                    warn2.setText("Please enter a username.");
                    warn2.setVisible(true);
                }
                else
                {
                    if (String.valueOf(password.getPassword()).equals(""))
                    {
                        warn2.setText("Please enter a password.");
                        warn2.setVisible(true);
                    }
                    else
                    {
                        Passwords tempPasswords=new Passwords(website.getText(), username.getText(), String.valueOf(password.getPassword()));
                        boolean temp=false;
                        int index=-1;
                        for (int i=0;i<passArr.getAmountOfPasswords();i++)
                        {
                            if (passArr.getPassAtIndex(i).equals(tempPasswords))
                            {
                                temp=true;
                                index=i;
                            }
                        }
                        if (temp)
                        {
                            passArr.removePassword(index);
                            popUp2.setVisible(false);
                        }
                        else
                        {
                            warn2.setText("Account not found.");
                            warn2.setVisible(true);
                        }
                    }
                }
            }
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
    public void appendTextFields(JTextField a)
    {
        a.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }
    public void appendTextFields(JPasswordField a)
    {
        a.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }
    public void convertData()
    {
        tableDisplayData=new String[tableData.size()][3];
        int counter=0;
        for (int i=passArr.getAmountOfPasswords()-1;i>=0;i--)
        {
            tableDisplayData[counter][0]=tableData.get(i).getLogin();
            tableDisplayData[counter][1]=tableData.get(i).getUsername();
            tableDisplayData[counter][2]=tableData.get(i).getPassword();
            counter++;
        }
    }
    public void updateTable()
    {
        convertData();
        table=new JTable();
        for (int i=0;i<tableDisplayData.length;i++)
        {
            table.addrow
        }
        scrollPane.setViewportView(table);
    }
}
