package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wanghu
 * @Description：正则表达式练习
 * @Date 2020/12/30 17:38
 */
public class RegexTest {
    public static void main(String[] args) {
        //在这个字符串：afaffdf5g5g88gd，是否符合指定的正则表达式
        // 表达式对象
        Pattern p = Pattern.compile(".");
        // 创建Matcher对象
        Matcher m = p.matcher("afaffdf5g5g88gd");

        boolean value = m.matches();
        System.out.println(value);

    }
}
