public class Savage extends Thread {
  BadPot pot;
  public Savage(BadPot pot) {
    this.pot = pot;
  }
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + " is hungry and would like to eat");
      try {
        Thread.sleep(200);
        pot.getserving();
      }
      catch(InterruptedException e) {};
    }
  }
}
