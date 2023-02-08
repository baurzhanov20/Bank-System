import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferMoneyPage extends Container{

    private JButton backButton;
    private JButton transferMoneyButton;
    private JTextField accountField;
    private JTextField amountField;
    private JLabel accountLabel;
    private JLabel amountLabel;

    public TransferMoneyPage(){

        setLayout(null);
        setSize(500,500);

        accountLabel = new JLabel("ACCOUNT NUMBER:");
        accountLabel.setSize(200,30);
        accountLabel.setLocation(150,30);
        add(accountLabel);

        accountField = new JTextField();
        accountField.setLocation(150,70);
        accountField.setSize(200,30);
        add(accountField);
        accountField.setBorder(new EtchedBorder(Color.gray, Color.gray));


        amountLabel = new JLabel("TRANSFER AMOUNT:");
        amountLabel.setSize(200,30);
        amountLabel.setLocation(150,150);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setSize(200,30);
        amountField.setLocation(150,190);
        add(amountField);
        amountField.setBorder(new EtchedBorder(Color.gray, Color.gray));

        transferMoneyButton = new JButton("TRANSFER MONEY");
        transferMoneyButton.setSize(200,30);
        transferMoneyButton.setLocation(150,300);
        add(transferMoneyButton);

        transferMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double amount = 0;

                try{

                    amount = Double.parseDouble(amountField.getText());

                    if(Main.currentAccount.getBalance()-amount>0){

                        amountField.setBorder(new EtchedBorder(Color.gray, Color.gray));

                        BankAccount clientAccount = Main.getAccount(accountField.getText());

                        if(clientAccount!=null){

                            Main.currentAccount.setBalance(Main.currentAccount.getBalance()-amount);
                            accountField.setBorder(new EtchedBorder(Color.gray, Color.gray));
                            Main.saveBankAccount(Main.currentAccount);
                            Main.frame.setAccount(Main.currentAccount);
                            clientAccount.setBalance(clientAccount.getBalance()+amount);
                            Main.saveBankAccount(clientAccount);
                            amountField.setText("");
                            accountField.setText("");
                            Main.frame.openMainMenuPage();

                        }else{
                            accountField.setBorder(new EtchedBorder(Color.red, Color.red));
                        }

                    }else{
                        amountField.setBorder(new EtchedBorder(Color.red, Color.red));
                    }

                }catch (Exception ex){
                    amountField.setBorder(new EtchedBorder(Color.red, Color.red));
                }

            }
        });

        backButton = new JButton("BACK");
        backButton.setSize(200,30);
        backButton.setLocation(150,350);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.openMainMenuPage();
            }
        });

    }

}
