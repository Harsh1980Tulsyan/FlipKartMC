import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DigitalWallet digitalWallet = new DigitalWalletService();

        while (sc.hasNext()){

            String input = sc.next();

             if(input.equals(InputEnum.CreateWallet.name())){
                 String name = sc.next();
                 double amount = sc.nextDouble();
                 digitalWallet.createWallet(name,amount);
             }else if(input.equals(InputEnum.TransferMoney.name())) {
                 String debitAccount = sc.next();
                 String creditAccount = sc.next();
                 double amount = sc.nextDouble();
                 digitalWallet.transferMoney(debitAccount,creditAccount,amount);
             }else if(input.equals(InputEnum.Overview.name()))
                 digitalWallet.overview();
             else if(input.equals(InputEnum.Statement.name())){
                 String name = sc.next();
                 digitalWallet.statement(name);
             }else if(input.equals(InputEnum.Offer2.name())){
                 digitalWallet.offer2();
             }else{
                 System.out.println("Invalid Input");
             }
        }
    }
}
