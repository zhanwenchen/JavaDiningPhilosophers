public class Chopsticks {
  Chopstick[] chopsticksArray;

  public class Chopstick {}

  public Chopsticks() {
    // Instance gets a new chopsticksArray
    this.chopsticksArray = new Chopstick[6];
    for (int i = 1; i <= 5; i++) {
      chopsticksArray[i] = new Chopstick();  // initially each chopstick is available
    }
  }

  Chopstick getLeft(int id) {
    // this.chopsticksArray[0] is not defined. Cycle to the right
    return (id==1) ? this.chopsticksArray[5] : this.chopsticksArray[id-1];
  }

  Chopstick getRight(int id) {
    return this.chopsticksArray[id];
  }
}
