public class WaiterMon {

  int availableSeats;

  public WaiterMon(int availableSeats) {
    this.availableSeats = availableSeats;
  }

  /*
    * Synchronized method to seat a given philosopher.
    * Use wait() to avoid busy waiting. This queues
    * the philosopher on the waiter's implicit condition variable.
    */
  public synchronized void sitDown() {
    // wait for a seat, if necessary, then sit down
    while (this.availableSeats==0) {
      try {
        wait();
      } catch (InterruptedException ex) {}
    }
    this.availableSeats--;
  }

  /*
    * Synchronized method to unseat a given philosopher.
    * Use notifyAll() to notify any waiting philosopher
    * that there's room at the table.
    */
  public synchronized void standUp() {
    this.availableSeats++;

    // give the other philosophers a chance to eat
    notifyAll();
  }
}
