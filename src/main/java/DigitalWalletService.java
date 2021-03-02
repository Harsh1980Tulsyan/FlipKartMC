import java.util.*;

public class DigitalWalletService implements DigitalWallet{

    Map<String,Double> walletOverview ;
    Map<String, List<String>> walletStatement;

    DigitalWalletService(){
        walletOverview = new HashMap<String, Double>();
        walletStatement = new HashMap<String, List<String>>();
    }

    public void createWallet(String name, double amount) {

        if(walletOverview.containsKey(name)){
            System.out.println("wallet "+name+" already created");
        }else if(amount <0){
            System.out.println("Invalid Amount");
        }else {
            walletOverview.put(name, amount);
            List<String> statement = new ArrayList<String>();
            statement.add("Initial balance of "+amount +" added");
            walletStatement.put(name,statement);
        }
    }

    public void transferMoney(String accountDebit, String accountCredit, double amount) {

        if(!walletOverview.containsKey(accountCredit)) {
            System.out.println("Invalid Debit account");
        }else if(!walletOverview.containsKey(accountCredit)){
            System.out.println("Invalid credit account");
        }else if(amount < 0.0001){
            System.out.println("Please enter valid amount");
        }else if(accountCredit.equals(accountDebit)){
            System.out.println("Self wallet transfer not allowed");
        } else{
            double debitAccountBalance = walletOverview.get(accountDebit);
            double creditAccountBalance = walletOverview.get(accountCredit);
             if(debitAccountBalance - amount < 0){
                 System.out.println("Insufficient funds present in "+ accountDebit+ " wallet");
             }else {
                 debitAccountBalance = debitAccountBalance - amount;
                 creditAccountBalance = creditAccountBalance + amount;
                 List<String> debitAccountStatement = walletStatement.get(accountDebit);
                 List<String> creditAccountStatement = walletStatement.get(accountCredit);
                 if (debitAccountBalance == creditAccountBalance) {
                     debitAccountBalance += 10;
                     creditAccountBalance += 10;
                     debitAccountStatement.add("Offer1 credit 10");
                     creditAccountStatement.add("offer1 credit 10");
                 }
                 walletOverview.put(accountDebit, debitAccountBalance);
                 walletOverview.put(accountCredit, creditAccountBalance);
                 debitAccountStatement.add(accountCredit +" debit "+ amount);
                 creditAccountStatement.add(accountDebit+" credit "+amount);
             }
        }
    }

    public void overview() {

        for(Map.Entry<String,Double> mapElement : walletOverview.entrySet()){
            System.out.println(mapElement.getKey()+" "+mapElement.getValue());
        }

    }

    public void statement(String name) {

        if(!walletStatement.containsKey(name)){
            System.out.println("wallet statement is not present for "+name);
        }else{
            List<String>  accountStatement = walletStatement.get(name);
            for(String statement:accountStatement){
                System.out.println(statement);
            }
        }
    }

    public void offer2() {
        Map<Integer,String> transaction = new TreeMap<Integer, String>();
        for(Map.Entry<String,List<String>> mapElement : walletStatement.entrySet()){
            transaction.put(mapElement.getValue().size(),mapElement.getKey());
        }
        int i=0;
        String account1=null,account2=null,account3=null;
        for(Map.Entry<Integer,String> mapElement: transaction.entrySet()){
            if(i==0)
                account1 = mapElement.getValue();
            if(i==1)
                account2 = mapElement.getValue();
            if(i==2)
                account3 = mapElement.getValue();
            else if(i==3)
                break;
            i++;
        }
        if(walletStatement.get(account1).size() > walletStatement.get(account2).size()  &&   walletStatement.get(account2).size() > walletStatement.get(account3).size()){
            double account1Amount = walletOverview.get(account1);
            double account2Amount = walletOverview.get(account2);
            double account3Amount = walletOverview.get(account3);
            walletOverview.put(account1,account1Amount+10.0);
            walletOverview.put(account2,account2Amount+5);
            walletOverview.put(account3,account3Amount+2);
         }
    }
}
