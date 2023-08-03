 //patckegs
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Login extends JFrame implements ActionListener {  //jframe class
    JButton rules,back;          //global deceleration of
    JTextField tfname,jfpass,tfID,jfprn;       //by declearing globali
    Login(){
        //df constructor
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);  //for creating own layout not given by system

        //image icon class in jframe

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpg"));  //static method getsystem.....
        JLabel image =new JLabel(i1);
        image.setBounds(0,0,600,500);   //own layout
        add(image);    //add use for placement of element on frame by passing object of class

        //Title

        JLabel heading = new JLabel("Lets start");  //
        heading.setBounds(750,60,300,45);  //set bounce for placement on frame
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(new Color(30,144,254));
        add(heading);

    //name

        JLabel ID = new JLabel("Enter your College ");
        ID.setBounds(650,150,300,20);
        ID.setFont(new Font("Mongolian Batil",Font.BOLD,18));
        ID.setForeground(new Color(30,144,254));
        add(ID);

        //box for enteeing name

        tfID = new JTextField();
        tfID.setBounds(835,150,200,25);
        tfID.setFont(new Font("Time New Romain", Font.BOLD,20));
        add(tfID);

        JLabel pass = new JLabel("Your password ");
        pass.setBounds(650,200,300,20);
        pass.setFont(new Font("Mongolian Batil",Font.BOLD,18));
        pass.setForeground(new Color(30,144,254));
        add(pass);

        //box for enteeing name

        jfpass = new JTextField();
        jfpass.setBounds(835,200,200,25);
        jfpass.setFont(new Font("Time New Romain", Font.BOLD,20));
        add(jfpass);

        //
        JLabel name = new JLabel("Enter your name ");
        name.setBounds(650,250,300,20);
        name.setFont(new Font("Mongolian Batil",Font.BOLD,18));
        name.setForeground(new Color(30,144,254));
        add(name);

        //box for enteeing name

        tfname = new JTextField();
        tfname.setBounds(835,250,200,25);
        tfname.setFont(new Font("Time New Romain", Font.BOLD,20));
        add(tfname);

        //entering for prn

        JLabel prn = new JLabel("Your PRN ");
        prn.setBounds(650,300,300,20);
        prn.setFont(new Font("Mongolian Batil",Font.BOLD,18));
        prn.setForeground(new Color(30,144,254));
        add(prn);

        //box for enteeing name

        jfprn = new JTextField();
        jfprn.setBounds(835,300,200,25);
        jfprn.setFont(new Font("Time New Romain", Font.BOLD,20));
        add(jfprn);


        //button code

        rules =new JButton("Rule ");
        rules.setBounds(735,350,120,25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.BLACK);
        rules.addActionListener(this);   //use for click event
        add(rules);

        back =new JButton("Back ");
        back.setBounds(915,350,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);   //for click event addActionListener
        add(back);

        setSize(1200,500);
        setLocation(200,150);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){   //event handaling meathed
        if (ae.getSource()==rules){

            String ID = tfID.getText();//find the value in the text fild enterd by user
            String p = jfpass.getText();
            String name =tfname.getText();
            String prn = jfprn.getText();
            setVisible(false);  //for closing the current window and opening the new winddow ie rules window
            try {
                database d = new database();
                String q = "select * from Login where Name =  '" + ID + "' and Password = '" + p + "' "; //data base connection for cheaking the
                ResultSet rs = d.st.executeQuery(q);


                if(rs.next())
                {
                    setVisible(false);
                    new Rules(name);
                }
                else{
                    JOptionPane.showMessageDialog(null,"INVALID PASSWORD OR USERNAME");
                }
                String q1 = "insert into info values ( '"+name+"','"+prn+"')";  //update and to store the data
                d.st.executeUpdate(q1);
            }catch (Exception e)
            {
                e.printStackTrace();
            }


        }
        else {
            setVisible(false);  //funcation for disply
        }


    }
    public static void main(String[] arg)throws Exception {  //starter
        new Login();  //object of class
    }

    }
