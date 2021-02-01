package supermarketTest;

import supermarketTest.person.Customer;
import supermarketTest.supermarket.LittleSupermarket;
import supermarketTest.supermarket.Merchandise;

import java.util.Scanner;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/2/1 11:34
 */
public class RunLittleSupermarketAppMain {

    public static void main(String[] args) {
        /*
         *超市信息初始化
         */
        LittleSupermarket littleSupermarket = new LittleSupermarket();
        littleSupermarket.supermarketName = "益万家超市";
        littleSupermarket.address = "长安";
        littleSupermarket.parkingCount = 200;
        littleSupermarket.merchandises = new Merchandise[200];
        littleSupermarket.merchandiseSold = new int[littleSupermarket.merchandises.length];

        /*
         * 商品信息初始化
         */
        Merchandise all[] = littleSupermarket.merchandises;
        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (Math.random() + 1) * 200;
            all[i] = m;
        }

        /*
         *超市开门做生意了
         */
        System.out.println("欢迎前来选购！！！");
        boolean openFlag = true;
        Scanner scanner = new Scanner(System.in);
        while (openFlag) {
            /*
            *超市信息展示
             */
            System.out.println("欢迎来" + littleSupermarket.supermarketName + "购物");
            System.out.println("本店位于" + littleSupermarket.address);
            System.out.println("本店共有停车位" + littleSupermarket.parkingCount);
            System.out.println("今日营业额为" + littleSupermarket.incomingSum);
            System.out.println("共有商品" + littleSupermarket.merchandises.length + "种");

            /*
            *顾客信息初始化
             */
            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 1000));
            customer.money = (Math.random() + 1) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;

            if (customer.isDrivingCar) {
                if (littleSupermarket.parkingCount > 0) {
                    System.out.println("欢迎" + customer.name + "驾车而来。本店已经为你安排好停车位，停车免费。车位编号为" + littleSupermarket.parkingCount);
                    littleSupermarket.parkingCount--;
                } else {
                    System.out.println("不好意思，本店停车位已满，希望你耐心等待一下！！！");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            //用户花费的钱
            double totalCost = 0;

            // 开始购物
            while (true) {
                System.out.println("本店提供" + all.length + "种商品，欢迎选购。请输入商品编号");
                int index = scanner.nextInt();
                if (index < 0) {
                    break;
                }
                if (index >= all.length) {
                    System.out.println("本店没有这么多商品");
                    continue;
                }
                Merchandise m = all[index];

                System.out.println("你选购的商品名字为" + m.name + "。单价是" + m.soldPrice + "。请问你要购买多少个？");
                int numToBuy = scanner.nextInt();
                if (numToBuy <= 0) {
                    continue;
                }
                if (numToBuy > m.count) {
                    System.out.println("该商品没有那么多库存，欢迎继续选购");
                }
                if (numToBuy * m.purchasePrice + totalCost > customer.money) {
                    System.out.println("请掂量一下自己的钱包吧");
                }


                totalCost += numToBuy * m.soldPrice;
                m.count -= numToBuy;
                littleSupermarket.merchandiseSold[index] += numToBuy;

            }

            customer.money -= totalCost;

            if (customer.isDrivingCar) {
                littleSupermarket.parkingCount++;
            }
            System.out.println("顾客" + customer.name + "共消费了" + totalCost);
            littleSupermarket.incomingSum += totalCost;

            System.out.println("继续营业吗");
            openFlag = scanner.nextBoolean();

        }
        System.out.println("超市关门了");
        System.out.println("今天的营业额为" + littleSupermarket.incomingSum + "。营业情况如下");

        for (int i = 0; i < littleSupermarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = littleSupermarket.merchandiseSold[i];
            if (numSold > 0) {
                //某个商品的营业额
                double incomming = m.soldPrice * numSold;
                //某个商品的净利润
                double netIncomming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "售出了" + numSold + "个,销售额为" + incomming + ",净利润为" + netIncomming);
            }
        }
    }
}
