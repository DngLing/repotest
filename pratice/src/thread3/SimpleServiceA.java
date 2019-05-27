package thread3;

import java.util.concurrent.CountDownLatch;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 9:31 2019/5/25
 * @Modified By:
 */
public class SimpleServiceA extends AbstractService {
    public SimpleServiceA(CountDownLatch latch){
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {
        Thread.sleep(3000);
    }
}
