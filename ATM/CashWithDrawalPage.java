import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashWithDrawalPage extends Container{

    private JButton backButton;
    private JButton cashWithdrawalButton;
    private JTextField amountField;
    private JLabel amountLabel;

    public CashWithDrawalPage(){

        setLayout(null);
        setSize(500,500);

        amountLabel = new JLabel("AMOUNT:");
        amountLabel.setSize(200,30);
        amountLabel.setLocation(150,90);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setSize(200,30);
        amountField.setLocation(150,140);
        add(amountField);
        amountField.setBorder(new EtchedBorder(Color.gray, Color.gray));

        cashWithdrawalButton = new JButton("CASH WITHDRAWAL");
        cashWithdrawalButton.setSize(200,30);
        cashWithdrawalButton.setLocation(150,200);
        add(cashWithdrawalButton);

        cashWithdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double amount = 0;

                try{

                    amount = Double.parseDouble(amountField.getText());
                    if(Main.currentAccount.getBalance()-amount>0){

                        Main.currentAccount.setBalance(Main.currentAccount.getBalance()-amount);
                        amountField.setBorder(new EtchedBorder(Color.gray, Color.gray));
                        amountField.setText("");
                        Main.saveBankAccount(Main.currentAccount);
                        Main.frame.setAccount(Main.currentAccount);
                        Main.frame.openMainMenuPage();

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
