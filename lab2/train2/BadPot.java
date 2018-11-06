public class BadPot {
  private int servings = 0;
  private int capacity;
  public BadPot(int capacity) {
    this.capacity = capacity;
  }
  public synchronized void getserving() throws InterruptedException {
    // Condition synchronization: at least one serving available,
    // otherwise, go to the Waiting Set til the cook fill the pot
    if (servings == 0) {
      System.out.println(Thread.currentThread().getName() + " has to wait");
      wait();
    }
    --servings;
    System.out.println(Thread.currentThread().getName() + " is served");
    // when necessary, wake up threads in Waiting Set in order to asure
    // a runnable cook
    if (servings == 0) notifyAll();
    print_servings();
  }
  public synchronized void fillpot() throws InterruptedException {
    //Condition synchronization: .....
    //....
    if (servings > 0) {
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
