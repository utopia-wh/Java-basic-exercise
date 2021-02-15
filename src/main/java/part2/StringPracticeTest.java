package part2;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/2/15 11:49
 */
public class StringPracticeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringPractice stringPractice = new StringPractice();
        while (true) {
            String input = scan.next();
            if ("exit".equals(input)) {
                System.out.println("再见！");
                break;
            }

            String answer = stringPractice.answer(input);
            System.out.println(answer);
        }
    }
}
