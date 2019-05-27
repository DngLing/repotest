package thread;

import java.util.concurrent.Callable;

/**
 * @Author： Dong
 * @Description: 实现Callable接口的类 并且有返回结果
 * @Date: Created in 19:03 2019/5/23
 * @Modified By:
 */
public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子程序计算中");
        Thread.sleep(3000);
        int sum = 0;
        for (int i=0; i<100; i++){
            sum+=i;
        }
        return sum;
    }
}
