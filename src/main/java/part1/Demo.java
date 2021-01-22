package part1;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Demo {
    static  Log log = LogFactory.getLog(Demo.class);
    public static void main(String[] args) {
        System.out.println(method());
    }
    public static int method() {
        int a = 10;
        try {
            int b = 10 / 0;
            return b;
        } catch (Exception e) {
            log.info("进入catch语句.....");
            a = 20;

        } finally {
            /*finally中的代码主要是释放资源*/
            log.info("进入finally语句.....");
            a = 30;
        }
        return a;
    }
    
}
