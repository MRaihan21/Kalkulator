package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator {

    public static void main(String[] args) {

        new kalkulator();

    }
}

class kalkulator implements ActionListener {

    JFrame frame;
    JTextField textField, text;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton, persenButton;
    JPanel panel;
    Font myFont = new Font("Inter", Font.BOLD, 22);
    Font myFont2 = new Font("Inter", Font.BOLD, 20);
    //new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0.0;
    char operator;
    int i;
    DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public kalkulator() {

        frame = new JFrame("Calculator");
        frame.setSize(335, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(null);

//        ImageIcon icon = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\calculator.png");
//        frame.setIconImage(icon.getImage());

        frame.setIconImage(new ImageIcon("C:\\Users\\A C E R\\Pictures\\Picture\\JavaPicture\\\\calculator.png").getImage());

        textField = new JTextField("0");
        textField.setBounds(10, 50, 300, 50);
        textField.setFont(myFont);
        textField.setForeground(Color.black);
        textField.setBackground(Color.green);
        textField.setEditable(false);

        text = new JTextField();
        text.setBounds(230, 20, 80, 25);
        text.setBackground(Color.black);
        text.setForeground(Color.white);
        text.setBorder(null);
        text.addActionListener(this);
        text.setEditable(false);
        frame.add(text);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(",");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CA");
        negButton = new JButton("(+/-)");
        persenButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = persenButton;

        for (i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont2);
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setBackground(new Color(44, 44, 44));
            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.black));
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setForeground(new Color(146, 146, 146));
            numberButtons[i].setBackground(new Color(44, 44, 44));
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.black));
            numberButtons[i].setFocusable(false);

        }

        panel = new JPanel();
        panel.setBounds(12, 115, 300, 370);
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(5, 4, 12, 12));

        panel.add(clrButton);
        panel.add(delButton);
        panel.add(persenButton);
        panel.add(divButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        equButton.setBackground(Color.green);
        panel.add(equButton);

        frame.add(panel);
        frame.add(textField);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            for (i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    if (textField.getText().equals("0")) {
                        textField.setText("");
                    }
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

                text.setText(text.getText().concat(String.valueOf(num1)).concat(" + "));
            }

            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");

                text.setText(text.getText().concat(String.valueOf(num1)).concat(" - "));
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");

                text.setText(text.getText().concat(String.valueOf(num1)).concat(" / "));
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");

                text.setText(text.getText().concat(String.valueOf(num1)).concat(" x "));
            }
            if (e.getSource() == persenButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText("");

                text.setText(text.getText().concat(String.valueOf(num1)).concat(" % "));
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
                    case '%' ->
                        result = num1 % num2;
                }

                textField.setText(String.valueOf(result));
                text.setText(text.getText().concat(String.valueOf(num2)).concat(" = "));
                num1 = result;
            }

            if (e.getSource() == clrButton) {
                textField.setText("0");
                text.setText("");
            }
            if (e.getSource() == delButton) {
                text.setText("");
                String string = textField.getText();
                if (string.length() > 1) {
                    string = string.substring(0, string.length() - 1);
                    textField.setText(string);
                } else if (string.length() == 1) {
                    textField.setText("0");
                }
            }

            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }

        } catch (Exception ex) {
            UIManager.put("OptionPane.background", Color.black);
            UIManager.put("Panel.background", Color.black);
            UIManager.put("OptionPane.messageForeground", Color.white);            
            

            JOptionPane.showInternalMessageDialog(frame.getContentPane(), "ERROR", "", JOptionPane.ERROR_MESSAGE);
        }
    }

}
