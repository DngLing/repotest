package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 15:47 2019/5/22
 * @Modified By:
 */
public class Main2 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        List<String> strings = new ArrayList<>();
        strings.add("1.");
        strings.add("2.");
        strings.add("3.");
        print(ints);
        print(strings);
    }

    //注意这里不能使用List<Object> 来接受任意类型的List.
    // 虽然所有类继承于Object类,但是集合是不协同的！
    public static void print(List<?> list){
        for (Object o : list){
            System.out.println(o);
        }
    }

    //另外，不能操作不确定泛型类型的list进行添加操作，编译会报错
    public static void add(List<?> list){
        //Object o = new Object();
        //list.add(o);
        //只有.add(null)可以使用
        list.add(null);
    }
}
