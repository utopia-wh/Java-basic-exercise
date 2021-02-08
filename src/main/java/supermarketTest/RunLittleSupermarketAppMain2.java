package supermarketTest;

import supermarketTest.person.Customer;
import supermarketTest.supermarket.LittleSupermarket;
import supermarketTest.supermarket.Merchandise;
import supermarketTest.supermarket.MerchandiseV2;

import java.util.Scanner;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/2/7 22:03
 */
public class RunLittleSupermarketAppMain2 {


    public static void main(String[] args) {
        /*
         *超市信息初始化
         */
        LittleSupermarket littleSupermarket = new LittleSupermarket();
        littleSupermarket.supermarketName = "益万家超市";
        littleSupermarket.address = "长安";
        littleSupermarket.parkingCount = 200;
        littleSupermarket.merchandisesV2 = new MerchandiseV2[200];
        littleSupermarket.merchandiseSold = new int[littleSupermarket.merchandisesV2.length];

        /*
         * 商品信息初始化
         */
        MerchandiseV2 all[] = littleSupermarket.merchandisesV2;
        for (int i = 0; i < all.length; i++) {
            MerchandiseV2 m = new MerchandiseV2();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (Math.random() + 1) * 200;
            all[i] = m;
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引：");
            int index = scanner.nextInt();

            if (index < 0) {
                break;
            }
            if (index >= all.length) {
                System.out.println("商品索引超出界限");
                continue;
            }

            System.out.println("请输入你要购买的数量：");
            int count = scanner.nextInt();

            MerchandiseV2 m = littleSupermarket.merchandisesV2[index];
            double totalCost = m.buy(count);

            System.out.println("选购的商品总价为"+totalCost);
        }
    }
}
