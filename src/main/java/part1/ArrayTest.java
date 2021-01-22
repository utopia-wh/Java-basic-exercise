package part1;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author wanghu
 * @Description：数组练习
 * @Date 2020/12/29 14:44
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 声明六个变量
        int YuWenIndex = 0;
        int ShuXueIndex = 1;
        int WaiYuIndex = 2;
        int WuliIndex = 3;
        int HuaXueIndex = 4;
        int ShengWuIndex = 5;

        int totalScoreCount = 6;

        // 每门课的名字
        String[] names = new String[totalScoreCount];
        names[YuWenIndex] = "语文";
        names[ShuXueIndex] = "数学";
        names[WaiYuIndex] = "外语";
        names[WuliIndex] = "物理";
        names[HuaXueIndex] = "化学";
        names[ShengWuIndex] = "生物";

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入共有多少年的成绩：");
        int yearCount = scan.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];

        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("第" + (i + 1) + "年的" + names[j] + "成绩为：" + scores[i][j]);
            }
        }

        while (true) {
            System.out.println("请输入你要进行的操作编号");
            System.out.println("1：求某年的最好成绩\n" +
                    "2：求某年的平均成绩\n" +
                    "3：求所有年份的最好成绩\n" +
                    "4：求某门课历年的最好成绩");

            int oprtId = scan.nextInt();

            int year = 0;

            switch (oprtId) {
                case 1:
                    System.out.println("请输入要求哪一年的最好成绩");
                    year = scan.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法的年份");
                        break;
                    }
                    int bestOfYearScoreId = 0;
                    for (int i = 1; i < scores[year].length; i++) {
                        if (scores[year][bestOfYearScoreId] < scores[year][i]) {
                            bestOfYearScoreId = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年的最好成绩为" + names[bestOfYearScoreId] + "：" + scores[year][bestOfYearScoreId]);
                    break;
                case 2:
                    System.out.println("请输入要求哪一年的最好成绩");
                    year = scan.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法的年份");
                        break;
                    }
                    double totalScore = 0;
                    for (int i = 0; i < scores[year].length; i++) {
                        totalScore += scores[year][i];
                    }
                    System.out.println("第" + (year + 1) + "年的平均成绩为" + (totalScore / names.length));
                    break;
                case 3:
                    double totalCount = 0;
                    int bestYear = 0;
                    int scoreName = 0;
                    for (int i = 0; i < yearCount; i++) {
                        for (int j = 0; j < totalScoreCount; j++) {
                            if (totalCount < scores[i][j]) {
                                totalCount = scores[i][j];
                                bestYear = i;
                                scoreName = j;
                            }
                        }
                    }
                    System.out.println("所有年份年最好成绩为" + "第" + (bestYear + 1) + "年的" + names[scoreName] + "：" + scores[bestYear][scoreName]);
                    break;
                case 4:
                    System.out.println("请输入你要查询那门课的历年最好成绩，课程编号为：0代表语文，1代表数学，2代表外语。3代表物理，4代表化学，5代表生物。");
                    int scoreId = scan.nextInt();
                    Pattern p = Pattern.compile("[0-5]");
                    String v = scoreId+"";
                    boolean  value  = p.matcher(v).matches();
                    if (!value){
                        System.out.println("请输入正确的课程编号");
                        break;
                    }
                    year = 0;
                    for (int i = 1; i < scores.length; i++) {
                        if (scores[year][scoreId] < scores[i][scoreId]) {
                            year = i;
                        }
                    }
                    System.out.println(names[scoreId] + "课的历年最好成绩是第" + (year + 1) + "年：" + scores[year][scoreId]);
                    break;
                default:
            }
        }
    }
}
