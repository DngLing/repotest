package thread3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 9:35 2019/5/25
 * @Modified By:
 */
public class ServiceManager {
    static volatile CountDownLatch latch;
    static Set<Service> services;

    public static void startService(){
        services = getServices();
        for (Service service : services)
            service.start();
    }

    public static boolean checkServiceStatus(){
        boolean allIsOk = true;

        try {
            //等待服务启动结束(countDown 执行一定次数)
            latch.await();
        } catch (InterruptedException e) {
            return false;
        }

        for (Service service : services){
            if(!service.isStart()){
                allIsOk = false;
                break;
            }
        }
        return allIsOk;
    }

    static Set<Service> getServices(){
        latch = new CountDownLatch(2);
        HashSet<Service> services = new HashSet<>();
        services.add(new SimpleServiceA(latch));
        services.add(new SimpleServiceB(latch));
        return services;
    }
}
