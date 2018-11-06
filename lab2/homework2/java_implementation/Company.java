public class Company extends Thread {
  Account account;
  public Company(Account account) {
    this.account = account;
  }
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + " would like to deposit.");
      try {
        Thread.sleep(200);
        account.company_deposit();
      }
        catch(InterruptedException e) {};
    }
  }
}
