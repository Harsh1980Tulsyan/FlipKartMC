public interface DigitalWallet {
    public void createWallet(String name,double amount);

    public void transferMoney(String accountDebit, String accountCredit, double amount);

    public void overview();

    public void statement(String name);

    public void offer2();
}
