import javax.swing.*;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextField;
 public class BankAccount {
    double balance = 0.0;
    void deposit(double amount) {
        balance += amount;
    }
    
    void withdraw(double amount) {
        balance -= amount;
    }
    double getBalance() {
        return balance;
    }
    
    public static void main(String[] args) {
        // Create the GUI
        JFrame frame = new JFrame();
        final int F_WIDTH = 400;
        final int F_HEIGHT = 300;
        frame.setSize(F_WIDTH,F_HEIGHT);
        frame.setTitle("Bank Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Layout for mainPanel to BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add Label and Textfiled for balance
        JLabel balanceLabel = new JLabel("Balance: $");
        JTextField balanceField = new JTextField(10);
        balanceField.setEditable(false);
        JPanel firstPanel = new JPanel();
        firstPanel.add(balanceLabel);
        firstPanel.add(balanceField);
        
        
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JPanel secondPanel = new JPanel();
        secondPanel.add(depositButton);
        secondPanel.add(withdrawButton);
        
        JLabel amountLabel = new JLabel("Amount: $");
        JTextField amountField = new JTextField(10);
        amountField.setEditable(true);
        JPanel thirdPanel = new JPanel();
        thirdPanel.add(amountLabel);
        thirdPanel.add(amountField);


        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);


        frame.getContentPane().add(mainPanel);
        // frame.pack();
        frame.setVisible(true);


        // BankAccount account = new BankAccount();
        // account.deposit(100);
        // System.out.println("Balance: " + account.getBalance());
        // account.withdraw(30);
        // System.out.println("Balance: " + account.getBalance());

    }
 }