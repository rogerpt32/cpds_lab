public class Banket {
  public static void main(String args[]) {
    Pot pot = new Pot(5);
    Thread a = new Savage(pot);
    a.setName("alice");
    Thread b = new Savage(pot);
    b.setName("bob");
    Thread c = new Cook(pot);
    c.setName("malcon");
    a.start();
    b.start();
    c.start();
  }
}

public class Pot {
  private int servings = 0;
  private int capacity;
  public Pot(int capacity) {
    this.capacity = capacity;
  }
  public synchronized void getserving() throws InterruptedException {
    // Condition synchronization: at least one serving available,
    // otherwise, go to the Waiting Set til the cook fill the pot
    while (servings == 0) {
      System.out.println(Thread.currentThread().getName() + " has to wait");
      wait();
    }
    --servings;
    System.out.println(Thread.currentThread().getName() + " ....");
    // when necessary, wake up threads in Waiting Set in order to asure
    // a runnable cook
    if (servings == 0) notifyAll();
    print_servings();
  }
  public synchronized void fillpot() throws InterruptedException {
    //Condition synchronization: .....
    //....
    while (servings > 0) {
      System.out.println(Thread.currentThread().getName() + " has to wait");
      wait();
    }
    servings = capacity;
    System.out.println(servings);
    // wake up threads in Waiting Set in order to asure....
    print_servings();
    notifyAll();
  }
  //only for trace purposes
  public synchronized void print_servings() {
    System.out.println("servings in the pot: " + servings);
  }
}

public class Savage extends Thread {
  Pot pot;
  public Savage(Pot pot) {
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

public class Cook extends Thread {
  Pot pot;
  public Cook(Pot pot) {
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
