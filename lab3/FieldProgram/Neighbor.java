public class Neighbor extends Thread {
  private Flags flags;
  public Neighbor(Flags flags) {
    this.flags = flags;
  }
  public void run() {
    while (true) {
      try {
        String name = Thread.currentThread().getName();
        System.out.println("try again, my name is: "+ name);
        // Thread.sleep((int)(200*Math.random())); //uncoment for non-greedy and comment for greedy
        flags.set_true(name);
        Thread.sleep((int)(200*Math.random())); //coment for non-greedy and uncomment for greedy
        if (!flags.query_flag(name)) {
          System.out.println(name + " enter");
          Thread.sleep(400);
          System.out.println(name + " exits");
        }
        Thread.sleep((int)(200*Math.random()));
        flags.set_false(name);
      }
      catch (InterruptedException e) {};
    }
  }
}
