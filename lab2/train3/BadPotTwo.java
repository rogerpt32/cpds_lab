public class BadPotTwo {
  private int servings = 0;
  private int capacity;
  public BadPotTwo(int capacity) {
    this.capacity = capacity;
  }
  public void getserving() throws InterruptedException {
    if (servings == 0) {
      System.out.println(Thread.currentThread().getName() + " go walk");
    }
    else {
      Thread.sleep(200);
      --servings;
      System.out.println(Thread.currentThread().getName()+ " is served");
      print_servings();
    }
  }
  public void fillpot() throws InterruptedException {
    if (servings > 0) {
      System.out.println(Thread.currentThread().getName() + " go walk");
    }
    else {
      Thread.sleep(200);
      servings = capacity;
      System.out.println(servings);
      // wake up threads in Waiting Set in order to asure....
      print_servings();
    }
  }
  //only for trace purposes
  public synchronized void print_servings() {
    System.out.println("servings in the pot: " + servings);
  }
}
