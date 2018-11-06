public class Control {
  int count == 0;
  boolean opened = false;

  public synchronized void arrive() throws InterruptedException {
    while (!opened) {
      System.out.println(Thread.currentThread().getName() + " is closed");
      wait();
    }
    ++count;
    System.out.println(Thread.currentThread().getName() + " arrived");
    print_attendants();
  }
  public synchronized void leave() throws InterruptedException {
    while (count<=0) {
      System.out.println(Thread.currentThread().getName() + " no one to leave");
      wait();
    }
    --count;
    System.out.println(Thread.currentThread().getName() + " left");
    print_attendants();
    if (count==0){
      notifyAll();
    }
  }
  public synchronized void open() throws InterruptedException {
    open=true;
    notifyAll();
  }
  public synchronized void close() throws InterruptedException {
    open=false;
    notifyAll();
  }
  public synchronized void print_servings() {
    System.out.println("people inside: " + count);
  }
}
