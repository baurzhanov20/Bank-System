import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

    public static MainFrame frame;
    public static BankAccount currentAccount;

    public static void main(String[] args) {
        frame = new MainFrame();
        frame.setVisible(true);
    }

    public static BankAccount getAccount(String number, String pin){

        BankAccount result = null;

        try{

            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream("memory.bank"));

            ArrayList<BankAccount> accounts = (ArrayList<BankAccount>)inputStream.readObject();

            for(int i=0;i<accounts.size();i++){
                if(accounts.get(i).getNumber().equals(number)&& accounts.get(i).getPinCode().equals((pin))){
                    result = accounts.get(i);
                    break;
                }
            }

            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    public static BankAccount getAccount(String number){

        BankAccount result = null;

        try{

            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream("memory.bank"));

            ArrayList<BankAccount> accounts = (ArrayList<BankAccount>)inputStream.readObject();

            for(int i=0;i<accounts.size();i++){
                if(accounts.get(i).getNumber().equals(number)){
                    result = accounts.get(i);
                    break;
                }
            }

            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    public static void saveBankAccount(BankAccount bankAccount){

        try{

            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream("memory.bank"));

            ArrayList<BankAccount> accounts = (ArrayList<BankAccount>)inputStream.readObject();

            for(int i=0;i<accounts.size();i++){
                if(accounts.get(i).getNumber().equals(bankAccount.getNumber())&& accounts.get(i).getPinCode().equals((bankAccount.getPinCode()))){
                    accounts.set(i, bankAccount);
                    break;
                }
            }

            inputStream.close();

            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream("memory.bank"));
            outputStream.writeObject(accounts);
            outputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
