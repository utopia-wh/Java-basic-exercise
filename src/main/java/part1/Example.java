package part1;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/1/4 15:41
 */
public class Example{

    String str=new String("tarena");

    char[]ch={'a','b','c'};

    public static void main(String args[]){

        Example ex=new Example();

        ex.change(ex.str,ex.ch);

        System.out.print(ex.str+" and ");

        System.out.print(ex.ch);

    }

    public void change(String str,char ch[]){

        //引用类型变量，传递的是地址，属于引用传递。

        str="test ok";

        ch[0]='g';

    }

}