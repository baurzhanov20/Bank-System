import javax.swing.*;

public class MainFrame extends JFrame {

    private LoginPage loginPage;
    private MainMenu mainMenu;
    private CashWithDrawalPage cashWithDrawalPage;
    private TransferMoneyPage transferMoneyPage;

    public MainFrame(){

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("BANK ATM");
        setResizable(false);

        loginPage = new LoginPage();
        loginPage.setLocation(0,0);
        add(loginPage);

        mainMenu = new MainMenu();
        mainMenu.setLocation(0,0);
        add(mainMenu);
        mainMenu.setVisible(false);

        cashWithDrawalPage = new CashWithDrawalPage();
        cashWithDrawalPage.setLocation(0,0);
        add(cashWithDrawalPage);
        cashWithDrawalPage.setVisible(false);

        transferMoneyPage = new TransferMoneyPage();
        transferMoneyPage.setLocation(0,0);
        add(transferMoneyPage);
        transferMoneyPage.setVisible(false);

    }

    public void openMainMenuPage(){

        transferMoneyPage.setVisible(false);
        cashWithDrawalPage.setVisible(false);
        loginPage.setVisible(false);
        mainMenu.setVisible(true);
        mainMenu.setAccountField(Main.getAccount(Main.currentAccount.getNumber(), Main.currentAccount.getPinCode()));

    }

    public void openLoginPage(){

        loginPage.setVisible(true);
        mainMenu.setVisible(false);

    }

    public void openCashWithdrawalPage(){
        cashWithDrawalPage.setVisible(true);
        mainMenu.setVisible(false);
    }

    public void openTransferMoneyPage(){
        transferMoneyPage.setVisible(true);
        mainMenu.setVisible(false);
    }

    public void setAccount(BankAccount account){

        mainMenu.setAccountField(account);

    }

}
