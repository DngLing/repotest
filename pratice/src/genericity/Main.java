package genericity;

import org.omg.CORBA.INTERNAL;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 14:04 2019/5/22
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        TClass<String,Integer> tClass = new TClass<>();
        tClass.setKey("wo");
        tClass.setVal(123);

        System.out.println("key :"+ tClass.getKey()+" val:"+ tClass.getVal());

        //在不表明泛型类型是，泛型类型可以是任意类型
        TClass2  t1 = new TClass2();
        TClass2  t2 = new TClass2();
        TClass2  t3 = new TClass2();
        TClass2  t4 = new TClass2();
        t1.setT("123");
        t2.setT(123);
        t3.setT(123.00);
        t4.setT(false);
        System.out.println(t1.getT());
        System.out.println(t2.getT());
        System.out.println(t3.getT());
        System.out.println(t4.getT());

        //在插入后某一类型后改变插入的类型也可以
        t1.setT(1);
        System.out.println(t1.getT());

        //在指定类型后
        TClass2<Integer> intT = new TClass2();
        //intT.setT("123");在指定编译时既报错

        TInterface<String> tI = new TInterfaceImpl();
        System.out.println(tI.getT());


    }
}
