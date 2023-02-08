import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends Container {

    private JTextField accountField;
    private JPasswordField pinField;
    private JButton login;

    public LoginPage(){

        setSize(500,500);
        setLayout(null);

        accountField = new JTextField();
        accountField.setSize(200,30);
        accountField.setLocation(150,150);
        add(accountField);
        accountField.setBorder(new EtchedBorder(Color.gray, Color.gray));

        pinField = new JPasswordField();
        pinField.setSize(200,30);
        pinField.setLocation(150,210);
        add(pinField);

        pinField.setBorder(new EtchedBorder(Color.gray, Color.gray));

        login = new JButton(" LOGIN ");
        login.setSize(100,30);
        login.setLocation(150,270);
        add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankAccount found = Main.getAccount(accountField.getText(), pinField.getText());
                if(found!=null){

                    accountField.setBorder(new EtchedBorder(Color.gray, Color.gray));
                    pinField.setBorder(new EtchedBorder(Color.gray, Color.gray));
                    accountField.setText("");
                    pinField.setText("");
                    Main.currentAccount = found;
                    Main.frame.setAccount(found);
                    Main.frame.openMainMenuPage();

                }else{

                    pinField.setBorder(new EtchedBorder(Color.red, Color.red));
                    accountField.setBorder(new EtchedBorder(Color.red, Color.red));

                }
            }
        });


    }

}
