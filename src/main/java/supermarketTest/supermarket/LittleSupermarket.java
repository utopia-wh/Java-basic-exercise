package supermarketTest.supermarket;

/**
 * @Author wanghu
 * @Description：小超市类
 * @Date 2021/2/1 11:32
 */
public class LittleSupermarket {
    //超市名字
    public String supermarketName;
    //超市地址
    public String address;
    //停车位的数量
    public int parkingCount;
    //收入总和
    public double incomingSum;
    //商品列表
    public Merchandise merchandises[];
    public MerchandiseV2 merchandisesV2[];
    //与merchandises[]数组一一对应，代表相同索引下的商品卖的数量
    public int merchandiseSold[];
}
