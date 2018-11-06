public class Turn {
  private int turn;
  public Turn() {
    turn = 1;
  }
  public synchronized boolean is_my_turn(String s) {
    //no condition synchronization is needed
    if (s.equals("alice")) return turn==1;
    else return turn==2;
  }
  public synchronized void set_turn(String s) {
    //no condition synchronization is needed
    if (s.equals("alice")) turn=2;
    else turn=1;
  }
  public void print_turn() {
    System.out.println("Is turn: "+ turn);
  }
}
