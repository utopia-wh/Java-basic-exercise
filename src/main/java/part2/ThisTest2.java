package part2;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/2/8 17:05
 */
public class ThisTest2 {
    public static void main(String[] args) {
        String content = "ffjff";
        System.out.println(content.toUpperCase());
        System.out.println(content.toLowerCase());
        ThisTest1 test1 = new ThisTest1();
        ThisTest1 test2 = new ThisTest1();
        test2.count = 100;
        test2.add(test1);
        System.out.println(test1.count);
        double t= 220;
        Math.random();

    }
    public static  void te(){
         ThisTest1 f = new ThisTest1();
    }
}
