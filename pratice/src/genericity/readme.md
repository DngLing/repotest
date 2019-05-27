**1.泛型的特性:**
code:
List<String> stringArrayList = new ArrayList<String>();
List<Integer> integerArrayList = new ArrayList<Integer>();

Class classStringArrayList = stringArrayList.getClass();
Class classIntegerArrayList = integerArrayList.getClass();

if(classStringArrayList.equals(classIntegerArrayList)){
    Log.d("泛型测试","类型相同");
}


输出 C/泛型测试:类型相同
泛型在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。
在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
也就是说，泛型信息不会进入到运行时阶段。
**对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型**。


**2.泛型的使用**
泛型的三种使用方法：泛型类、泛型接口、泛型方法

**3.泛型类**
可以以如下方式创建泛型类
泛型类标识一般规定为大写的字母T,K,V等
class ClassName<泛型类标识1,泛型类标识2>{
    ...
}
例如TClass.java中的描述

例如TClass2.java类
public class TClass2<T>{
    ...
}

在示例化时不指定泛型，他就可以接受任意类型。
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
在指定后就只能插入相同的类型
   //在指定类型后
        TClass2<Integer> intT = new TClass2();
        //intT.setT("123");在指定编译时既报错

**注意**
定义的泛型类，就一定要传入泛型类型实参么？
并不是这样，在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。

泛型的类型参数只能是类类型，不能是简单类型。
不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
if(ex_num instanceof Generic<Number>){   
} 

**3.泛型接口**
定义接口
public interface Tinterface<T>{
    public T get();
}

定义接口的实现时需要声明泛型的类型，不然无法通过编译 
所有实现类中接口使用泛型的方法都要替换成被声明的泛型类型
例如
public class TinterfaceImple implements Tinterface<String>{
    @Override
    public String get(){
        return "anyString";
    }
}

**泛型通配符**
为什么要使用通配符 
对于 两个类Dog Animal 有 Dog extends Animal 
在java中数组是可以斜变得，也就是Dog[] Animal[] 是兼容的
但是集合是不兼容的 比如List<Animai> 和 List<Dog>，这个时候就可以用到统配符。

一、统配符的三种类型
    1.无边界的通配符(Unbounded Wildcards):
      就是<?>, 比如List<?>.
      无边界的通配符的主要作用就是让泛型能够接受未知类型的数据. 
    2.固定上边界的通配符(Upper Bounded Wildcards):
      使用固定上边界的通配符的泛型, 就能够接受指定类及其子类类型的数据. 
      要声明使用该类通配符, 采用<? extends E>的形式, 这里的E就是该泛型的上边界. 
      注意: 这里虽然用的是extends关键字, 却不仅限于继承了父类E的子类, 也可以代指显现了接口E的类. 
    3.固定下边界的通配符(Lower Bounded Wildcards):
      使用固定下边界的通配符的泛型, 就能够接受指定类及其父类类型的数据. 
      要声明使用该类通配符, 采用<? super E>的形式, 这里的E就是该泛型的下边界. 
      注意: 你可以为一个泛型指定上边界或下边界, 但是不能同时指定上下边界.

二、基本使用方法
    *
    *
    1.无边界的统配符使用，以集合list<?>为例(该包下的Main2.java)
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
        //另外，不能操作不确定泛型类型的list进行添加操作，编译会报错,包括add(Object o)
        public static void add(List<?> list){
            //Object o = new Object;
            //list.add(o); 编译报错
            //list.add(1); 编译报错
            list.add(null);//只有.add(null)可以使用
        }
        //再有我们因为我们不能明确得知List<?>是什么泛型 所以只能在使用get()操作时,使用Object类型接受，毕竟都继承于Object
        public static void getTest(List<?> list) { 
            // String s = list.get(0); // 编译报错
            // Integer i = list.get(1); // 编译报错
            Object o = list.get(2);
        }
    }
    *
    *
    2.固定上边界的通配符使用,依然以List为例（见本包下Main3.java）
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
    需要注意的是，我们如上无边界界定的List<?> 一样，对于传入的List<? extend Number> numbers 依然无法使用用add()操作，原理如上
    但是我么可以对List<? extends Number> numbers 做get()操作，只要我们用Number接收它返回的参数
    *
    *
    3.固定下边界的通配符使用，以List为例(Main4.java)
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
    固定下边界的统配符能接收该类与该类的父类
    由于能确定下边界的类型 在addNumbers(List<? super Integer> list) 方法中我们对于传进来任何的List<? super Integer> 参数
    都能往里使用add()方法添加下边界值，与确定上边界值的通配符无论如何都能用上边界类型接受get()返回的值一样的道理。
    当然，我们不能使用get()方法,这是必然的。
    

**泛型方法**
见Main4.java 我们定义了一个泛型类

    
  