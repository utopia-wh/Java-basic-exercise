package part1;

public class IntegerCache {
  public static void main(String[] args) {
      Integer a = 100, b = 100, c = 129, d = 129, e = 148;
      System.out.println(a==b);
      System.out.println(c==d);
      Integer k = new Integer(100);
      System.out.println(Integer.max(Integer.max(a,c),e));
      System.out.println(Integer.TYPE);
    System.out.println();
  }
}
