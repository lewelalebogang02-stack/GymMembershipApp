/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.gui;

/**
 *
 * @author Student
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import za.ac.tut.membership.Member;

public class GymMembershipFrame extends JFrame{
    
 private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractsPnl;
    private JPanel personalTrainerOptionPnl;
    private JPanel membershipPnl;
    private JPanel commentsPnl;
    private JPanel btnsPnl;
    private JPanel headingClientCombinedPnl;
    private JPanel membershipCommentsCombinedPnl;
    private JPanel mainPnl;
    
    //Labels
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel personalTrainerLbl;
    private JLabel contractTypeLbl;
    
    //TextFields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //TextArea
    private JTextArea commentsArea; 
    
    
    //ScrollableTextArea
    private JScrollPane scrollableTxtArea;
    //comboBox
    private JComboBox genderComboBox;
    
    //radio buttons
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsBtn;
    private JRadioButton annualRadBtn;
    private ButtonGroup btnGrp;
    
    //checkBox
    private JCheckBox personalTrainerChkBx;
    
    //buttons
    private JButton registerBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    private JButton searchBtn;
    private JButton removeBtn;
    private JButton updateBtn;
    private JButton displayBtn;
    
    private ArrayList<Member> members;
    
    public GymMembershipFrame()
    {
        setTitle("Gym Membership");
        setSize(500,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        members = new ArrayList<>();
        
        //create panels
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        clientPnl = new JPanel(new GridLayout(4,1,1,1));
        clientPnl.setBorder(new TitledBorder(new LineBorder(Color.GREEN,1),"Client Details"));
        
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout((FlowLayout.LEFT)));
        idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contractsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionPnl =   new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        membershipPnl   = new JPanel(new GridLayout(2,1,1,1));
        membershipPnl.setBorder(new TitledBorder(new LineBorder(Color.RED,1), "Contracts Optins"));
        
        commentsPnl = new JPanel (new FlowLayout(FlowLayout.LEFT));
        
        btnsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingClientCombinedPnl = new JPanel(new BorderLayout());
        membershipCommentsCombinedPnl = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        
        //create labels
        headingLbl = new JLabel("Membership Form");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        headingLbl.setForeground(Color.BLUE);
        
        nameLbl = new JLabel("Name:     ");
        surnameLbl = new JLabel("Surname:                ");
        idNoLbl = new JLabel("id no:        ");
        genderLbl = new JLabel("Gender:       ");
        contractTypeLbl = new JLabel("Type of contract:  ");
        
        personalTrainerLbl = new JLabel("Select the checkbox if you need a personal trainer");
        
          nameTxtFld = new JTextField(10);
         surnameTxtFld = new JTextField(10);
          idNoTxtFld = new JTextField(10);
          
          genderComboBox = new JComboBox();
          genderComboBox.addItem("Male");
          genderComboBox.addItem("Female");
          
          //create radio buttons
          
          monthToMonthRadBtn = new JRadioButton("Month-to-month");
          sixMonthsBtn = new JRadioButton("Six months");
          annualRadBtn = new JRadioButton("Annual");
          
          //create a checkbox
          personalTrainerChkBx = new JCheckBox();
          
          //create button group 
          btnGrp = new ButtonGroup();
          btnGrp.add(monthToMonthRadBtn);
          btnGrp.add(annualRadBtn);
          btnGrp.add(sixMonthsBtn);
          
          //create text area
          commentsArea = new JTextArea(15,50);
          commentsArea.setEditable(false);
          commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Member(s) details"));
          
          scrollableTxtArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          
          //create button
          registerBtn = new JButton("REGISTER");
          registerBtn.addActionListener(new RegisterBtnListener());
          
          searchBtn = new JButton("SEARCH");
          removeBtn = new JButton("REMOVE");
          updateBtn = new JButton("UPDATE");
          displayBtn = new JButton("DISPLAY ALL");
          clearBtn = new JButton("CLEAR");
          clearBtn.addActionListener(new ClearBtnListener());
          exitBtn = new JButton("EXIT");
          exitBtn.addActionListener(new ExitBtnListener());
          displayBtn.addActionListener(new DisplayBntListener());
          searchBtn.addActionListener(new SearchListener());
          
          
          //Creating Menubar
          
          JMenuBar menuBar = new JMenuBar();
          
          JMenu fileMenu = new JMenu("File");
          
          JMenuItem saveItem = new JMenuItem("Save");
          JMenuItem openItem = new JMenuItem("Open");
          
          
          
          fileMenu.add(saveItem);
          fileMenu.add(openItem);
          
          saveItem.addActionListener(new SaveItemListener());
          openItem.addActionListener(new OpenItemListener());
          menuBar.add(fileMenu);
          
          
           setJMenuBar(menuBar);
          
          
          
          //add components to panels
          headingPnl.add(headingLbl); //---> first collective panel
          
          namePnl.add(nameLbl);
          namePnl.add(nameTxtFld);
          
          surnamePnl.add(surnameLbl);
          surnamePnl.add(surnameTxtFld);
          
          idNoPnl.add(idNoLbl);
          idNoPnl.add(idNoTxtFld);
          
          genderPnl.add(genderLbl);
          genderPnl.add(genderComboBox);

          clientPnl.add(namePnl);  //--->second collective panel
          clientPnl.add(surnamePnl);
          clientPnl.add(idNoPnl);
          clientPnl.add(genderPnl);
          
          headingClientCombinedPnl.add(headingPnl,BorderLayout.NORTH);
          headingClientCombinedPnl.add(clientPnl, BorderLayout.CENTER);
          
          
          contractsPnl.add(contractTypeLbl);
          contractsPnl.add(monthToMonthRadBtn);
          contractsPnl.add(sixMonthsBtn);
          contractsPnl.add(annualRadBtn);
          
          personalTrainerOptionPnl.add(personalTrainerLbl);
          personalTrainerOptionPnl.add(personalTrainerChkBx);
          
          membershipPnl.add(contractsPnl);
          membershipPnl.add(personalTrainerOptionPnl);
          
          
          commentsPnl.add(scrollableTxtArea); //--->forth collective panel
          
          membershipCommentsCombinedPnl.add(membershipPnl, BorderLayout.NORTH);
          membershipCommentsCombinedPnl.add(commentsPnl, BorderLayout.CENTER);
          
          btnsPnl.add(registerBtn);
          btnsPnl.add(searchBtn);
          btnsPnl.add(updateBtn);
          btnsPnl.add(removeBtn);
          btnsPnl.add(displayBtn);
          btnsPnl.add(clearBtn);
          btnsPnl.add(exitBtn);
          
          mainPnl.add(headingClientCombinedPnl,BorderLayout.NORTH);
          mainPnl.add(membershipCommentsCombinedPnl, BorderLayout.CENTER);
          mainPnl.add(btnsPnl, BorderLayout.SOUTH);
          
          add(mainPnl);
          
          pack();
          
          setResizable(false);
          setVisible(true);
          
    }
    
    public class RegisterBtnListener implements ActionListener {
     
           public void actionPerformed(ActionEvent ae){
            
            String name = nameTxtFld.getText();
            String surname = surnameTxtFld.getText();
            String idNo = idNoTxtFld.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            Boolean isPersonalTrainerSelected = personalTrainerChkBx.isSelected();
            String contractType = "Month-to-month";
            
            if(sixMonthsBtn.isSelected()){
                contractType ="Six months";
            }else{
                if(annualRadBtn.isSelected()){
                    contractType ="Annual";
                }
            }
                    
     

        //create a gender
        Member member = new Member(name,surname,idNo, gender, contractType,isPersonalTrainerSelected);
        
        //add the member to the list
        members.add(member);
        
        //add aconfirmation message to the text area
        commentsArea.setText("The member has been successfully added");
    }

    }
private class ClearBtnListener implements ActionListener {
    
    public void actionPerformed(ActionEvent ae)
    {
        //clear the fields
        
        nameTxtFld.setText("");
        surnameTxtFld.setText("");
        idNoTxtFld.setText("");
        personalTrainerChkBx.setSelected(false);
        btnGrp.clearSelection();
        commentsArea.setText("");
        
        nameTxtFld.setFocusable(true);
    }
}
private class DisplayBntListener implements ActionListener{
    
    public void actionPerformed(ActionEvent ae)
    {
        String Output="";
        
        for(Member member:members)
        {
           Output +="\n "+member.getName()+" "+member.getSurname()+" "+member.getGender()+" "+member.getIdNo()+" "+member.getContractType()+" "+member.getIsPersonalTrainerNeeded();
        }
        
        commentsArea.setText(Output);
    }
}

private class ExitBtnListener implements ActionListener {
    
 public void actionPerformed(ActionEvent ae){
     
     System.exit(1);
     
}
} 
private class SaveItemListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e)
    {
       JFileChooser fileChooser = new JFileChooser();
       
       int res = fileChooser.showSaveDialog(null);
       
       if(res == JFileChooser.APPROVE_OPTION)
       {
           File myFile = fileChooser.getSelectedFile();
           
           try{
                FileWriter fw =new FileWriter(myFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                
                for(Member member: members)
                {
                    bw.write(member.getName()+" "+member.getSurname()+" "+member.getGender()+" "+member.getIdNo()+" "+member.getContractType()+" "+member.getIsPersonalTrainerNeeded());
                    bw.newLine();
                }
                
                JOptionPane.showMessageDialog(null, "We Have successfully written to a file");
                bw.close();
                
           }
           catch(IOException io)
           {
               JOptionPane.showMessageDialog(null,"File cdoes not exist!!!");
           }
           
       }
    }
}
private class OpenItemListener implements ActionListener
{
    public void actionPerformed(ActionEvent ae)
    {
        
         JFileChooser fileChooser = new JFileChooser();

        int res = fileChooser.showOpenDialog(null);

        if(res == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();

            try
            {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;
                String output = "";

                while((line = br.readLine()) != null)
                {
                    output += line + "\n";
                }

                commentsArea.setText(output);

                br.close();
            }
            catch(IOException io)
            {
                JOptionPane.showMessageDialog(null, "Error opening file");
            }
        }
    }

    
}

private class SearchListener implements ActionListener
{
    public void actionPerformed(ActionEvent ae)
    {
         String searchId = idNoTxtFld.getText();

        boolean found = false;

        for(Member member : members)
        {
            if(member.getIdNo().equals(searchId))
            {
                commentsArea.setText(
                        "Member found:\n\n" +
                        "Name: " + member.getName() + "\n" +
                        "Surname: " + member.getSurname() + "\n" +
                        "Gender: " + member.getGender() + "\n" +
                        "ID Number: " + member.getIdNo() + "\n" +
                        "Contract: " + member.getContractType() + "\n" +
                        "Personal Trainer: " + member.getIsPersonalTrainerNeeded()
                );

                found = true;
                break;
            }
        }

        if(!found)
        {
            commentsArea.setText("Member not found.");
        }
    }
    }
}


    
    


