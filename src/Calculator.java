package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {

    public static void main(String[] args) {

        new kalkulator();        

    }

}

class kalkulator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public kalkulator() {

        frame = new JFrame("Calculator");
        frame.setSize(420, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
//        ImageIcon icon = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\calculator.png");
//        frame.setIconImage(icon.getImage());
        frame.setIconImage(new ImageIcon("C:\\\\Users\\\\A C E R\\\\Downloads\\\\JavaPicture\\\\calculator.png").getImage());
                
        textField = new JTextField();
        textField.setBounds(50, 75, 300, 50);
        textField.setFont(myFont);
        textField.setForeground(Color.black);
        textField.setBackground(new Color(10,255,25));
        textField.setEditable(true);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("D");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setForeground(new Color(10,255,25));
            functionButtons[i].setBackground(Color.gray);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setBackground(Color.gray);
            numberButtons[i].setFocusable(false);

        }

        negButton.setBounds(50, 460, 100, 50);
        delButton.setBounds(150, 460, 100, 50);
        clrButton.setBounds(250, 460, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 150, 300, 300);
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);                
        frame.add(textField);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));                
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));            
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());                        
            operator = '+';
            textField.setText("");
            
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());            
            operator = '-';
            textField.setText("");            
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());            
            operator = '/';
            textField.setText("");                        
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());            
            operator = '*';
            textField.setText("");            
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());            
            switch (operator) {
                case '+' ->
                    result = num1 + num2;
                case '-' ->
                    result = num1 - num2;
                case '*' ->
                    result = num1 * num2;
                case '/' ->
                    result = num1 / num2;
            }
            textField.setText(String.valueOf(result));            
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

}
