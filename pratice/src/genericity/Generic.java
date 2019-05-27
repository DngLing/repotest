package genericity;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 20:14 2019/5/22
 * @Modified By:
 */
public class Generic<T> {
   private T t;

   public Generic(T t){
       this.t = t;
   }

   //这并不是一个泛型方法，只是一个普通的成员方法
   public T getT(){
       return this.t;
   }

    /**
     * 一个真正的泛型方法
     * 在方法类型与返回之间必须由<T,...>来声明这是一个泛型方法，并声明每一个使用到的泛型
     * public <K,V> V getValue(Generic<K> container){
     *     ...
     * }
     */

    /**
     * 这是一个泛型方法 它明确的声明了使用的泛型类型，并且这个泛型类型在该类中也声明过，若从未声明则不能通过编译
     * @param container 传入一个Generic<T> 泛型
     * @param <T> 声明泛型的标识符
     * @return
     */
    public <T> T showTName1(Generic<T> container){
        System.out.println("containner T:"+ container.getT());
        T result = container.getT();
        return result;
    }

    //这也不是一个泛型方法，只是使用泛型类做为参数的普通方法
    public void showTName2(Generic<T> container){
        System.out.println("containner T:"+ container.getT());
    }

    //这也不是一个泛型方法，只是使用了泛型对象作为参数的普通方法，并且使用了<?>统配符（接受所有类型的Generic<T>泛型对象）
    public void showTName3(Generic<?> container){
        System.out.println("containner T:"+ container.getT());
    }
}
