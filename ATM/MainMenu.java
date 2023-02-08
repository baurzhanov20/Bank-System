import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {

    private JButton cashWithdawal;
    private JButton transferMoney;
    private JButton signOut;
    private JTextField accountField;
    private JButton refreshButton;

    public MainMenu(){

        setSize(500,500);
        setLayout(null);

        accountField = new JTextField("");
        accountField.setSize(300,30);
        accountField.setLocation(100,40);
        accountField.setEditable(false);
        add(accountField);

        cashWithdawal = new JButton("CASH WITHDRAWAL");
        cashWithdawal.setSize(200,30);
        cashWithdawal.setLocation(150,100);
        add(cashWithdawal);

        cashWithdawal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.openCashWithdrawalPage();
            }
        });

        transferMoney = new JButton("TRANSFER MONEY");
        transferMoney.setSize(200,30);
        transferMoney.setLocation(150, 170);
        add(transferMoney);

        transferMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.openTransferMoneyPage();
            }
        });

        refreshButton = new JButton("REFRESH");
        refreshButton.setSize(200,30);
        refreshButton.setLocation(150,240);
        add(refreshButton);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setAccount(Main.getAccount(Main.currentAccount.getNumber(), Main.currentAccount.getPinCode()));
            }
        });

        signOut = new JButton("SIGN OUT");
        signOut.setSize(200,30);
        signOut.setLocation(150, 310);
        add(signOut);

        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.openLoginPage();
            }
        });

    }

    public void setAccountField(BankAccount account){
        accountField.setText(account.getFullName() + " - TOTAL BALANCE : " + account.getBalance() + " KZT");
    }
}
