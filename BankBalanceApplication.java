import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceApplication extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
    }

    public static void main(String[] args) {
        BankBalanceApplication app = new BankBalanceApplication();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 300);
        app.setVisible(true);
    }
}   

