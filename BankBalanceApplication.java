import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceApplication extends JFrame implements ActionListener {
    JPanel panel;
    GridBagConstraints layoutConst;

    private JLabel BalanceLabel; //Label for current balance
    private JLabel balanceValueLabel; //Label to display current balance value
    private JLabel AmountLabel; //Label for deposit amount
    private JTextField AmountField; //Text field for deposit amount
    private double balance = 1000.00; //Initial balance
    private JButton depositButton; //Button to perform deposit
    private JButton withdrawButton; //Button to perform withdrawal
    private JButton exitButton; //Button to exit the application

    BankBalanceApplication() {
        //Frame setup
        setTitle("Bank Balance Application");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create Panel
        panel = new JPanel();
        //Set Layout on the Panel
        panel.setLayout(new GridBagLayout());

        //Create constraints object
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10); //Add padding

        //Adding first label and text field
        BalanceLabel = new JLabel("Current Balance: $");
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        panel.add(BalanceLabel, layoutConst);

        //Display initial balance
        balanceValueLabel = new JLabel(String.format("%.2f", balance));
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        panel.add(balanceValueLabel, layoutConst);

        //Adding second label and text field
        AmountLabel = new JLabel("Amount: $");
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        panel.add(AmountLabel, layoutConst);
        AmountField = new JTextField(10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        panel.add(AmountField, layoutConst);

        //Adding Buttons
        depositButton = new JButton("Deposit");
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        panel.add(depositButton, layoutConst);
        depositButton.addActionListener(this);
        withdrawButton = new JButton("Withdraw");
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        panel.add(withdrawButton, layoutConst);
        withdrawButton.addActionListener(this);
        exitButton = new JButton("Exit");
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        panel.add(exitButton, layoutConst);
        exitButton.addActionListener(this);

        //Add panel to frame
        add(panel);
        //Make window visible
        setVisible(true);
    }
    
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
    }

    public void actionPerformed(ActionEvent e) {
        //Check if exit button was clicked
        if(e.getSource() == exitButton) {
            System.exit(0);
        }
        //Try to parse the amount and perform the appropriate action
        try{
            double amount = Double.parseDouble(AmountField.getText());
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be positive.");
            }
            //Check which button was clicked
            if(e.getSource() == depositButton) {
                deposit(amount);
            } else if (e.getSource() == withdrawButton) {
                withdraw(amount);
            }
            //Update the displayed balance
            balanceValueLabel.setText(String.format("%.2f", balance));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BankBalanceApplication();
    }
}   

