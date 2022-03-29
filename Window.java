import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

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
    JComboBox dropMenu;
    JTable table=new JTable();
    //=new JTable(new DefaultTableModel(new Object[]{"Column1", "Column2"}))
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
    JTextField website2=new JTextField();
    JTextField username2=new JTextField();
    JPasswordField password2=new JPasswordField();
    ImageIcon searchFrameBG=new ImageIcon(".//assets//SearchFrame.png");
    ImageIcon searchBackBG=new ImageIcon(".//assets//Back.png");
    ImageIcon searchButtBg=new ImageIcon(".//assets//SearchS.png");
    JButton searchBack=new JButton();
    JButton searchButton=new JButton();
    JLabel searchBG=new JLabel(searchFrameBG);
    JTextField searchWebsiteField=new JTextField();
    JTextField searchUsernameField=new JTextField();
    JLabel searchWarn=new JLabel();
    JFrame searchFrame=new JFrame();
    JFrame genFrame=new JFrame();
    ImageIcon passwordBG=new ImageIcon(".//assets//passwordBG.png");
    ImageIcon genBackBg=new ImageIcon(".//assets//Back.png");
    ImageIcon copyBG=new ImageIcon(".//assets//Copy.png");
    ImageIcon genButtonBG=new ImageIcon(".//assets//Generate.png");
    JLabel passwordgenBG=new JLabel(passwordBG);
    JButton genBackButton=new JButton();
    JButton generateButton=new JButton();
    JButton copyButton=new JButton();
    JLabel displayPassword=new JLabel();
    JLabel displayCopyConfirmation=new JLabel("Copied.");
    String generatedPassword="";
    
    public Window(Account passArray)
    {
        this.passArr=passArray;
        tableData=passArr.getPasswords();
        updateTable();
        // System.out.println(Arrays.deepToString(tableDisplayData));
        //System.out.println(tableData);
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
        table.setRowHeight(40);
        table.setDragEnabled(false);
        tablePanel.setBounds(43,195,900,473);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        panel.add(tablePanel);

        //combobox
        String[] options={"Date Added","Website Ascending","Website Descending","Username Ascending","Username Descending"};
        dropMenu=new JComboBox<String>(options);
        dropMenu.setBounds(1000,150,204,50);

        //main panel
        panel.add(dropMenu);
        panel.add(addButt);
        panel.add(passGen);
        panel.add(deleteButt);
        panel.add(searchButt);
        panel.add(sortButt);
        panel.add(logout1);
        panel.add(bgImg);
        
        //add password popup
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
        
        //delete password popup
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
        popUp2.setTitle("Delete Login");
        deleteBG.setBounds(-8,0,500,500);
        deleteBG.setVisible(true);
        appendButton(deleteButton);
        deleteButton.setIcon(deleteIcon);
        deleteButton.setBounds(275,400,154,44);
        website2.setBounds(159,98,300,52);
        appendTextFields(website2);
        username2.setBounds(159,189,300,52);
        appendTextFields(username2);
        password2.setBounds(159,280,300,52);
        appendTextFields(password2);
                    
        popUp2.add(backButton3);
        popUp2.add(deleteButton);
        popUp2.add(website2);
        popUp2.add(username2);
        popUp2.add(password2);
        popUp2.add(deleteBG);

        //search popup
        searchFrame.setSize(500,537);
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setLayout(null);
        searchFrame.setResizable(false);
        searchFrame.setTitle("Search");
        searchBG.setBounds(-8,0,500,500);
        appendButton(searchBack);
        searchBack.setBounds(50,400,154,44);
        searchBack.setIcon(searchBackBG);
        searchButton.setIcon(searchButtBg);
        appendButton(searchButton);
        searchButton.setBounds(275,400,154,44);
        searchWebsiteField.setBounds(157,98,300,52);
        appendTextFields(searchWebsiteField);
        appendTextFields(searchUsernameField);
        searchUsernameField.setBounds(157,252,300,52);
        searchBG.setVisible(true);
        searchWarn.setBounds(175,325,300,52);
        searchWarn.setForeground(Color.red);
        searchWarn.setText("Result not found.");
        searchFrame.add(searchWarn);
        searchFrame.add(searchWebsiteField);
        searchFrame.add(searchUsernameField);
        searchFrame.add(searchButton);
        searchFrame.add(searchBack);
        searchFrame.add(searchBG);

        //generate popup
        genFrame.setSize(500,537);
        genFrame.setLocationRelativeTo(null);
        genFrame.setLayout(null);
        genFrame.setResizable(false);
        genFrame.setTitle("Password Generator");
        passwordgenBG.setBounds(-8,0,500,500);
        passwordgenBG.setVisible(true);
        genBackButton.setIcon(genBackBg);
        appendButton(genBackButton);
        genBackButton.setBounds(50,400,154,44);
        copyButton.setIcon(copyBG);
        appendButton(copyButton);
        copyButton.setBounds(163,320,154,44);
        appendButton(generateButton);
        generateButton.setIcon(genButtonBG);
        generateButton.setBounds(275,400,154,44);
        displayPassword.setBounds(220,220,300,52);
        displayPassword.setFont(displayPassword.getFont().deriveFont((float) 20.0));
        displayCopyConfirmation.setBounds(200,270,154,44);
        displayCopyConfirmation.setVisible(false);
        displayCopyConfirmation.setForeground(Color.red);
        genFrame.add(displayCopyConfirmation);
        genFrame.add(displayPassword);
        genFrame.add(generateButton);
        genFrame.add(copyButton);
        genFrame.add(genBackButton);
        genFrame.add(passwordgenBG);

        //frame
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
                updateTable();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Website Ascending"))
            {
                tableData=passArr.sortBySiteAscending();
                updateTable();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Website Descending"))
            {
                tableData=passArr.sortBySiteDescending();
                updateTable();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Username Ascending"))
            {
                tableData=passArr.sortByUsernameAscending();
                updateTable();
            }
            if (String.valueOf(dropMenu.getSelectedItem()).equals("Username Descending"))
            {
                tableData=passArr.sortByUsernameDescending();
                updateTable();
            }
            System.out.println();
            System.out.println(tableData);
        }
        if (e.getSource()==addButt)
        {
            warn.setVisible(false);
            popUp.setVisible(true);
            website.requestFocusInWindow();
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
                        username.setText("");
                        password.setText("");
                        website.setText("");
                        popUp.setVisible(false);
                        convertData();
                        updateTable();
                    }
                }
            }
        }
        if (e.getSource()==deleteButt)
        {
            //DELETE BUTTON
            popUp2.setVisible(true);
            warn2.setVisible(false);
            website2.requestFocusInWindow();
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
            if (website2.getText().equals(""))
            {
                warn2.setText("Please enter a website.");
                warn2.setVisible(true);
            }  
            else
            {
                if (username2.getText().equals(""))
                {
                    warn2.setText("Please enter a username.");
                    warn2.setVisible(true);
                }
                else
                {
                    if (String.valueOf(password2.getPassword()).equals(""))
                    {
                        warn2.setText("Please enter a password.");
                        warn2.setVisible(true);
                    }
                    else
                    {
                        Passwords tempPasswords=new Passwords(website2.getText(), username2.getText(), String.valueOf(password2.getPassword()));
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
                        updateTable();
                    }
                }
            }
            website2.setText("");
            username2.setText("");
            password2.setText("");
        }
        if (e.getSource()==searchButt)
        {
            searchWarn.setVisible(false);
            searchFrame.setVisible(true);
        }
        if (e.getSource()==searchBack)
        {
            searchFrame.setVisible(false);
        }
        if (e.getSource()==searchButton)
        {
            if (searchWebsiteField.getText().equals("")&&searchUsernameField.getText().equals(""))
            {
                searchWarn.setText("Please enter a criteria field.");
                searchWarn.setVisible(true);
            }
            else if (!searchWebsiteField.getText().equals("")&&searchUsernameField.getText().equals(""))
            {
                tableData=passArr.search(searchWebsiteField.getText(), true);
                updateTable();
            }
            else if (searchWebsiteField.getText().equals("")&&!searchUsernameField.getText().equals(""))
            {
                tableData=passArr.search(searchUsernameField.getText(), false);
                updateTable();
            }
            else 
            {
                tableData=passArr.search(searchWebsiteField.getText(), searchUsernameField.getText());
                updateTable();
            }
        }
        if (e.getSource()==passGen)
        {
            generatedPassword=passArr.generatePassword();
            displayPassword.setText(generatedPassword);
            displayPassword.setVisible(true);
            genFrame.setVisible(true);
        }
        if (e.getSource()==genBackButton)
        {
            genFrame.setVisible(false);
        }
        if (e.getSource()==generateButton)
        {
            displayCopyConfirmation.setVisible(false);
            generatedPassword=passArr.generatePassword();
            displayPassword.setText(generatedPassword);
            displayPassword.setVisible(true);
        }
        if (e.getSource()==copyButton)
        {
            displayCopyConfirmation.setVisible(true);
            StringSelection StringSelection=new StringSelection(generatedPassword);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(StringSelection, null);
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
        for (int i=0;i<tableData.size();i++)
        {
            tableDisplayData[counter][0]=tableData.get(i).getLogin();
            tableDisplayData[counter][1]=tableData.get(i).getUsername();
            tableDisplayData[counter][2]=tableData.get(i).getPassword();
            counter++;
        }
        counter=0;
    }
    public void updateTable()
    {
        convertData();
        String column[]={"Website","Username","Passwords"};
        String data[][]=tableDisplayData;
        table=new JTable(data,column);
        table.setRowHeight(40);
        table.setDragEnabled(false);
        scrollPane.setViewportView(table);
    }
}
