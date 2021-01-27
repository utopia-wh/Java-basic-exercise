package classP;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/1/27 18:30
 */
public class MyPhoneMaker {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.hasFigurePrintUnLocker = true;
        phone.price = 1999;
        phone.screen = new Screen();

        phone.screen.producer = "京东方";
        phone.screen.size = 8.8;

        CPU cpu = new CPU();
        cpu.prodcer = "三星";
        cpu.speed = 3.5;

        Memory memory = new Memory();
        memory.capacity = 1024;
        memory.producer = "东芝";

        Storage storage = new Storage();
        storage.capacity = 128;
        storage.producer = "华为";

        phone.mainboard = new Mainboard();
        phone.mainboard.cpu = cpu;
        phone.mainboard.memory = memory;
        phone.mainboard.storage = storage;
        phone.mainboard.model = "ES2020";
        phone.mainboard.year = 2020;
    }
}
