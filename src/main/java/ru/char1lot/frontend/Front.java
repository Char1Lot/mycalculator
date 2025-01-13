package ru.char1lot.frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front {

    private static int width = 300;
    private static int height = 400;
    private static String print = "0";
    private static String input = "0";
    private static Double arg1 = 0.0;
    private static Double arg2 = arg1;
    private static short operation = 0;
    // (0 = nan)(1 = +)(2 = -)(3 = X)(4 = /)(5 = MOD)


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel(print);
        Font font = new Font("Arial", Font.BOLD, 24);
        resultLabel.setFont(font);
        resultLabel.setBounds(width - (resultLabel.getPreferredSize().width + 20),0,resultLabel.getPreferredSize().width,resultLabel.getPreferredSize().height);
        System.out.println(resultLabel.getSize());
        //height = 28;

        ActionListener numberButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton)e.getSource();
                String inputText = clickedButton.getText();
                if(input.contains(".") && inputText == "."){
                    return;
                }


                input += inputText;
                if(input.charAt(0) == '0' && !input.contains(".")){
                    input = input.substring(1,input.length());
                }
                print = input;
                resultLabel.setText(print);
            }
        };

        ActionListener funcButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton)e.getSource();
                String func = clickedButton.getText();
                switch (func){
                    case "+/-":
                        arg1 = Double.parseDouble(input);
                        arg1 = -arg1;
                        print = arg1.toString();
                        input = "0";
                        resultLabel.setText(print);
                        break;
                    case "1/x":
                        arg1 = Double.parseDouble(input);
                        arg1 = 1/arg1;
                        print = arg1.toString();
                        resultLabel.setText(print);
                        break;
                    case "x^2":
                        arg1 = Double.parseDouble(input);
                        arg1 = arg1 * arg1;
                        print = arg1.toString();
                        resultLabel.setText(print);
                        break;
                    case "sqrt(x)":
                        arg1 = Double.parseDouble(input);
                        if(arg1 < 0){
                            print = "Корень отрицательного числа";
                        } else {
                            arg1 = Math.sqrt(arg1);
                            print = arg1.toString();
                        }
                        resultLabel.setText(print);
                        break;
                    case "+":
                        arg1 = Double.parseDouble(input);
                        operation = 1;
                        input = "";
                        break;
                    case "-":
                        arg1 = Double.parseDouble(input);
                        operation = 2;
                        input = "";
                        break;
                    case "X":
                        arg1 = Double.parseDouble(input);
                        operation = 3;
                        input = "";
                        break;
                    case "/":
                        arg1 = Double.parseDouble(input);
                        operation = 4;
                        input = "";
                        break;
                    case "%":
                        arg1 = Double.parseDouble(input);
                        operation = 5;
                        input = "";
                        break;
                    case "C":
                        print = "0";
                        input = "0";
                        arg1 = 0.0;
                        arg2 = arg1;
                        operation = 0;
                        resultLabel.setText(print);
                        break;
                    case "<<":
                        if(input != "") {
                            input = input.substring(0, input.length() - 1);
                            print = input;
                            resultLabel.setText(print);
                            break;
                        }
                        break;
                    case "=":
                        if(operation == 1){
                            arg2 = Double.parseDouble(input);
                            arg1 = arg1 + arg2;
                            input = "";
                            print = arg1.toString();
                            resultLabel.setText(print);
                            break;
                        }
                        if(operation == 2){
                            arg2 = Double.parseDouble(input);
                            arg1 = arg1 - arg2;
                            input = "";
                            print = arg1.toString();
                            resultLabel.setText(print);
                            break;
                        }
                        if(operation == 3){
                            arg2 = Double.parseDouble(input);
                            arg1 = arg1 * arg2;
                            input = "";
                            print = arg1.toString();
                            resultLabel.setText(print);
                            break;
                        }
                        if(operation == 4){
                            arg2 = Double.parseDouble(input);
                            if(arg2 == 0.0){
                                print = "Деление на ноль невозможно";
                                input = "";
                                resultLabel.setText(print);
                                break;
                            }
                            arg1 = arg1 / arg2;
                            input = "";
                            print = arg1.toString();
                            resultLabel.setText(print);
                            break;
                        }
                        if(operation == 5){
                            arg2 = Double.parseDouble(input);
                            if(arg2 == 0.0){
                                print = "Деление на ноль невозможно";
                                input = "";
                                resultLabel.setText(print);
                                break;
                            }
                            arg1 = (double)(arg1.intValue() / arg2.intValue());
                            input = "";
                            print = arg1.toString();
                            resultLabel.setText(print);
                            break;
                        }
                }
            }
        };

        String[] func = {"+/-", "0", ".", "=", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "X", "1/x", "x^2", "sqrt(x)", "/", "%", "C", "<<"};
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        for (int i = 0; i < func.length; i++) {
            JButton button = new JButton(func[i]);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            if ((Character.isDigit(func[i].charAt(0)) || func[i].equals(".")) && func[i] != "1/x") {
                button.addActionListener(numberButtonListener);
                System.out.println(func[i]);
            } else {
                button.addActionListener(funcButtonListener);
            }
            buttonPanel.add(button);
        }

        frame.add(resultLabel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

}
