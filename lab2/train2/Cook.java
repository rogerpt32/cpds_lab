public class Cook extends Thread {
  BadPot pot;
  public Cook(BadPot pot) {
    this.pot = pot;
  }
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + " would like to fill the pot");
      try {
        Thread.sleep(200);
        pot.fillpot();
      }
        catch(InterruptedException e) {};
    }
  }
}
