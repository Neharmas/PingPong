package Util;

public class Pair<A, B> {
  private final A first;
  private final B second;
  
  public Pair(A first, B second) {
    this.first = first;
    this.second = second;
  }
  
  public A getFirst() {
    return first;
  }
  
  public B getSecond() {
    return second;
  }
  
  // Optional: You might want to override equals, hashCode, and toString
  // based on the requirements of your application.
}
