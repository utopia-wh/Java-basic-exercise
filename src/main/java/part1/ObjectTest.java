package part1;

public class ObjectTest extends TestMiddle implements Cloneable , TestInterface {
  int i = 0;

  ObjectTest(int i) {
    this.i = i;
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    ObjectTest objectTest = new ObjectTest(1);
    System.out.println("objectTest  " + objectTest.getClass());
    System.out.println("objectTest  " + objectTest.hashCode());
    System.out.println("ob1  " + objectTest.clone().getClass());
    System.out.println("ob1  " + objectTest.clone().getClass());
    System.out.println("ob1  " + objectTest.clone().hashCode());
    short s1 = 1;
    System.out.println(s1);
    s1+=1;
    System.out.println(s1);

  }

  public int queryInfo(int i) {
    return 0;
  }
}
