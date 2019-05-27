package thread2;

import java.util.concurrent.Callable;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 19:24 2019/5/23
 * @Modified By:
 */
public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        int sum = 0;
        return sum;
    }
}

