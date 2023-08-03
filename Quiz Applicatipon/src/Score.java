import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JButton End,submit;  //globale decleration
    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//image insettion and addition of haeading is similar as that as login class

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);  //image size decletation
        ImageIcon i3 = new ImageIcon(i2);  //i1 i2 image class object
        JLabel image = new JLabel(i3);
        image.setBounds(0, 150, 300, 250);  //placement of image coordinats
        add(image);

//Jlable is a local decleration

        JLabel heading = new JLabel("Thank You " + name + " for playing Quiz");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        submit = new JButton("Play Again");
        submit.setBounds(320, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        End = new JButton("END the Quiz");
        End.setBounds(500, 270, 120, 30);
        End.setBackground(new Color(30, 144, 255));
        End.setForeground(Color.WHITE);
        End.addActionListener(this);
        add(End);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit){
            setVisible(false);
            new Login();
    }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}