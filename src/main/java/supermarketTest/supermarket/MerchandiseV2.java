package supermarketTest.supermarket;

import java.lang.invoke.SerializedLambda;

/**
 * @Author wanghu
 * @Description：商品类（带属性和方法）
 * @Date 2021/2/7 17:40
 */
public class MerchandiseV2 {
    //商品名字
    public String name;
    //商品id
    public String id;
    //商品数量
    public int count;
    // 商品进价
    public double soldPrice;
    //商品售价
    public double purchasePrice;

    /*
     *输出商品描述
     */
    public void describe() {
        System.out.println("商品的名字叫做" + name + ",id是" + id + "。商品售价是" + soldPrice + "。商品进价是" + purchasePrice
                + "。商品的库存是" + count + "。销售一个毛利润为" + (soldPrice - purchasePrice));
    }

    /*
     *如果返回为-1 代表购买失败，比如库存不足
     *
     */
    public double buy(int countToBuy) {
        System.out.println("购买商品的单价为："+soldPrice);
        if (countToBuy > count) {
            System.out.println("库存不足");
            return -1;
        }

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;

        double totalCost = fullPriceCount * soldPrice + (halfPriceCount * soldPrice / 2);
        return totalCost;
    }
}
