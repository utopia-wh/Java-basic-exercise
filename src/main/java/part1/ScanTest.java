package part1;

import java.util.Scanner;

/**
 * @Author wanghu
 * @Description：猜数字小游戏
 * @Date 2020/12/23 15:49
 */
public class ScanTest {
    public static void main(String[] args) {
        //创建Scanner接收用户输入
        Scanner scan = new Scanner(System.in);

        //游戏设置
        int rangeStart = 30;
        int rangeEnd = 50;
        int guessTotal = 5;

        // 游戏统计
        int totalGameCount = 0;
        int correctGuessCount = 0;

        // 是否结束游戏
        boolean gameEnd = false;

        while (!gameEnd) {
            // 生成指定范围内的随机数
            int mod = rangeEnd - rangeStart;
            if (rangeStart < 0 || rangeEnd < 0) {
                System.out.println("开始和结束必须是正数或者0");
            }
            if (mod <= 1) {
                System.out.println("非法的数字范围：（" + rangeStart + "," + rangeEnd + ")");
            }
            int bigRandom = (int) (Math.random() * rangeEnd * 100);
            int numberToguess = (bigRandom % mod) + rangeStart;
            if (numberToguess <= rangeStart) {
                numberToguess = rangeStart + 1;
            } else if (numberToguess > rangeEnd) {
                numberToguess = rangeEnd - 1;
            }
            // 剩余的猜测次数
            int leftToguess = guessTotal;
            boolean currentGameCounted = false;
            boolean corrctGuess = false;

            System.out.println("请输入猜测的数字，范围：（" + rangeStart + "," + rangeEnd + ")。输入-1代表结束游戏");
            while (leftToguess > 0) {
                System.out.println("剩余猜测次数" + leftToguess + "。请输入本次猜测的数字：");
                leftToguess--;
                int guess = scan.nextInt();
                if (guess < 0) {
                    gameEnd = true;
                    System.out.println("用户结束了游戏！");
                    break;
                }
                if (!currentGameCounted) {
                    totalGameCount++;
                    currentGameCounted = true;
                }
                if (guess > numberToguess) {
                    System.out.println("输入的数字比目标数字大");
                } else if (guess < numberToguess) {
                    System.out.println("输入的数字比目标数字小");
                } else {
                    correctGuessCount++;
                    corrctGuess = true;
                    System.out.println("输入的数字正确！");
                    break;
                }
            }
            if (!corrctGuess) {
                System.out.println("本次的目标数字为：" + numberToguess);
            }
            System.out.println("共进行了" + totalGameCount + "次游戏，其中猜中的了" + correctGuessCount + "次");
        }
    }
}
