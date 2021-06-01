package sk.stuba.fei.uim.oop.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    JTextField textField;
    JFrame myFrame;
    String displayNumber="";
    String signPressed="";

    private double finalNumber=0;
    private int numberPressed;
    private int operationNumber;

    public CalculatorFrame() {
        createCalculator();
    }
    public void createCalculator(){
        textField= new JTextField(10);
        JPanel text=new JPanel();
        text.add(textField);
        myFrame=new JFrame();
        myFrame.setSize(300,300);
        myFrame.setLayout(new GridLayout(0,1));
        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
        JPanel firstRow=new JPanel();
        JPanel secondRow=new JPanel();
        JPanel thirdRow=new JPanel();
        JPanel forthRow=new JPanel();

        JButton zero=new JButton("0");
        JButton one=new JButton("1");
        JButton two=new JButton("2");
        JButton three=new JButton("3");
        JButton four=new JButton("4");
        JButton five=new JButton("5");
        JButton six=new JButton("6");
        JButton seven=new JButton("7");
        JButton eight=new JButton("8");
        JButton nine=new JButton("9");
        JButton plus=new JButton("+");
        JButton minus=new JButton("-");
        JButton times=new JButton("*");
        JButton changePlusToMinus=new JButton("+/-");
        JButton clear=new JButton("CE");
        JButton equals=new JButton("=");

        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        times.addActionListener(this);
        changePlusToMinus.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);



        firstRow.add(zero);
        firstRow.add(changePlusToMinus);
        firstRow.add(clear);
        firstRow.add(equals);

        secondRow.add(one);
        secondRow.add(two);
        secondRow.add(three);
        secondRow.add(plus);

        thirdRow.add(four);
        thirdRow.add(five);
        thirdRow.add(six);
        thirdRow.add(minus);

        forthRow.add(seven);
        forthRow.add(eight);
        forthRow.add(nine);
        forthRow.add(times);

        myFrame.add(textField);
        myFrame.add(firstRow);
        myFrame.add(secondRow);
        myFrame.add(thirdRow);
        myFrame.add(forthRow);

        myFrame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pressedButton=e.getActionCommand();

        if (pressedButton.compareTo("0")>=0&&pressedButton.compareTo("9")<=0){
            displayNumber=displayNumber+pressedButton;
            textField.setText(displayNumber);

            numberPressed=Integer.parseInt(displayNumber);
        }
        if(numberPressed == 0){
            textField.setText(pressedButton);
        }

        else if (pressedButton.equals("+")||pressedButton.equals("-")||pressedButton.equals("*")||pressedButton.equals("+/-")){
            displayNumber="";
            signPressed=pressedButton;


            if (finalNumber==0){
                finalNumber=numberPressed;
            }
            else {
                doMaths();
            }
            textField.setText(pressedButton);
            }

        else if (pressedButton.equals("=")){
            doMaths();
            textField.setText(Double.toString(finalNumber));
        }

    }
    private void doMaths(){
        if (signPressed.equals("+")){
            finalNumber=finalNumber+numberPressed;
        }
        if (signPressed.equals("-")){
            finalNumber=finalNumber-numberPressed;
        }
        if (signPressed.equals("*")){
            finalNumber=finalNumber*numberPressed;
        }
        if (signPressed.equals("*/-")){
            finalNumber=-finalNumber;
        }
        numberPressed=0;
    }
}
