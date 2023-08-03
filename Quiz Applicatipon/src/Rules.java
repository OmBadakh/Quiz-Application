
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;

    Rules(String name) {
        //pm const.
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Quiz");
        heading.setBounds(220, 30, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>"+
                        "1.You have to solve 10 Question  " + "<br><br>" +
                        "2.Each Question have 30s to solve " + "<br><br>" +
                        "3.You can not able to go on previous Question " + "<br><br>" +
                        "4.You have one 50-50 lifeline " + "<br><br>" +
                        "5.Fill up your personal details carefully " + "<br><br>" +
                        "6.Make sure you click on submit button" + "<br><br>" +
                        "7.No talking to each other " + "<br><br>" +
                        "8. you table must be clear" + "<br><br>" +
                        "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {   //abstract meathod
        if (ae.getSource() == start) {
            setVisible(false);//closing the frame
            new Quiz(name); //creating object of Quiz class

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }  //if name is not enter by user so default it is user
}
