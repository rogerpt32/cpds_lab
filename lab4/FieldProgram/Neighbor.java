public class Neighbor extends Thread {
  private Flags flags;
  private Turn turn;
  public Neighbor(Flags flags, Turn turn) {
    this.flags = flags;
    this.turn = turn;
  }
  public void run() {
    while (true) {
      try {
        String name = Thread.currentThread().getName();
        System.out.println("try again, my name is: "+ name);
        // Thread.sleep((int)(200*Math.random())); //uncoment for non-greedy and comment for greedy
        flags.set_true(name);
        turn.set_turn(name);
        turn.print_turn();
        Thread.sleep((int)(200*Math.random())); //coment for non-greedy and uncomment for greedy
        while (flags.query_flag(name) && !turn.is_my_turn(name)){
          System.out.println(name + " is waiting");
          Thread.sleep(200);
        }
        System.out.println(name + " enter");
        Thread.sleep(400);
        System.out.println(name + " exits");
        Thread.sleep((int)(200*Math.random()));
        flags.set_false(name);
      }
      catch (InterruptedException e) {};
    }
  }
}
