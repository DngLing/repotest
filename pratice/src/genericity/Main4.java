package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 19:34 2019/5/22
 * @Modified By:
 */
public class Main4 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        addNumbers(list);
        List<Number> list1 = new ArrayList<>();
        addNumbers(list1);
        List<Double> list2 = new ArrayList<>();
        //addNumbers(list2); 编译报错
    }

    public static void addNumbers(List<? super Integer> list){
        list.add(1);
        list.add(2);

        //Integer i = list.get(1); 编译报错
    }
}
