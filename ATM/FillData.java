import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FillData {

    public static void main(String[] args) {

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        try{

            bankAccounts.add(new BankAccount("44056452", 40000, "Kirill Yereferenko" ,"1234"));
            bankAccounts.add(new BankAccount("44056451", 40000, "Timur Chukin" ,"4321"));
            bankAccounts.add(new BankAccount("44056450", 30000, "Ilyas Zhuanyshev" ,"1234"));
            bankAccounts.add(new BankAccount("44056444", 40000, "Arman Ermekov" ,"1234"));
            bankAccounts.add(new BankAccount("44056424", 40000, "Andrey Arshavin" ,"1234"));
            bankAccounts.add(new BankAccount("44056413", 40000, "Erbolat Beisenbek" ,"1234"));

            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream("memory.bank"));

            outputStream.writeObject(bankAccounts);
            outputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
