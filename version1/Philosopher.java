/**
 * This class implements a dining philosopher.
 *
 * @author Zhanwen Chen
 * @version 1: Code Block
 */
public class Philosopher extends Thread
{
    // instance variables
    private int id;          // Philosopher's unique identifier
    private Chopsticks chopsticks;  // The group of chopsticks that they share

    /**
     * Constructor for Philosopher objects
     */
    public Philosopher(int id, Chopsticks chopsticks)
    {
      // initialize instance variables
      this.id = id;
      this.chopsticks = chopsticks;
    }


    /*
     * A dining philosopher's behavior
     * is to eat and think -- forever!
     */

    public void run()
    {
      // don't all start in order of creation!
      this.delay( this.randomInt() );

      while (true) {

        // pick up left chopstick
        synchronized (chopsticks.getLeft(id)) {
          // philosopher has left chopstick!
          //   this.delay( this.randomInt() ); // simulate picking up
          System.out.println("Philosopher " + this.id + " has left chopstick...");
          synchronized (chopsticks.getRight(id)) {
              // philosopher has right chopstick!
              //   this.delay( this.randomInt() ); // simulate picking up
              System.out.println("Philosopher " + this.id + " has right chopstick...");

              // eat
              System.out.println("Philosopher " + this.id + " eating...");
              this.delay( this.randomInt() ); // chew your food!

              // finished eating, so put down forks
              //   this.delay( this.randomInt() ); // simulate putting down
              System.out.println("Philosopher " + this.id + " put down left chopstick...");

              //   this.delay( this.randomInt() ); // simulate putting down
              System.out.println("Philosopher " + this.id + " put down right chopstick...");
          }
        }

        System.out.println("BURP! (Philosopher " + this.id + ")");

        // think
        System.out.println("Philosopher " + id + " thinking...");
        this.delay( this.randomInt() ); // can't rush genius!
      }
    }

    /**
     * Returns a random integer.
     */
    public int randomInt() {
      double r = Math.random();
      return (int) Math.floor( r * 100 ) + 1;
    }

    /**
     * Simulates a philosopher pausing for a given amount of time.
     */
    public void delay(int mSec) {
      try {
        Thread.sleep(mSec);
      } catch (InterruptedException ex) {}
    }
}
