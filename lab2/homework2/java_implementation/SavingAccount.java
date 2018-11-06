public class SavingAccount {
  // ctrl+shift+B to run
  public static void main(String args[]) {
    Account account = new Account(0);
    Thread a = new Person(account);
    a.setName("alice");
    Thread b = new Person(account);
    b.setName("bob");
    Thread c = new Company(account);
    c.setName("LaCaixa");
    a.start();
    b.start();
    c.start();
  }
}
