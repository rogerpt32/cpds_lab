public class Banket {
  // ctrl+shift+B to run
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
