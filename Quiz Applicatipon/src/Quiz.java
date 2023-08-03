
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{  // action listener come from awd event pack is a interface
    //we have to make 2d arry to store the question
    // action listenet use for applying event on butten

    //2d string type array
    String questions[][] = new String[10][5];  //no of quetions 10 in a row question and their 4 ans and 1 que it self so 5 col
    String answers[][] = new String[10][2];  //for storing questions ans 10 que ans
    String useranswers[][] = new String[10][1]; //array for traking the ans is given by uset or not

    //to declear the variable globali to explore the scope of variable out of this funcation

    JLabel qno, question;  //jbutten class
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    //decleration of globali

    public static int timer = 30;
    public static int ans_given = 0;  //find ans is given by user or not
    public static int count = 0; //inital value 0
    public static int score = 0;

    String name;  //decleating globali
    Quiz(String name){

        this.name = name;  //strting globali

        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Questions.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(80, 0, 1240, 352);
        add(image);

        qno = new JLabel("1");
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel("This is a question");
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        //question and their option


        questions[0][0] = "Number of primitive data types in Java are?";
        questions[0][1] = "7";
        questions[0][2] = "8";  //ans
        questions[0][3] = "6";
        questions[0][4] = "9";

        questions[1][0] = "What is the size of float and double in java?";
        questions[1][1] = "32 to 64";  //ans
        questions[1][2] = "32 to 32 ";
        questions[1][3] = "64 to 32";
        questions[1][4] = "none";

        questions[2][0] = "Select the valid statement";
        questions[2][1] = "char []ch = new char[5]";  //ans
        questions[2][2] = "char []ch = new char {5}";
        questions[2][3] = "char []ch = new char(5)";
        questions[2][4] = "None";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "copy of first element ";
        questions[3][2] = "A length of array ";
        questions[3][3] = "The reference to the array ";  //ans
        questions[3][4] = "A copy of array ";

        questions[4][0] = "Select the valid statement to declare and initialize an array.";
        questions[4][1] = "int[]A={}";
        questions[4][2] = "int[]A=(1,2,3)";
        questions[4][3] = "None";
        questions[4][4] = "int[]A={1,2,3}";     //ans

        questions[5][0] = "Arrays in java are-";
        questions[5][1] = "objects reference";
        questions[5][2] = "objects";    //ans
        questions[5][3] = "primativ";
        questions[5][4] = "None";

        questions[6][0] = "When is the object created with new keyword?";
        questions[6][1] = "At running time";    //ans
        questions[6][2] = "At compile time";
        questions[6][3] = "None";
        questions[6][4] = "Depend on code";

        questions[7][0] = "Identify the corrected definition of a package.";
        questions[7][1] = "A package is collection editing tool";
        questions[7][2] = "A package is collection of classes and interfaces";          //ans
        questions[7][3] = "Both";
        questions[7][4] = "None";

        questions[8][0] = "In which of the following is toString() method defined?";
        questions[8][1] = "java.lang.object";    //ans
        questions[8][2] = "java.lang.string";
        questions[8][3] = "Both";
        questions[8][4] = "None";

        questions[9][0] = "compareTo() returns";
        questions[9][1] = "An Int Value";      //ans
        questions[9][2] = "True";
        questions[9][3] = "False";
        questions[9][4] = "None";

        answers[0][1] = "8";
        answers[1][1] = "32 to 64";
        answers[2][1] = "char []ch = new char[5]";
        answers[3][1] = "The reference to the array ";
        answers[4][1] = "int[]A={1,2,3}";
        answers[5][1] = "objects";
        answers[6][1] =  "At running time";
        answers[7][1] =  "A package is collection of classes and interfaces";
        answers[8][1] = "java.lang.object";
        answers[9][1] = "An Int Value";

//by seleting one ans from many  ans for this we use jradio button like option butten

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        //butten group class for for grouping radio butten  it is use when we select on option then other option automatically get deselected

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.black);
        next.addActionListener(this);

        add(next);

        //jbutton local decleration

        lifeline = new JButton("50-50");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.black);
        lifeline.addActionListener(this);

        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.black);
        submit.addActionListener(this);

        submit.setEnabled(false);  //to disable the butten
        add(submit);

        start(count);

        setVisible(true);  //use to show the window visible
    }

    public void actionPerformed(ActionEvent ae) {  //for overiding un implemente meathod action perform
        if (ae.getSource() == next) {
             //when next butten has called we have to do
            repaint();
            opt1.setEnabled(true);  //enabling the option of 50 50 lifline disabled option
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1; //ans is given
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);  //disabling next
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            //when lifline butten has called the we have to do
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {  //check
                opt2.setEnabled(false);  //disabling option
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);  //disabling the lifline option if used once
        } else if (ae.getSource() == submit) {
            //if submit butten has called then we have to do
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            //creating object of score class
            new Score(name,score);

        }
    }


//graphic which has to be displaed on frame

    public void paint(Graphics g) {   //paint meathod do not have to call it called automatically

        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15  //timer decleat globali
        g.setColor(Color.RED);  //to change the colour

        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);  //display times up when finishing time
        }

        timer--; // 14

        try {              //we have to use repaint meathod for repainting the timer like 15 14 13
            Thread.sleep(1000);  //code of execuation have to stope for 1 s for inverse counting
            repaint();               //sleep is meathod in a multi threading class called thread
        } catch (Exception e) {
            e.printStackTrace();  //close by catch
        }

        if (ans_given == 1) {  //ans given so value 1
            ans_given = 0;
            timer = 30;
        } else if (timer < 0) {  //if ans if not given and timer is less than 0 then for displayin the next question
            timer = 30;
            opt1.setEnabled(true);  //by on going on next que 50-50 lifline disabled option get enabled
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button if user not submit then auto submit
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();  //group option we get selected option get selection value by we get actualoption
                }

                //score calculation
                for (int i = 0; i < useranswers.length; i++) {    //for caculatin score
                    if (useranswers[i][0].equals(answers[i][1])) {  //matching the ans
                        score += 10;  //if ans is correct
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);

                new Score(name,score);

            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1  //by count++ next que display
                start(count);
            }
        }

    }



    //cteating the start funcation
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");  //question is a lable in theat we cant pass the integer so the integer is converted in to string by " " in java

        question.setText(questions[count][0]); //1st position 1 st row 1st coloum
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);  //to set the value that we get

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();  //for cleating the previous selected option
    }

    public static void main(String[] args) {
        new Quiz("User");  //is parametrize constructur
    }
}
