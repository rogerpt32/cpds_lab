import java.util.Random;

public class Person extends Thread {
  Account account;
  Random rand = new Random();
  public Person(Account account) {
    this.account = account;
  }
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + " is trying to do a transaction.");
      try {
        Thread.sleep(200);
        int  n = rand.nextInt(2); //randomly choose which transaction (0=withdraw, 1=deposit)
        int amount = rand.nextInt(5)+1; //randomly choose amount between 1 and 5
        if(n==0){
          account.withdraw(amount);
        }
        else{
          account.deposit(amount);
        }
      }
      catch(InterruptedException e) {};
    }
  }
}
