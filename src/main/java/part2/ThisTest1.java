package part2;

import java.util.List;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/2/8 17:04
 */
public class ThisTest1 {
    public int count;

    public void add(ThisTest1 test) {
       test.count = this.count;


    }
}
