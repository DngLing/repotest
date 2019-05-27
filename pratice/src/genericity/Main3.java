package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 19:14 2019/5/22
 * @Modified By:
 */
public class Main3 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Float> floats = new ArrayList<>();
        floats.add(1.0f);
        floats.add(2.0f);
        floats.add(3.5f);

        System.out.println(sumOfList(integers));
        System.out.println(sumOfList(floats));
    }

    //使用<? extends E> 来匹配某一类和继承于该类的子类(或者实现E接口的类)
    public static double sumOfList(List<? extends Number> numbers){
        Double sum = 0.0;
        for (Number n: numbers){
            //这里拿到的是上边界类型Number 需要拿到它的double值
            sum += n.doubleValue();
        }
        return sum;
    }
}
