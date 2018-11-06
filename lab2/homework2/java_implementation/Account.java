public class Account {
  private int balance;
  public Account(int balance) {
    this.balance = balance;
  }
  public synchronized void withdraw(int amount) throws InterruptedException {
    while (balance < amount) {
      System.out.println(Thread.currentThread().getName() +
          " has to wait (Not enough money)");
      wait();
    }
    balance-=amount;
    System.out.println(Thread.currentThread().getName() + " withdrawed: " + amount);
    if (balance < 5) notifyAll(); // to trigger Company to deposit and avoid locks of withdraws
    // I used 5 because is the maximum amount that can be withdrawed at a time by a person
    print_balance();
  }
  public synchronized void deposit(int amount) throws InterruptedException {
    balance += amount;
    System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
    print_balance();
    notifyAll();
  }

  public synchronized void company_deposit() throws InterruptedException {
    while (balance >= 5) {
      System.out.println(Thread.currentThread().getName() +
          " Company has to wait (there is enough money in the account)");
      wait();
    }
    balance = 5; //fills the account enough to allow any withdraw
    System.out.println(Thread.currentThread().getName() + " Company deposited");
    print_balance();
    notifyAll();
  }
  //only for trace purposes
  public synchronized void print_balance() {
    System.out.println("balance in the account: " + balance);
  }
}
